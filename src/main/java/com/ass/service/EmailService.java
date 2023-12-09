package com.ass.service;

import javax.servlet.ServletContext;

import com.asm.entity.User;

public interface EmailService {
	void sendMail( User recipient, String type);
	void mailShareVideo(String toU, User fromU, String video);
}
