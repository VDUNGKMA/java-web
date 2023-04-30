package com.laptrinhweb.controller.web;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.service.ICategoryService;
import com.laptrinhweb.service.INewService;

@WebServlet(urlPatterns= {"/trang-chu"})
public class HomeController extends HttpServlet {
		@Inject
		private ICategoryService categoryService;
		@Inject
		private INewService newService;
	private static final long serialVersionUID = 7753963690669418503L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("categories", categoryService.findAll());
		RequestDispatcher rd= req.getRequestDispatcher("views/web/home.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
