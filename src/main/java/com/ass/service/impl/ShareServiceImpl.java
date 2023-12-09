package com.ass.service.impl;

import java.util.List;

import com.asm.entity.Favorite;
import com.asm.entity.Share;
import com.ass.dao.ShareDAO;
import com.ass.dao.impl.ShareDAOImpl;
import com.ass.service.ShareService;

public class ShareServiceImpl implements ShareService {
	ShareDAO dao;
	
	public ShareServiceImpl() {
		dao = new ShareDAOImpl();
	}
	@Override
	public List<Share> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Share> findByUserShared(String id) {
		// TODO Auto-generated method stub
		return dao.findByUserShared(id);
	}

	@Override
	public Share create(Share f) {
		
		return dao.create(f);
	}
	@Override
	public Share findByUserAndLiked(String user, String video) {
		// TODO Auto-generated method stub
		return dao.findByUserAndLiked(user, video);
	}
	@Override
	public List<Share> findByVideoIsShared(String id) {
		// TODO Auto-generated method stub
		return dao.findByVideoIsShared(id);
	}

}
