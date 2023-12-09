package com.ass.dao.impl;

import java.util.List;

import com.asm.entity.Video;
import com.ass.dao.OEDAO;
import com.ass.dao.VideoDAO;

public class VideoDAOImpl extends OEDAO<Video> implements VideoDAO {

	@Override
	public Video findById(String id) {
		// TODO Auto-generated method stub
		return super.findById(Video.class, id);
	}

	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		
		return super.findAll(Video.class, true);
	}

	@Override
	public List<Video> findAll(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		return super.findAll(Video.class, true, pageNumber, pageSize);
	}

	@Override
	public Video create(Video v) {
		// TODO Auto-generated method stub
		return super.create(v);
	}

	@Override
	public Video update(Video v) {
		// TODO Auto-generated method stub
		return super.update(v);
	}

	@Override
	public Video delete(Video v) {
		
		return super.delete(v);
	}

	@Override
	public List<Video> find6V() {
		String jpql = "SELECT v FROM Video v ORDER BY FUNCTION('NEWID')";
		
		return super.finMany(Video.class, jpql);
	}

	@Override
	public List<Video> selectVideoFavByUserId(String userId) {
		String jpql = "SELECT f.video FROM Favorite f where f.user.id = ?0";
		return super.finMany(Video.class, jpql, userId);
	}

	@Override
	public Video findByTitle(String title) {
		String jpql = "select o from Video o where o.title = ?0";
		return findOne(Video.class, jpql, title);
	}

}
