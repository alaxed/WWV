package com.ass.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.asm.entity.Favorite;
import com.asm.entity.User;
import com.asm.entity.Video;
import com.ass.dao.FavoriteDAO;
import com.ass.dao.UserDAO;
import com.ass.dao.VideoDAO;
import com.ass.dao.impl.FavoriteDAOImpl;
import com.ass.service.FavoriteService;
import com.ass.service.UserService;

public class FavoriteServiceImpl implements FavoriteService {

	FavoriteDAO dao ;
	UserService udao = new UserServiceImpl() ;
	VideoServiceImpl vdao = new VideoServiceImpl() ;
	
	
	
	public FavoriteServiceImpl() {
		dao = new FavoriteDAOImpl();
	}

	@Override
	public List<Favorite> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Favorite> findByUserLiked(String id) {
		// TODO Auto-generated method stub
		return dao.findByUserLiked(id);
	}


	@Override
	public boolean create(Favorite f) {
		
		Favorite fav = dao.create(f);
		if(fav !=null) {
			return true;
		}
		return false ;
	}
	
	

	@Override
	public Favorite findByUserAndLiked(String user, String video) {
//		User u = udao.findById(user);
//		Video v = vdao.findById(video);
		Favorite f = dao.findByUserAndLiked(user, video);
//		Favorite fv = new Favorite();
//		if(f != null) {
//			f.setUser(u);
//			f.setVideo(v);
//			f.setLikeDate(new Timestamp(System.currentTimeMillis()));
//			fv = dao.delete(fv);
//		}else {
//			f.setUser(u);
//			f.setVideo(v);
//			f.setLikeDate(new Timestamp(System.currentTimeMillis()));
//			fv = dao.create(fv);
//		}
//		
		
		return f;
	}

	@Override
	public boolean delete(Favorite f) {
		Favorite fav = dao.delete(f);
		if(fav !=null) {
			return true;
		}
		return false ;
	}

	@Override
	public List<Favorite> findByVideoLiked(String id) {
		return dao.findByVideoIsLiked(id);
	}

}
