package jpa.map.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jpa.map.model.Customer;
import jpa.map.service.CustomerService;

import jpa.map.model.Customer;
import jpa.map.model.Item;
import jpa.map.service.CustomerService;
import jpa.map.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService; // Inject the Item Service

    // Show Customers Page with Items for Dropdown
    @GetMapping("/customers")
    public String getCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        List<Item> items = itemService.getAllItems(); // Fetch items for dropdown

        model.addAttribute("customers", customers);
        model.addAttribute("items", items); // Add items to the model
        return "customer";
    }

    @PostMapping("/customers")
    public String saveCustomer(@RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam(value = "itemId", required = false) Long itemId) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);

        if (itemId != null) {
            Item item = itemService.getItemById(itemId);
            customer.setItem(item);
        }

        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

}
