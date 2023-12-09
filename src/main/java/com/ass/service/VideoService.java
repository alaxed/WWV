package com.ass.service;

import java.util.List;

import com.asm.entity.Video;

public interface VideoService {
	Video findById(String id);
	List<Video> findAll();
	List<Video> findAll(Integer pageNumber, Integer pageSize);
	List<Video> find6V();
	List<Video> selectVideoFavByUserId(String userId);
	Video findByTitle(String title);
	Video create(Video v);
	Video update(Video v);
	Video delete(String id);
}
