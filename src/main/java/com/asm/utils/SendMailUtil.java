package com.asm.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailUtil {
	  public static void sendEmail( String toAddress, String subject, String message) throws AddressException, MessagingException {
		  
		  Properties p = new Properties();
			 p.put("mail.smtp.host", "smtp.gmail.com");
			 p.put("mail.smtp.port", "465");
			 p.put("mail.smtp.auth", "true");
			 p.put("mail.smtp.starttls.enable", "true");
			 p.put("mail.smtp.starttls.required", "true");
			 p.put("mail.smtp.ssl.protocols", "TLSv1.2");
			 p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			 final String username = "ktn39251@gmail.com";
				final String password = "qqqiawdxqomjyjof";

			Session s = Session.getInstance(p, new javax.mail.Authenticator() {
	          @Override
	          protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	              return new javax.mail.PasswordAuthentication(username, password);
	          }
			});
			
			try {
	        	Message msg = new MimeMessage(s);
	        	 msg.setFrom(new InternetAddress(username));
	             InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
	             msg.setRecipients(Message.RecipientType.TO, toAddresses);
	             msg.setSubject(subject);
	             msg.setSentDate(new Date());
	             msg.setText(message);
	      
	            Transport.send(msg);
	            System.out.println("Gui thanh cong!");
	    
			} catch (Exception e) {
				System.out.println(e);
			}
		  
	  }
}
