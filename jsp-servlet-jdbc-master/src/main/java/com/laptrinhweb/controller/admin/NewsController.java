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
import com.laptrinhweb.utils.FormUtil;

@WebServlet(urlPatterns= {"/admin-news"})
public class NewsController  extends HttpServlet{
	@Inject
	private INewService newService;
	private static final long serialVersionUID = -3230183043855769492L;
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			NewsModel model =FormUtil.toModel(NewsModel.class, req);
			int offset=(model.getPage() -1) * model.getMaxPageItem();
			model.setListResult(newService.findAll(offset, model.getMaxPageItem()));
			model.setTotalItem(newService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			req.setAttribute(SystemConstant.MODEL, model);
			RequestDispatcher rd= req.getRequestDispatcher("views/admin/news/list.jsp");
			rd.forward(req, resp);
		}

}
