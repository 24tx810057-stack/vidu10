package vn.iotstart.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import vn.iotstart.models.Category;
import vn.iotstart.services.CategoryService;
import vn.iotstart.services.impl.CategoryServiceImpl;
import vn.iotstart.utils.Constant;

import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = { "/admin/category/add" })
public class CategoryAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategoryService cateService = new CategoryServiceImpl();

	// Hiển thị form thêm Category
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-category.jsp");
		dispatcher.forward(req, resp);
	}

	// Xử lý thêm Category khi submit form
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Category category = new Category();

		DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
		JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
		
		

		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");

			List<FileItem> items = upload.parseRequest(req);

			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					category.setName(item.getString(StandardCharsets.UTF_8));
				} else if (item.getFieldName().equals("icon")) {
					if (item.getSize() > 0) { // nếu có file upload
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;

						File file = new File(Constant.DIR + "/category/" + fileName);
						item.write(file.toPath());

						category.setIcon("category/" + fileName);
					}
				}
			}

			// Lưu Category
			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/category/list");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
