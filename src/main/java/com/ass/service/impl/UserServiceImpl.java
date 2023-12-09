package com.ass.service.impl;

import java.util.List;
import java.util.Random;

import com.asm.entity.User;
import com.ass.dao.UserDAO;
import com.ass.dao.impl.UserDAOImpl;
import com.ass.service.UserService;

public class UserServiceImpl implements UserService  {

	private UserDAO dao;
	
	public UserServiceImpl() {
		dao = new UserDAOImpl();
	}
	
	@Override
	public User findById(String id) {
		
		return dao.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}

	@Override
	public User login(String id, String pass) {
		// TODO Auto-generated method stub
		return dao.findByAndPass(id, pass);
	}

	@Override
	public User forgotPass(String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<User> findAll(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public User create(String username, String pass, String fullname, String email) {
		User u = new User();
		u.setEmail(email);
		u.setId(username);
		u.setPassword(pass);
		u.setFullname(fullname);
		u.setAdmin(false);
		return dao.create(u);
	}

	@Override
	public User update(User u) {
		return dao.update(u);
	}

	@Override
	public User delete(String id) {
		return dao.delete(id);
	}

	@Override
	public User resetPass(String email) {
		User u = findByEmail(email);
		if(u!=null) {
			// Math.random() *  ((9999-1000) + 1)+ 1000 
			String newPass = String.valueOf(new Random().nextInt(9000) + 1000);
			u.setPassword(newPass);
			dao.update(u);
		}
		return u;
	}

	@Override
	public User findByIdAndemail(String id, String email) {
		
		return dao.findByIdAndemail(id, email);
	}

	@Override
	public boolean checkEmail(String id, String email) {
		User u = dao.findById(id);
		if(u !=null && email.contentEquals(u.getEmail())) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> findUserLikedByVideo(String video) {
		return dao.findUserLikedByVideo(video);
	}
	
	
	
}
