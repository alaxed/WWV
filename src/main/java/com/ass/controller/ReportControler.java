package com.ass.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asm.entity.Favorite;
import com.asm.entity.Report;
import com.asm.entity.User;
import com.asm.entity.Video;
import com.asm.entity.Share;
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
 * Servlet implementation class ReportControler
 */
@WebServlet({ "/Report","/rpFavorite", "/rpFavUser", "/rpShared"})
public class ReportControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private UserService us = new UserServiceImpl();
	 private ReportService rs = new ReportServiceImpl();
	 private VideoService vs = new VideoServiceImpl();
	 private FavoriteService fs = new FavoriteServiceImpl();
	 private ShareService ss = new ShareServiceImpl();
	 List<String> videoTitle = null;
	 String titleSelected = null;
	 Integer tabIndex = 1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportControler() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	String path = req.getServletPath();
    	
    	
    	switch (path) {
    	case "/Report":
    		report(req, resp);
		
		default:
			break;
		}
    }
    
    private void report(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	reFavorites(req, resp);	
    	reFavUser(req, resp);
    	reShared(req, resp);
    	req.getRequestDispatcher("/report.jsp").forward(req, resp);
    }
    
    private void reFavorites(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	List<Report> r = rs.selectFavCountLiked();
    	req.setAttribute("r", r);
    	tabIndex = 1;
    	req.setAttribute("tabIndex", tabIndex);
    	
    }
    private void reFavUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	String method = req.getMethod();
    	if(method.equalsIgnoreCase("post")) {
	    	String titile = req.getParameter("title");
	    	Video videoT = vs.findByTitle(titile);
	    	List<User> u = us.findUserLikedByVideo(videoT.getId());
	    	List<Favorite> f =  fs.findByVideoLiked(videoT.getId());
	    	titleSelected = titile;
	    	req.setAttribute("Users", u);
	    	req.setAttribute("LikeDate", f);
	    	tabIndex = 2;
	    	req.setAttribute("tabIndex", tabIndex);
	    	setTitleSelected(req, resp);
	    	req.getRequestDispatcher("/report.jsp").forward(req, resp);
    	}
    	setTitleSelected(req, resp);
    	
    	
    }
    
    public void setTitleSelected(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


			videoTitle = new ArrayList<>();
			List<Video> videoLs = vs.findAll();
			for (Video v : videoLs) {
				videoTitle.add(v.getTitle());
			}
			request.setAttribute("videotitle", videoTitle);
			if (titleSelected != null) {
				request.setAttribute("titleSelected", titleSelected);
			}
		
	}
    
    private void reShared(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String method = request.getMethod();
    	if(method.equalsIgnoreCase("post")) {
    		String titile = request.getParameter("title");
	    	Video videoT = vs.findByTitle(titile);
	    	List<User> u = us.findUserLikedByVideo(videoT.getId());
	    	List<Favorite> f =  fs.findByVideoLiked(videoT.getId());
	    	List<Share> s =  ss.findByVideoIsShared(videoT.getId());
	    	request.setAttribute("fav", s);
	    	tabIndex = 3;
	    	request.setAttribute("tabIndex", tabIndex);
	    	setTitleSelected(request, response);
	    	request.getRequestDispatcher("/report.jsp").forward(request, response);
    	}
    	setTitleSelected(request, response);
    	
    }
    
    
    
    
    
}
