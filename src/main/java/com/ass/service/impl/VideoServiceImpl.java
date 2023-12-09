package com.ass.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.asm.entity.Video;
import com.ass.dao.VideoDAO;
import com.ass.dao.impl.VideoDAOImpl;
import com.ass.service.VideoService;

public class VideoServiceImpl implements VideoService {

	private VideoDAO dao;
	
	
	
	public VideoServiceImpl() {
		dao = new VideoDAOImpl();
	}

	@Override
	public Video findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Video> findAll(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public Video create(Video v) {
		// TODO Auto-generated method stub
		return dao.create(v);
	}

	@Override
	public Video update(Video v) {
		
		return dao.update(v);
	}

	@Override
	public Video delete(String id) {
		// TODO Auto-generated method stub
		Video v = new Video();
		v = dao.findById(id);
		return dao.delete(v);
	}

	@Override
	public List<Video> find6V() {
		
		List<Video> v = dao.find6V();
		
		return v;
	}

	@Override
	public List<Video> selectVideoFavByUserId(String userId) {
		return dao.selectVideoFavByUserId(userId);
	}

	@Override
	public Video findByTitle(String title) {
		
		return dao.findByTitle(title);
	}

}
