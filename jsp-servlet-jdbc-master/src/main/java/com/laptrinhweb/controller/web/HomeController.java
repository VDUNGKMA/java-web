package com.laptrinhweb.controller.web;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.model.UserModel;
import com.laptrinhweb.service.ICategoryService;
import com.laptrinhweb.service.INewService;
import com.laptrinhweb.service.IUserService;
import com.laptrinhweb.utils.FormUtil;
import com.laptrinhweb.utils.SessionUtil;

@WebServlet(urlPatterns= {"/trang-chu","/dang-nhap","/thoat"})
public class HomeController extends HttpServlet {
		@Inject
		private ICategoryService categoryService;
		@Inject
		private INewService newService;
		@Inject 
		private IUserService userService;
	private static final long serialVersionUID = 7753963690669418503L;
	/*Dùng resourcebundle lấy dữ liệu của các biến() được đặt trong file messagge.properties */
	ResourceBundle resourceBundle =ResourceBundle.getBundle("message");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		if(action != null && action.equals("login")) {
			String message=req.getParameter("message");
			String alert=req.getParameter("alert");
			if(message !=null && alert != null){
				req.setAttribute("message",resourceBundle.getString(message));
				//biến alert được gọi lấy từ url
				req.setAttribute("alert",alert);
			}
			RequestDispatcher rd= req.getRequestDispatcher("views/login.jsp");
			rd.forward(req, resp);
		} else if(action != null && action.equals("logout")) {
			SessionUtil.getIntance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath()+"/trang-chu");
		} else {
			req.setAttribute("categories", categoryService.findAll());
			RequestDispatcher rd= req.getRequestDispatcher("views/web/home.jsp");
			rd.forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action =req.getParameter("action");
		if(action != null && action.equals("login")) {
			
			UserModel model =FormUtil.toModel(UserModel.class, req);
			model =userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
			if(model != null) {
				SessionUtil.getIntance().putValue(req, "USERMODEL", model);
				if(model.getRole().getCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath()+"/trang-chu");
				} else if(model.getRole().getCode().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath()+"/admin-home");
				}
			} else {
				//hàm getContextPath trả về phần của URL  request (http://localhost:8080/new-jdbc-12-month-2018)
				resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&message=username_password-invalid&alert=danger");
			}
		}
	}
}
