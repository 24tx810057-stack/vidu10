package vn.iotstart.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstart.models.UserModel;
import vn.iotstart.services.UserService;
import vn.iotstart.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * HttpSession session = req.getSession(false); // không tự tạo session mới
		 */
		/*
		 * // Nếu đã login rồi thì cho về waiting (từ đó check role → admin/home hay
		 * user/home) if (session != null && session.getAttribute("account") != null) {
		 * 
		 * resp.sendRedirect(req.getContextPath() + "/waiting"); return; }
		 */

        // Nếu chưa login thì hiện trang login
        req.getRequestDispatcher("views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String alertMsg = "";

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("views/login.jsp").forward(req, resp);
            return;
        }

        UserService service = new UserServiceImpl();
        UserModel user = service.login(username, password);

        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            session.setMaxInactiveInterval(60 * 50); // session hết hạn sau xx phút

            // Nếu muốn nhớ login qua cookie
            Cookie cookie = new Cookie("account", user.getUsername());
            cookie.setMaxAge(60 * 50); // 
            resp.addCookie(cookie);

            resp.sendRedirect(req.getContextPath() + "/waiting");
        } else {
            alertMsg = "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("views/login.jsp").forward(req, resp);
        }
    }
}
