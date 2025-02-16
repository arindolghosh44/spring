package com.aec.util;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.aec.model.Category;
import com.aec.model.ProductOrder;
import com.aec.model.UserDtls;
import com.aec.service.UserService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class CommonUtil {

	
	@Autowired
	private JavaMailSender mailSender;
	
	
	//for whatspp sending
	
	
	
	 @Value("${twilio.account.sid}")
	    private String accountSid;

	    @Value("${twilio.auth.token}")
	    private String authToken;

	    @Value("${twilio.whatsapp.number}")
	    private String twilioWhatsAppNumber;

	
	
	@Autowired
	private UserService userService;
	
	public Boolean sendMail(String url, String reciepentEmail) throws UnsupportedEncodingException, MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("t01666122@gmail.com", "Urban Cart");
		helper.setTo(reciepentEmail);

		String content = "<p>Hello,</p>" + "<p>You have requested to reset your password.</p>"
				+ "<p>Click the link below to change your password:</p>" + "<p><a href=\"" + url
				+ "\">Change my password</a></p>";
		helper.setSubject("Password Reset");
		helper.setText(content, true);
		mailSender.send(message);
		return true;
	}
	
	public static String generateUrl(HttpServletRequest request) {

		// http://localhost:8080/forgot-password
		String siteUrl = request.getRequestURL().toString();

		return siteUrl.replace(request.getServletPath(), "");

	}
	
	String msg=null;
	
	
	public Boolean sendMailForProductOrder(ProductOrder order,String status) throws Exception
	{
		
		msg="<p>Hello [[name]],</p>"
				+ "<p>Thank you order <b>[[orderStatus]]</b>.</p>"
				+ "<p><b>Product Details:</b></p>"
				+ "<p>Name : [[productName]]</p>"
				+ "<p>Category : [[category]]</p>"
				+ "<p>Quantity : [[quantity]]</p>"
				+ "<p>Price : [[price]]</p>"
				+"<p>TotalPrice : [[totalprice]]</p>"
				+ "<p>Payment Type : [[paymentType]]</p>";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("t01666122@gmail.com", "Urban Cart");
		helper.setTo(order.getOrderAddress().getEmail());

		msg=msg.replace("[[name]]",order.getOrderAddress().getFirstName());
		msg=msg.replace("[[orderStatus]]",status);
		msg=msg.replace("[[productName]]", order.getProduct().getTitle());
		msg=msg.replace("[[category]]", order.getProduct().getCategory());
		msg=msg.replace("[[quantity]]", order.getQuantity().toString());
		msg=msg.replace("[[price]]", order.getPrice().toString());
		msg=msg.replace("[[totalprice]]", order.getTotalPrice().toString());
		msg=msg.replace("[[paymentType]]", order.getPaymentType());
		
		helper.setSubject("Product Order Status");
		helper.setText(msg, true);
		mailSender.send(message);
		return true;
	}
	
	public UserDtls getLoggedInUserDetails(Principal p) {
		String email = p.getName();
		UserDtls userDtls = userService.getUserByEmail(email);
		return userDtls;
	}
	
	public void sendMailWithCustomContent(String recipientEmail, String subject, String content) 
            throws UnsupportedEncodingException, MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("t01666122@gmail.com", "UrbanKart");
        helper.setTo(recipientEmail);
        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }
	
	
	public void sendEmailToAllAdminsOnNewCategory(Category newCategory) {
	    // Fetch all users with ROLE_ADMIN
	    List<UserDtls> admins = userService.getUsers("ROLE_ADMIN");
	    
	    // List<UserDtls> admins = userService.getUsersByRole("ROLE_SUPERADMIN");

	    // Create email subject and content
	    String subject = "New Category Added: " + newCategory.getName();
	    String content = "<p>A new category has been added:</p>"
	            + "<p><strong>Name:</strong> " + newCategory.getName() + "</p>"
	            + "<p><strong>Status:</strong> " + (newCategory.getIsActive() ? "Active" : "Inactive") + "</p>"
	            + "<p><strong>Image:</strong> " + (newCategory.getImageName() != null ? newCategory.getImageName() : "No image") + "</p>";

	    // Send email to each admin
	    for (UserDtls admin : admins) {
	        try {
	            sendMailWithCustomContent(admin.getEmail(), subject, content);
	        } catch (UnsupportedEncodingException | MessagingException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	 // ✅ SEND EMAIL + WHATSAPP MESSAGE TO ADMINS
    public void sendNotificationsToAdmins(Category newCategory) {
        List<UserDtls> admins = userService.getUsers("ROLE_ADMIN");

        String subject = "New Category Added: " + newCategory.getName();
        String content = "<p>A new category has been added:</p>"
                + "<p><strong>Name:</strong> " + newCategory.getName() + "</p>"
                + "<p><strong>Status:</strong> " + (newCategory.getIsActive() ? "Active" : "Inactive") + "</p>"
                + "<p><strong>Image:</strong> " + (newCategory.getImageName() != null ? newCategory.getImageName() : "No image") + "</p>";

        String whatsappMessage = "📢 New Category Added! ✅\n"
                + "📌 *Name:* " + newCategory.getName() + "\n"
                + "📌 *Status:* " + (newCategory.getIsActive() ? "Active" : "Inactive") + "\n"
                + "📌 *Image:* " + (newCategory.getImageName() != null ? newCategory.getImageName() : "No image") + "\n"
                + "➡️ Check Admin Panel for details.";

        for (UserDtls admin : admins) {
            try {
                // SEND EMAIL
                sendMailWithCustomContent(admin.getEmail(), subject, content);
                System.out.println("Email sent to: " + admin.getEmail());

                // SEND WHATSAPP MESSAGE
                sendWhatsAppNotification(admin.getMobileNumber(), whatsappMessage);
            } catch (Exception e) {
                System.err.println("Failed to notify admin: " + admin.getEmail() + " - " + e.getMessage());
            }
        }
    }

    // ✅ SEND WHATSAPP NOTIFICATION
    public void sendWhatsAppNotification(String adminPhoneNumber, String message) {
        try {
            Twilio.init(accountSid, authToken);

            Message.creator(
                    new com.twilio.type.PhoneNumber("whatsapp:" + adminPhoneNumber), // Recipient WhatsApp
                    new com.twilio.type.PhoneNumber("whatsapp:" + twilioWhatsAppNumber), // Twilio WhatsApp
                    message
            ).create();

            System.out.println("WhatsApp Notification sent to: " + adminPhoneNumber);
        } catch (Exception e) {
            System.err.println("Failed to send WhatsApp notification to " + adminPhoneNumber + ": " + e.getMessage());
        }
    }
	
	
}
