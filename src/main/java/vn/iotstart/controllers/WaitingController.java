package vn.iotstart.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstart.models.UserModel;

@WebServlet(urlPatterns = { "/waiting" })
public class WaitingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		// Chưa login → về trang login
		if (session == null || session.getAttribute("account") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
//
		UserModel user = (UserModel) session.getAttribute("account");
		int role = user.getRoleid();

		if (role == 0) {
			resp.sendRedirect(req.getContextPath() + "/admin/home");
		} else if (role == 1) {
			resp.sendRedirect(req.getContextPath() + "/manager/home");
		} else {
			resp.sendRedirect(req.getContextPath() + "/web/home");
		}

	}
}
