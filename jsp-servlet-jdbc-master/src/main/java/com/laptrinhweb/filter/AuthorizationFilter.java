package com.laptrinhweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.model.UserModel;
import com.laptrinhweb.utils.SessionUtil;

public class AuthorizationFilter implements Filter {
	private ServletContext context;

	// khởi tạo bộ chứa filter
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String url = req.getRequestURI();
		if (url.startsWith("/admin")) {
			UserModel model = (UserModel) SessionUtil.getIntance().getValue(req, "USERMODEL");
			if (model != null) { // đã login
				// Kiểm tra xem bạn là admin hay user nếu là admin thì có quyền đăng nhập vào
				// trang /admin
				if (model.getRole().getCode().equals(SystemConstant.ADMIN)) {
					chain.doFilter(request, response);
					// còn nếu là user thì không có quyền truy cập vào trang /admin
				} else if (model.getRole().getCode().equals(SystemConstant.USER)) {
					resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_permission&alert=danger");
				}
			} else { // chưa login
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
			}
		} else { // nếu url không có /admin
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
