package com.ass.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.asm.entity.User;
import com.ass.constant.SessionAttr;
import com.ass.service.EmailService;
import com.ass.service.UserService;
import com.ass.service.impl.EmailServiceImpl;
import com.ass.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserControler
 */
@WebServlet({"/login", "/logout", "/register", "/forgotPass", "/changePass", "/editProfile"})
public class UserControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService us = new UserServiceImpl();
    private EmailService es = new EmailServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		HttpSession session = req.getSession();
		switch (path) {
		case "/login":
			login(req, resp);
			break;
		case "/register":
			register(req, resp);
			break;
		case "/logout":
			logout(session ,req, resp);
			break;
		case "/forgotPass":
			forgotPass(req, resp);
			break;
		case "/changePass":
			changePass(session ,req, resp);
			break;
		case "/editProfile":
			editProfile(session ,req, resp);
			break;
		default:
			break;
		}
		
	}

	
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String method = req.getMethod();
		if(method.equalsIgnoreCase("post")) {
			HttpSession session = req.getSession();
			String username = req.getParameter("id");
			String password = req.getParameter("password");
			User u = us.login(username, password);
			if(u != null) {
				session.setAttribute("currentUser", u);
//				if(u.getAdmin()) {
//					resp.sendRedirect("indexAmin");
//				}else {
					resp.sendRedirect("HomeControler");
//				}
				
			}else {
				req.setAttribute("mess", "Thông tin đăng nhập không chính xác!");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
		}else {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
	
	public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String method = req.getMethod();
		if(method.equalsIgnoreCase("post")) {
			String username = req.getParameter("id");
			String password = req.getParameter("password");
			String fullname = req.getParameter("fullname");
			String email = req.getParameter("email");
			User check = us.findById(username);
			if(check == null) {
				User u = us.create(username, password, fullname, email);
				if(u!=null) {
					es.sendMail(u, "welcome");
					req.setAttribute("mess", "Đăng ký thành công!");
					req.getRequestDispatcher("/register.jsp").forward(req, resp);
				}
			}else {
				req.setAttribute("mess", "Tên đăng nhập đã tồn tại");
			}
			
			
			
		}else {
		req.getRequestDispatcher("/register.jsp").forward(req, resp);
		}
	}
	
	public void logout(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session.removeAttribute(SessionAttr.CURRENT_USER);
		resp.sendRedirect("HomeControler");
	}
	
	public void forgotPass( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String method = req.getMethod();
		String id = req.getParameter("id");
		String email = req.getParameter("email");

		if(method.equalsIgnoreCase("post")) {
			Boolean i = us.checkEmail(id, email);
			System.out.println("Test - 2");
			if(i) {
				User uWithNewPass = us.resetPass(email);
				if(uWithNewPass!=null) {
					es.sendMail(uWithNewPass, "forgot");
					req.setAttribute("mess", "Đã gửi mật khẩu mới về mail");
					req.getRequestDispatcher("/forgotPass.jsp").forward(req, resp);
				}
			}else {
				req.setAttribute("mess", "Email không khớp với tài khoản");
				req.getRequestDispatcher("/forgotPass.jsp").forward(req, resp);
			}
			
		}else {
			req.getRequestDispatcher("/forgotPass.jsp").forward(req, resp);
		
			
		}
	}
	

	public void changePass(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String method = req.getMethod();
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String cfpassword = req.getParameter("cfpassword");
		User currUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		req.setAttribute("u", currUser);
		if(method.equalsIgnoreCase("post")) {
			if(password.equalsIgnoreCase(cfpassword)) {
				currUser.setPassword(password);
				User u = us.update(currUser);
				if(u!= null) {
					req.setAttribute("mess", "Đổi mật khẩu thành công!");
					req.getRequestDispatcher("/rePass.jsp").forward(req, resp);
				}
			}else {
				req.setAttribute("mess", "Xác nhận mật khẩu không đúng!");
				req.getRequestDispatcher("/rePass.jsp").forward(req, resp);
			}
		}else {
			req.getRequestDispatcher("/rePass.jsp").forward(req, resp);
		}
		
	}
	
	
	public void editProfile(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String method = req.getMethod();
		User currUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		req.setAttribute("u", currUser);
		if(method.equalsIgnoreCase("post")) {
			try {
				BeanUtils.populate(currUser, req.getParameterMap());
				us.update(currUser);
				req.setAttribute("mess", "Cập nhật thành công!");
			} catch (Exception e) {
				req.setAttribute("mess", "Cập nhật thất bại!");
			}
			req.getRequestDispatcher("/editProfile.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/editProfile.jsp").forward(req, resp);
		}
	}
	
	
	
	
//	Check
	
	
	

}
