package com.ass.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.asm.entity.Favorite;
import com.asm.entity.Report;
import com.asm.entity.Share;
import com.asm.entity.User;
import com.asm.entity.Video;
import com.asm.utils.jpaUtil;
import com.ass.constant.SessionAttr;
import com.ass.dao.ReportDAO;
import com.ass.dao.VideoDAO;
import com.ass.service.EmailService;
import com.ass.service.FavoriteService;
import com.ass.service.ReportService;
import com.ass.service.ShareService;
import com.ass.service.UserService;
import com.ass.service.VideoService;
import com.ass.service.impl.EmailServiceImpl;
import com.ass.service.impl.FavoriteServiceImpl;
import com.ass.service.impl.ReportServiceImpl;
import com.ass.service.impl.ShareServiceImpl;
import com.ass.service.impl.UserServiceImpl;
import com.ass.service.impl.VideoServiceImpl;




/**
 * Servlet implementation class MainUser
 */
@WebServlet({"/HomeControler", "/Favorite"})
public class HomeControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int VIDEO_MAX_PAGE_SIZE = 6;
	
	private ReportService rs = new ReportServiceImpl();
	private VideoService vs = new VideoServiceImpl();
	private FavoriteService fs = new FavoriteServiceImpl();
	private EmailService es = new EmailServiceImpl();
	private ShareService ss = new ShareServiceImpl();
	private UserService us = new UserServiceImpl();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeControler() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		String path = req.getServletPath();
		
		switch (path) {
		case "/HomeControler":
			filltable(req, resp);
			
			break;
		case "/Favorite":
			favorite(req, resp);
			break;
		
		default:
			break;
		}
			
		
	}

	protected void filltable(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		List<Video> countVideo = vs.findAll();
		int maxPage = (int) Math.ceil(countVideo.size()/ (double)VIDEO_MAX_PAGE_SIZE);
		req.setAttribute("maxPage", maxPage);
		String pageNumber = req.getParameter("page");
		List<Video> v;
		if(pageNumber==null) {
			v = vs.findAll(1,VIDEO_MAX_PAGE_SIZE);
			req.setAttribute("currentPage", 1);
		}else {
			v = vs.findAll(Integer.valueOf(pageNumber),VIDEO_MAX_PAGE_SIZE);
			req.setAttribute("currentPage", pageNumber);
		}
		req.setAttribute("v", v);
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		if(u!=null) {
			if (u.getAdmin()) {
			req.getRequestDispatcher("/indexM.jsp").forward(req, resp);
			} else {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}
		}else {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
		
		
	}
	
	private void favorite(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		User currUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		List<Video> v = vs.selectVideoFavByUserId(currUser.getId());
		int maxPage = (int) Math.ceil(v.size()/ (double)VIDEO_MAX_PAGE_SIZE);
		req.setAttribute("maxPage", maxPage);
		
		
		req.setAttribute("v", v);

		req.getRequestDispatcher("/favorites.jsp").forward(req, resp);
		
	}
	
	

}
