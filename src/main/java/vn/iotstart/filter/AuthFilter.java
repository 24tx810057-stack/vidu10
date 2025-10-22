package vn.iotstart.filter;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstart.models.UserModel;

@WebFilter(urlPatterns = {"/admin/*", "/manager/*", "/web/*"})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        // Nếu chưa login thì đá về login
        if (session == null || session.getAttribute("account") == null) {
            if (session != null) session.invalidate();
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        UserModel user = (UserModel) session.getAttribute("account");
        int roleId = user.getRoleid();
        String uri = req.getRequestURI();

        
        if (roleId == 2 && (uri.startsWith(req.getContextPath() + "/admin") ||
                            uri.startsWith(req.getContextPath() + "/manager"))) {
            resp.sendRedirect(req.getContextPath() + "/web/home");
            return;
        }

        
        if (roleId == 1 && uri.startsWith(req.getContextPath() + "/admin")) {
            resp.sendRedirect(req.getContextPath() + "/manager/home");
            return;
        }

        // Các quyền còn lại: hợp lệ
        chain.doFilter(request, response);
    }
}
