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
import com.laptrinhweb.paging.PageRequest;
import com.laptrinhweb.paging.Pageble;
import com.laptrinhweb.service.ICategoryService;
import com.laptrinhweb.service.INewService;
import com.laptrinhweb.sort.Sorter;
import com.laptrinhweb.utils.FormUtil;
import com.laptrinhweb.utils.MessageUtil;

@WebServlet(urlPatterns= {"/admin-news"})
public class NewsController  extends HttpServlet{
	@Inject
	private INewService newService;
	@Inject
	private ICategoryService categoryservice;
	private static final long serialVersionUID = -3230183043855769492L;
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			NewsModel model =FormUtil.toModel(NewsModel.class, req);
			String view="";
			if(model.getType().equals(SystemConstant.LIST)){
				//khi new một đối tượng mà có interface trong đó ta new class tương ứng với interface đó
				Pageble pageble =new PageRequest(model.getPage(),model.getMaxPageItem(),new Sorter(model.getSortName(),model.getSortBy()));
				model.setListResult(newService.findAll(pageble));
				model.setTotalItem(newService.getTotalItem());
				model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
				view="views/admin/news/list.jsp";

			} else if(model.getType().equals(SystemConstant.EDIT)){
				if(model.getId() != null){
					model= newService.findOne(model.getId());
				}
				MessageUtil.showMessage(req);
				req.setAttribute("categories", categoryservice.findAll());
				view="/views/admin/news/edit.jsp";
			}
			req.setAttribute(SystemConstant.MODEL, model);
			RequestDispatcher rd= req.getRequestDispatcher(view);
			rd.forward(req, resp);
			

		}

}
