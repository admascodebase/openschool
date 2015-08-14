package com.admas.logiware.util;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class WeekDayOffInterceptor extends HandlerInterceptorAdapter {
	
	Logger logger=LoggerFactory.getLogger(WeekDayOffInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)throws Exception{
		
		Calendar calendar=Calendar.getInstance();

		int dow=calendar.get(calendar.DAY_OF_WEEK);
		if(dow==3){
			
			logger.info("ececuting WeekDayOffInterceptor ----****");
			response.getWriter().write("this site is closed on tuesday...");
			return false;
		}
		return true;
		
	}

}
