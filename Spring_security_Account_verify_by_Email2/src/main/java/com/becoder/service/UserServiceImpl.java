package com.becoder.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.becoder.entity.User;
import com.becoder.repository.UserRepo;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	
	
	public User saveUser(User user,String url) {
		
	String password=passwordEncoder.encode(user.getPassword());
	user.setPassword(password);
	user.setEnable(false);
	user.setVerificationCode(UUID.randomUUID().toString());
	
	User user1=	userRepo.save(user);
	
	if(user1!=null)
	{
		sendEmail(user1,url);
	}
	
		return user1;
	}

	@Override
	public void remeoveMsg() {
	HttpSession session=((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		 session.removeAttribute("msg");
	}

	@Override
	public void sendEmail(User user, String url) {
	
		String from="arindolghosh78@gmail.com";
		String to=user.getEmail();
		String subject="Account Verification";
		String content="Dear [[name]],<br>"+"Please click the link below to verify your registration:<br>"+"<h3><a href=\"[[URL]]\"target=\"_self\">VERIFY</a></h3>"+"Thank You,<br>"+"Arindol";                                                                              
		
		try {
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message);
			
			helper.setFrom(from,"Email verification");
			helper.setTo(to);
			helper.setSubject(subject);
			
			
			
			content=content.replace("[[name]]", user.getFullName());
			String siteUrl=url+"/verify?code="+user.getVerificationCode();
			
			
			
			//System.out.println(siteUrl);
			
			
			
			content=content.replace("[[URL]]", siteUrl);
			
			helper.setText(content,true);
			mailSender.send(message);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public boolean verifyaccount(String verificationcode) {
	
		
		User user=userRepo.findByVerificationCode(verificationcode);
		
		if(user==null)
		{
			return false;
		}
		
		else {
			
			
			user.setEnable(true);
			user.setVerificationCode(null);
			userRepo.save(user);
			return true;
		}
		
		
		
		
		
		
		
		
		
		
	}

}
