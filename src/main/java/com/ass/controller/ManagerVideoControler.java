package com.ass.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer;

import com.asm.entity.Favorite;
import com.asm.entity.Share;
import com.asm.entity.Video;
import com.ass.service.FavoriteService;
import com.ass.service.ShareService;
import com.ass.service.UserService;
import com.ass.service.VideoService;
import com.ass.service.impl.FavoriteServiceImpl;
import com.ass.service.impl.ShareServiceImpl;
import com.ass.service.impl.UserServiceImpl;
import com.ass.service.impl.VideoServiceImpl;

/**
 * Servlet implementation class ManagerControler
 */
@WebServlet({"/Videos", "/edit", "/delete", "/insert", "/update", "/new"})
//, "/Users", "Report"
public class ManagerVideoControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoService vs = new VideoServiceImpl();
	private UserService us = new UserServiceImpl();
	private FavoriteService fs = new FavoriteServiceImpl();
	private ShareService ss = new ShareServiceImpl();
	 List<String> videoTitle = null;
	 String titleSelected = null;
	 Integer tabIndex = 1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerVideoControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String path = req.getServletPath();
		
		
		switch (path) {
		case "/Videos":
			Videos(req, resp);
			break;
//		case "/Users":
//			
//			break;	
		case "/Report":
			Report(req, resp);
			break;	
		case "/edit":
			edit(req, resp);
			break;
		case "/delete":
			delete(req, resp);
			break;	
		case "/insert":
			try {
				insert(req, resp);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
				update(req, resp);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/new":
			reset(req, resp);
			break;	
		default:
			break;
		}
	}
	
	private void Videos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String method = req.getMethod();
		setTitleSelected(req, resp);
		fillVideo(req, resp);
		req.getRequestDispatcher("/video.jsp").forward(req, resp);
		
	}
	
	private void fillVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		List<Video> v = vs.findAll();
		req.setAttribute("video", v);
	
		
		
	}
	
	private void fillImg(String id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String imgYtb = "https://img.youtube.com/vi/"+ id +"/maxresdefault.jpg";
		req.setAttribute("imgYtb", imgYtb);
	}
	
	private void Report(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String method = req.getMethod();
		
		if(method.equalsIgnoreCase("post")) {
			String imgId = req.getParameter("id");
			fillImg(imgId, req, resp);
			
		}else {
			req.getRequestDispatcher("/report.jsp").forward(req, resp);
		}
		
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String idV = request.getParameter("idV");
		Video v = new Video();
		System.out.println(idV);
		 v = vs.findById(idV);

		try {
			BeanUtils.populate(v, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fillVideo(request, response);
		request.setAttribute("e", v);
		request.getRequestDispatcher("/video.jsp").forward(request, response);

	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String idV = request.getParameter("id");
		
		vs.delete(idV);
		List<Favorite> f = fs.findByVideoLiked(idV);
		List<Share> s = ss.findByVideoIsShared(idV);
		Video v = vs.findById(idV);
		
		if(v==null) {
			request.setAttribute("mess", "Xóa thành công!");
		}else if(f!= null){
			request.setAttribute("mess", "Bạn không thể xóa video đã được thích");
		}else if(s!= null){
			request.setAttribute("mess", "Bạn không thể xóa video đã được share");
		}else {
			request.setAttribute("mess", "Xóa thất bại!");
		}
		fillVideo(request, response);
		request.getRequestDispatcher("/video.jsp").forward(request, response);


	}
	
	
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		req.setCharacterEncoding("UTF-8");
		
			Video u = new Video();
			BeanUtils.populate(u, req.getParameterMap());
			Video checkV = vs.findById(u.getId());
			u.setPoster(u.getId());			
			if(checkV==null) {
				Video v = vs.create(u);
				System.out.println(v.getTitle());
				if(v!=null) {
					req.setAttribute("mess", "Thêm video thành công!");
					req.getRequestDispatcher("/video.jsp").forward(req, resp);
				}
				fillVideo(req, resp);
			}else {
				req.setAttribute("mess", "Video đã tồn tại!");
				req.getRequestDispatcher("/video.jsp").forward(req, resp);
			}
			
		}
		
	

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		req.setCharacterEncoding("UTF-8");
		
			Video u = new Video();
			BeanUtils.populate(u, req.getParameterMap());
			Video checkV = vs.findById(u.getId());
			u.setPoster(u.getId());			
			if(checkV!=null) {
				Video v = vs.update(u);
				System.out.println(v.getTitle());
				if(v!=null) {
					fillVideo(req, resp);
					req.setAttribute("mess", "Cập nhật video thành công!");
					req.getRequestDispatcher("/video.jsp").forward(req, resp);
				}
			}else {
				fillVideo(req, resp);
				req.setAttribute("mess", "Video không tồn tại!");
				req.getRequestDispatcher("/video.jsp").forward(req, resp);
			}
			
		}
		
	private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
			Video v = new Video();
			req.setAttribute("e", v);
			fillVideo(req, resp);
			req.getRequestDispatcher("/video.jsp").forward(req, resp);
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
				tabIndex = 2;
				request.setAttribute("tabIndex", tabIndex);
			
		}
}
