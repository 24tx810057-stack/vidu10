package vn.iotstart.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iotstart.models.Category;
import vn.iotstart.services.CategoryService;
import vn.iotstart.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/list-category" })
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Lấy toàn bộ categories
        List<Category> cateList = cateService.getAll();

        // Gửi dữ liệu sang JSP
        req.setAttribute("cateList", cateList);

        // Chuyển tiếp sang trang JSP
        RequestDispatcher dispatcher = 
                req.getRequestDispatcher("/views/admin/list-category.jsp");
        dispatcher.forward(req, resp);
    }
}
