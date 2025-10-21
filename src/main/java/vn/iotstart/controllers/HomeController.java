package vn.iotstart.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/web/home")
public class HomeController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name="bao";
		
		
		req.setAttribute("name", name); //truyền dữ liệu ra cho tham số của views
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp"); //gọi views home.jsp hiển thị
		rd.forward(req, resp); // chuyển tham số ra home.jsp
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//bắt 1 tham số 
		String name= req.getParameter("ten");
		String lstname=req.getParameter("holot");
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("Hello " + name + lstname);
		out.close();
		
	}
}
