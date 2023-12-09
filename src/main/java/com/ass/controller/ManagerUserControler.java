package com.ass.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.sql.Update;

import com.asm.entity.Favorite;
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

/**
 * Servlet implementation class ManagerUserControler
 */
@WebServlet({"/user","/updateUser", "/deleteUser", "/editUser"})
public class ManagerUserControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FavoriteService fs = new FavoriteServiceImpl();
	private ReportService rs = new ReportServiceImpl();
	private VideoService vs = new VideoServiceImpl();
	private UserService us = new UserServiceImpl();
	private ShareService ss = new ShareServiceImpl();
	private EmailService es = new EmailServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerUserControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String path = req.getServletPath();
		
		switch (path) {
		case "/user":
			User(req, resp);
			break;
		case "/updateUser":
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

		case "/deleteUser":
			delete(req, resp);
			break;
		case "/editUser":
			edit(req, resp);
			break;
		default:
			break;
		}
	}
	
	private void User(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		fillUser(req, resp);
		req.getRequestDispatcher("/user.jsp").forward(req, resp);
		
	}
	
	private void fillUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		List<User> u = us.findAll();
		req.setAttribute("user", u);		
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String idU = request.getParameter("idU");
		User u = new User();
		 u = us.findById(idU);
		 System.out.println(u.getId());
		try {
			BeanUtils.populate(u, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fillUser(request, response);
		request.setAttribute("e", u);
		request.getRequestDispatcher("/user.jsp").forward(request, response);

	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		User currUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		if(id.equalsIgnoreCase(currUser.getId())) {
			request.setAttribute("mess", "Bạn không thể xóa tài khoản của mình!");
			fillUser(request, response);
			request.getRequestDispatcher("/user.jsp").forward(request, response);
		}else {
			us.delete(id);
			request.setAttribute("mess", "Xóa thành công!");
			fillUser(request, response);
			request.getRequestDispatcher("/user.jsp").forward(request, response);
		}
	}
	
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		req.setCharacterEncoding("UTF-8");
		
			User u = new User();
			BeanUtils.populate(u, req.getParameterMap());
			User checkV = us.findById(u.getId());		
			if(checkV!=null) {
				User upU = us.update(u);
				
				if(u!=null) {
					fillUser(req, resp);
					req.setAttribute("mess", "Cập nhật User thành công!");
					req.getRequestDispatcher("/user.jsp").forward(req, resp);
				}
			}else {
				fillUser(req, resp);
				req.setAttribute("mess", "User không tồn tại!");
				req.getRequestDispatcher("/user.jsp").forward(req, resp);
			}
			
		}
	
}
