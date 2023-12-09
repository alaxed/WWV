package com.ass.dao.impl;

import java.util.List;

import com.asm.entity.Favorite;
import com.asm.entity.Share;
import com.ass.dao.OEDAO;
import com.ass.dao.ShareDAO;

public class ShareDAOImpl extends OEDAO<Share> implements ShareDAO {

	@Override
	public List<Share> findAll() {
		
		return super.findAll(Share.class, false);
	}

	@Override
	public List<Share> findByUserShared(String id) {
		String jpql = "SELECT f FROM Share f where f.user.id= ?0";
		return super.finMany(Share.class, jpql, id);
	}

	

	@Override
	public Share create(Share s) {
		// TODO Auto-generated method stub
		return super.create(s);
	}

	@Override
	public Share findByUserAndLiked(String user, String video) {
		String jpql = "SELECT f FROM Share f where f.user.id= ?0 and f.video.id= ?1";
		return super.findOne(Share.class, jpql, user, video);
		
	}

	@Override
	public List<Share> findByVideoIsShared(String id) {
		String jpql = "SELECT f FROM Share f where f.video.id= ?0";
		return super.finMany(Share.class, jpql, id);
	}

}
