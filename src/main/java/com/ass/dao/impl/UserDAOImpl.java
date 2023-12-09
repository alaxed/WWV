package com.ass.dao.impl;

import java.util.List;

import com.asm.entity.User;
import com.ass.dao.OEDAO;
import com.ass.dao.UserDAO;

public class UserDAOImpl extends OEDAO<User> implements UserDAO {

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		String jpql = "select o from User o where o.email = ?0";
		return super.findOne(User.class, jpql, email);
	}

	@Override
	public User findByAndPass(String id, String pass) {
		String jpql = "select o from User o where o.id = ?0 and o.password = ?1";
		return super.findOne(User.class, jpql, id, pass);
	}

	@Override
	public List<User> findAll() {
		return super.findAll(User.class, true);
	}

	@Override
	public User create(User u) {
		
		return super.create(u);
	}

	@Override
	public User update(User u) {
		
		return super.update(u);
	}

	@Override
	public User delete(String id) {
		User u = findById(id);
		return super.delete(u);
	}

	@Override
	public List<User> findAll(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		return super.findAll(User.class, true, pageNumber, pageSize);
	}

	@Override
	public User resetPass(User u) {
		return super.update(u);
	}

	@Override
	public User findByIdAndemail(String id, String email) {
		String jpql = "select o from User o where o.id = ?0 and o.email = ?1";
		return super.findOne(User.class, jpql, id, email);
	}

	@Override
	public List<User> findUserLikedByVideo(String video) {
		String jpql = "SELECT f.user FROM Favorite f where f.video.id= ?0";
		return super.finMany(User.class, jpql, video);
	}
 
}
