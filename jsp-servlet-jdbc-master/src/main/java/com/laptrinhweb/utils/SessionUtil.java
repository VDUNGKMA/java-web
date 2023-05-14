package com.laptrinhweb.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	private static SessionUtil sessionUtil=null;
	/*Hàm getIntace kiểm tra xem đối tượng session đã tồn tại chưa*/
	public static SessionUtil getIntance() {
		if(sessionUtil ==null) {
			sessionUtil=new SessionUtil();
		}
		return sessionUtil;
	}
	
	public void putValue(HttpServletRequest request,String key,Object value) {
		request.getSession().setAttribute(key, value);

	}
	public Object getValue(HttpServletRequest request,String key) {
	
		
		return request.getSession().getAttribute(key);
	}
	public void removeValue(HttpServletRequest request,String key) {
		request.getSession().removeAttribute(key);
	}
}
