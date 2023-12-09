package com.ass.dao;

import java.util.List;

import com.asm.entity.Favorite;

public interface FavoriteDAO {
	List<Favorite> findAll();
	List<Favorite> findByUserLiked(String id);
	List<Favorite> findByVideoIsLiked(String id);
	Favorite findByUserAndLiked(String user, String video);
	Favorite create(Favorite f);
	Favorite delete(Favorite f);
	

	
	
}
