package com.ass.service;

import java.util.List;

import com.asm.entity.Favorite;

public interface FavoriteService {
	List<Favorite> findAll();
	List<Favorite> findByUserLiked(String id);
	List<Favorite> findByVideoLiked(String id);
	Favorite findByUserAndLiked(String user, String video);
	boolean delete(Favorite f);
	boolean create(Favorite f);

}
