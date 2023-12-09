package com.ass.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContext;

import com.asm.entity.User;
import com.asm.utils.SendMailUtil;
import com.ass.service.EmailService;

public class EmailServiceImpl implements EmailService{

	private static final String EMAIL_WELCOME_SUBJECT = "Welcome to online entertaiment";
	private static final String EMAIL_FORGOT_PASSWORD = "Online Entertaiment - New Password!";
	
	@Override
	public void sendMail(User recipient, String type) {
		
		
		try {
			 String content = null;
			 String subject = null;
			switch (type) {
			case "welcome":
				subject = EMAIL_WELCOME_SUBJECT;
				content = "Dear + " + recipient.getId() + ", hope you have a good time!";
				break;

			case "forgot":
				subject = EMAIL_FORGOT_PASSWORD;
				content = "Dear + " + recipient.getId() + ", Your new Password is: " + recipient.getPassword();
				break;

			}
			SendMailUtil.sendEmail(recipient.getEmail(), subject, content);; 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void mailShareVideo(String toU, User fromU, String video) {
		String subject = "SHARE VIDEO";
		String content = "Dear + " + toU + ": Bạn nhận được video chia sẽ từ"  + fromU.getId() +  ":" + video;

		try {
			SendMailUtil.sendEmail(toU, subject, content);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
