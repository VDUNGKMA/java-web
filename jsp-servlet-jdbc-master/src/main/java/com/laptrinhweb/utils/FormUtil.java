package com.laptrinhweb.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {
	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> tClass, HttpServletRequest request){
		T object =null;
		try {
			object = tClass.newInstance();
			/*để mapping giữa các key trong phần request(trong url) ta dùng BeanUtils để parse giữa các biến vs nhau*/ 
			/*hàm getparametermap() chuyển các url thành các string rồi từ đó parse sang kiểu được định nghĩa trong model*/
			BeanUtils.populate(object, request.getParameterMap());
		} catch (InstantiationException  |  InvocationTargetException | IllegalAccessException e) {
			System.out.println(e.getMessage());
			
		} 
		return object;
		}
}
