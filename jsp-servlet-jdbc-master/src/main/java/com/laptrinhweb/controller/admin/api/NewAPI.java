package com.laptrinhweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;

import com.laptrinhweb.model.NewsModel;
import com.laptrinhweb.model.UserModel;
import com.laptrinhweb.service.INewService;
import com.laptrinhweb.utils.HttpUtil;
import com.laptrinhweb.utils.SessionUtil;
@WebServlet(urlPatterns= {"/api-admin-news"})
public class NewAPI  extends HttpServlet  {

	
	@Inject
	private INewService newService;
	
	private static final long serialVersionUID = -5169209930970043705L;@Override
	// thêm dùng doPost
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		super.doPost(req, resp);
	 NewsModel newsmodel=HttpUtil.of(req.getReader()).toModel(NewsModel.class); //biến đổi từ json-->string-->object
	 UserModel usermodel= (UserModel) SessionUtil.getIntance().getValue(req, "USERMODEL"); //truy cập vào usemodel lấy data
	 newsmodel.setCreatedBy(usermodel.getUserName()); // set createdby 
	 newsmodel= newService.save(newsmodel);
	 mapper.writeValue(resp.getOutputStream(), newsmodel);
	}
	//hiển thị danh sách
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper mapper=new ObjectMapper(); 
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		super.doPut(req, resp);
		NewsModel updateNews =HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		UserModel usermodel = (UserModel) SessionUtil.getIntance().getValue(req, "USERMODEL");
		updateNews.setModifiedBy(usermodel.getUserName());
		updateNews=newService.update(updateNews);
		mapper.writeValue(resp.getOutputStream(), updateNews);
		
		
	}
//	@Override
//	// cập nhập dùng doGet
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		super.doGet(req, resp);
//	}
//	@Override
	//xóa dùng doDelete
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper= new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		super.doDelete(req, resp);
		NewsModel newsModel =HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		newService.delete(newsModel.getIds());
		mapper.writeValue(resp.getOutputStream(),"{}");
	}
	
}
