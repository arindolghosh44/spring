package com.ride.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ride.model.Car;
import com.ride.repository.CarRepository;
import com.ride.service.CarService;
import com.ride.util.CommonUtil;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarRepository carRepository;
	
	 @Autowired
	 private CommonUtil commonUtil;
	
	@Override
	public Car saveProduct(Car product) {
		// Save the product
	    Car savedProduct = carRepository.save(product);

	    // Send email to all admins about the new product
	    commonUtil.sendEmailToAllAdminsOnNewProduct(savedProduct);

	    return savedProduct;
	}

	@Override
	public List<Car> getAllProducts() {
		return carRepository.findAll();
	}

	@Override
	public Page<Car> getAllProductsPagination(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return carRepository.findAll(pageable);
	}

	@Override
	public Boolean deleteProduct(Integer id) {
		Car product = carRepository.findById(id).orElse(null);

		if (!ObjectUtils.isEmpty(product)) {
			carRepository.delete(product);
			 commonUtil.sendEmailToAllAdminsOnProductDeletion(product);
			return true;
		}
		return false;
	}

	@Override
	public Car getProductById(Integer id) {
		Car product = carRepository.findById(id).orElse(null);
		return product;
	}

	@Override
	public Car updateProduct(Car product, MultipartFile image) {

		Car dbProduct = getProductById(product.getId());

		String imageName = image.isEmpty() ? dbProduct.getImage() : image.getOriginalFilename();

		dbProduct.setPlateId(product.getPlateId());
		dbProduct.setModel(product.getModel());
		dbProduct.setMake(product.getMake());
		
		String db = product.getYear().toString();
		String yearDate = db.substring(0, 10);  // Extract "yyyy-MM-dd"
		dbProduct.setYear(yearDate);  // Directly set the extracted date

		dbProduct.setCategory(product.getCategory());
		dbProduct.setPrice(product.getPrice());
		dbProduct.setStock(product.getStock());
		dbProduct.setImage(imageName);
		dbProduct.setIsActive(product.getIsActive());
		dbProduct.setDiscount(product.getDiscount());

		// 5=100*(5/100); 100-5=95
		Double disocunt = (double) Math.round(product.getPrice() * (product.getDiscount() / 100.0));
		Double discountPrice = (double) Math.round(product.getPrice() - disocunt);
		dbProduct.setDiscountPrice(discountPrice);

		Car updateProduct = carRepository.save(dbProduct);

		if (!ObjectUtils.isEmpty(updateProduct)) {

			if (!image.isEmpty()) {

				try {
					File saveFile = new ClassPathResource("static/img").getFile();

					Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "product_img" + File.separator
							+ image.getOriginalFilename());
					Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			 commonUtil.sendEmailToAllAdmins(product);
			return product;
		}
		return null;
	}

	@Override
	public List<Car> getAllActiveProducts(String category) {
		List<Car> products = null;
		if (ObjectUtils.isEmpty(category)) {
			products = carRepository.findByIsActiveTrue();
		} else {
			products = carRepository.findByCategory(category);
		}

		return products;
	}

	@Override
	public List<Car> searchProduct(String ch) {
		return carRepository.findByModelContainingIgnoreCaseOrCategoryContainingIgnoreCase(ch, ch);
	}

	@Override
	public Page<Car> searchProductPagination(Integer pageNo, Integer pageSize, String ch) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return carRepository.findByModelContainingIgnoreCaseOrCategoryContainingIgnoreCase(ch, ch, pageable);
	}

	@Override
	public Page<Car> getAllActiveProductPagination(Integer pageNo, Integer pageSize, String category) {

		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Car> pageProduct = null;

		if (ObjectUtils.isEmpty(category)) {
			pageProduct = carRepository.findByIsActiveTrue(pageable);
		} else {
			pageProduct = carRepository.findByCategory(pageable, category);
		}
		return pageProduct;
	}
	
	
	
	
	@Override
	public Page<Car> searchActiveProductPagination(Integer pageNo, Integer pageSize, String category, String ch) {

		Page<Car> pageProduct = null;
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		pageProduct = carRepository.findByisActiveTrueAndModelContainingIgnoreCaseOrCategoryContainingIgnoreCase(ch,
				ch, pageable);

//		if (ObjectUtils.isEmpty(category)) {
//			pageProduct = productRepository.findByIsActiveTrue(pageable);
//		} else {
//			pageProduct = productRepository.findByCategory(pageable, category);
//		}
		return pageProduct;
	}

	public List<Car> getAllAvailableCars() {
	    return carRepository.findByIsActiveTrueAndStockGreaterThan(0);
	}

	
	

}
