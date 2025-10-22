package vn.iotstart.controllers.manager;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstart.models.UserModel;

@WebServlet(urlPatterns = {"/manager/home"})
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        // Nếu chưa login thì đá về /login
        if (session == null || session.getAttribute("account") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Lấy thông tin người dùng trong session
        UserModel user = (UserModel) session.getAttribute("account");

        // Gửi thông tin user xuống view nếu cần
        req.setAttribute("username", user.getUsername());
        req.setAttribute("roleid", user.getRoleid());

        // Hiển thị giao diện home.jsp của manager
        req.getRequestDispatcher("/views/manager/home.jsp").forward(req, resp);
    }
}
