package vn.iotstart.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstart.models.UserModel;
import vn.iotstart.services.UserService;
import vn.iotstart.services.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}

		/*
		 * Cookie[] cookies = req.getCookies(); if (cookies != null) { for (Cookie
		 * cookie : cookies) { if ("account".equals(cookie.getName())) { session =
		 * req.getSession(true); UserService service = new UserServiceImpl();
		 * vn.iotstart.models.UserModel user = service.findByUser(cookie.getValue());
		 * session.setAttribute("account", user); resp.sendRedirect(req.getContextPath()
		 * + "/waiting"); return; } } }
		 */
		req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");

		UserService service = new UserServiceImpl();
		String alertMsg = "";

		// Kiểm tra email trùng
		if (service.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
			return;
		}

		// Kiểm tra username trùng
		if (service.checkExistUsername(username)) {
			alertMsg = "Tài khoản đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
			return;
		}

		// Tạo object UserModel
		UserModel user = new UserModel();
		user.setUsername(username);
		user.setEmail(email);
		user.setFullname(fullname);
		user.setPassword(password);
		user.setPhone(phone);

		// roleid mặc định = 2 (user thường)
		user.setRoleid(2);

		boolean isSuccess = service.register(user);

		if (isSuccess) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			alertMsg = "System error!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
		}
	}

}
