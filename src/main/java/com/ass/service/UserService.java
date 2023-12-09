package com.ass.service;

import java.util.List;

import com.asm.entity.User;

public interface UserService {
	
	User findById(String id);
	User findByEmail(String email);
	User login(String id, String pass );
	User forgotPass(String pass);
	List<User> findAll();
	List<User> findAll(Integer pageNumber, Integer pageSize);
	List<User> findUserLikedByVideo(String video);
	User resetPass(String email);
	boolean checkEmail(String id, String email);
	User findByIdAndemail(String id, String email );
	User create(String username, String pass,String fullname, String email);
	User update(User u);
	User delete(String id);
	
	
}
