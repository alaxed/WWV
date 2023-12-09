package com.ass.dao.impl;

import java.util.List;

import com.asm.entity.Favorite;
import com.ass.dao.FavoriteDAO;
import com.ass.dao.OEDAO;

public class FavoriteDAOImpl extends OEDAO<Favorite> implements FavoriteDAO {

	@Override
	public List<Favorite> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(Favorite.class, false);
	}

	@Override
	public List<Favorite> findByUserLiked(String id) {
		String jpql = "SELECT f FROM Favorite f where f.user.id= ?0";
		return super.finMany(Favorite.class, jpql, id);
	}

	@Override
	public Favorite create(Favorite f) {
		return super.create(f);
	}
	
	@Override
	public Favorite delete(Favorite f) {
		return super.delete(f);
	}

	@Override
	public Favorite findByUserAndLiked(String user, String video) {
		String jpql = "SELECT f FROM Favorite f where f.user.id= ?0 and f.video.id= ?1";
		return findOne(Favorite.class, jpql, user, video);
	}

	@Override
	public List<Favorite> findByVideoIsLiked(String id) {
		String jpql = "SELECT f FROM Favorite f where f.video.id= ?0";
		return super.finMany(Favorite.class, jpql, id);
	}

}
