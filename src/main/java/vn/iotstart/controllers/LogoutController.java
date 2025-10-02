package vn.iotstart.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/logout" })
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Xóa session
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		// Xóa cookie "account"
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("account")) {
					cookie.setValue(""); // clear value
					cookie.setMaxAge(0); // hết hạn ngay
					cookie.setPath(req.getContextPath()); // đảm bảo đúng path
					resp.addCookie(cookie);
				}
			}
		}

		// Quay lại trang login
		resp.sendRedirect(req.getContextPath() + "/login");
	}
}
