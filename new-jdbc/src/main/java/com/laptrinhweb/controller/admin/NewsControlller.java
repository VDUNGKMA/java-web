package com.laptrinhweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.model.NewsModel;
import com.laptrinhweb.service.INewService;
import com.laptrinhweb.service.Impl.NewService;
@WebServlet(urlPatterns= {"/admin-new"})
public class NewsControlller extends HttpServlet{

	private static final long serialVersionUID = 3382356023027401479L;
	@Inject
	private INewService newService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewsModel model =new NewsModel();
		model.setListResult(newService.findAll());
		req.setAttribute(SystemConstant.MODEL,model );
		RequestDispatcher rd= req.getRequestDispatcher("/views/admin/News/list.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
