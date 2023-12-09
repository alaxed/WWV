package com.ass.service;

import java.util.List;

import com.asm.entity.Favorite;
import com.asm.entity.Share;

public interface ShareService {
	List<Share> findAll();
	List<Share> findByUserShared(String id);
	List<Share> findByVideoIsShared(String id);
	Share	findByUserAndLiked(String user, String video);
	Share create(Share f);
}
