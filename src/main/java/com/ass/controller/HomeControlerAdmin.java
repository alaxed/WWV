package com.ass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.asm.entity.User;
import com.asm.entity.Video;
import com.ass.constant.SessionAttr;
import com.ass.service.FavoriteService;
import com.ass.service.ReportService;
import com.ass.service.VideoService;
import com.ass.service.impl.FavoriteServiceImpl;
import com.ass.service.impl.ReportServiceImpl;
import com.ass.service.impl.VideoServiceImpl;

/**
 * Servlet implementation class HomeControlerAdmin
 */
@WebServlet({"/indexAmin", "/videos","/users","/report"})
public class HomeControlerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
private static final int VIDEO_MAX_PAGE_SIZE = 6;
	
	private ReportService rs = new ReportServiceImpl();
	private VideoService vs = new VideoServiceImpl();
	private FavoriteService fs = new FavoriteServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeControlerAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		String path = req.getServletPath();
		
		switch (path) {
		case "/indexAmin":
			filltable(req, resp);
			
			break;
		case "/videos":
			filltable(req, resp);
			
			break;
		case "/users":
			filltable(req, resp);
			
			break;
		case "/reports":
			filltable(req, resp);
			
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
		req.getRequestDispatcher("/indexM.jsp").forward(req, resp);
	}
	

	private void videos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		req.getRequestDispatcher("/video.jsp").forward(req, resp);
		
		
		
	}
	
	

}
