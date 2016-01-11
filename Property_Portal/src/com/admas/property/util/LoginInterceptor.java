package com.admas.property.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	Logger logger=LoggerFactory.getLogger(LoginInterceptor.class);

	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)throws Exception{

/*		if("admin".equals(request.getParameter("userName")) && "admin".equals(request.getParameter("password"))){*/

			return true;
/*		}
		return false;*/

	}
}
