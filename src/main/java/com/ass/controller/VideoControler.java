package com.ass.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

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
import com.ass.constant.SessionAttr;
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

@WebServlet({"/video", "/share"})
public class VideoControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FavoriteService fs = new FavoriteServiceImpl();
	private ReportService rs = new ReportServiceImpl();
	private VideoService vs = new VideoServiceImpl();
	private UserService us = new UserServiceImpl();
	private ShareService ss = new ShareServiceImpl();
	private EmailService es = new EmailServiceImpl();
	public VideoControler() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String action = request.getParameter("action");
		String id = request.getParameter("idV");
		HttpSession session = request.getSession();
		if(uri.contains("share")) {
			share(session, id, request, response);
		}else {
			if (action.equalsIgnoreCase("watch")) {
			watch(session, id, request, response);
			} else if (action.equalsIgnoreCase("like")) {
				like(session, id, request, response);
			} 
		}
		
	}

	private void like(HttpSession session, String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User currUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		Favorite f = fs.findByUserAndLiked(currUser.getId(), id);
		User u = us.findById(currUser.getId());
		Video v = vs.findById(id);
		System.out.println(currUser.getId());
		if (f != null) {
			boolean i = fs.delete(f);
			System.out.println("successfull delete");
			watch(session, id, request, response);
		} else if(f==null) {
			Favorite f2 = new Favorite(); 
			f2.setUser(u);
			f2.setVideo(v);
			f2.setLikeDate(new Timestamp(System.currentTimeMillis()));
			boolean i = fs.create(f2);
			watch(session, id, request, response);
		}

	}

	private void watch(HttpSession session, String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Video v = vs.findById(id);
		List<Video> rdV = vs.find6V();
		Report r = rs.selectLike(id);
		
		System.out.println(r.getGroup());
		User currUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		if(currUser!=null) {
			Favorite f = fs.findByUserAndLiked(currUser.getId(), id);
			if(f == null) {
				request.setAttribute("flagLiked", false);
			}else {
				request.setAttribute("flagLiked", true);
			}
		}
		

		request.setAttribute("v", v);
		request.setAttribute("r", r);
		request.setAttribute("rdV", rdV);
		request.getRequestDispatcher("/detail.jsp").forward(request, response);

	}
	
	private void share(HttpSession session, String id,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		User currUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		String toEmail = req.getParameter("email");
		String linkvideo = "http://alaxed:8080/com.asm/video?action=watch&idV="+id;
		Share s = ss.findByUserAndLiked(currUser.getId(), id);
		User u = us.findById(currUser.getId());
		Video v = vs.findById(id);
		es.mailShareVideo(toEmail, currUser, linkvideo);
		if(s!=null) {
			System.out.println("Data đã tồn tại");
		}else {
			Share f2 = new Share(); 
			f2.setUser(u);
			f2.setVideo(v);
			f2.setEmail(toEmail);
			f2.setShareDate(new Timestamp(System.currentTimeMillis()));
			Share s1 = ss.create(f2);
			
			if(s1!=null) {
				req.setAttribute("mess", "Chia sẽ thành công!");
				watch(session, id, req, resp);
			}else {
				System.out.println("Theem thaat bai");
			}
		}
		
		
	}

}
