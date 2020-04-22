package com.ry.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import Constant.Common;

public class LoginInteceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}
	/**
	 * 请求进入以前
	 * true 放行请求 false 拦截请求
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		HttpSession session = request.getSession();
		Object object = session.getAttribute(Common.CURRENT_USER);

		Object obj = session.getAttribute("customer");
		
		if(object==null){
			//重定向到登录页面
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return false;
		}
		return true;
	}

}
