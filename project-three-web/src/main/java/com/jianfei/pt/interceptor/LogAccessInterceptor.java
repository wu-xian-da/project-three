/**
  *project project-second-web
  *@author changchun.wu
  *2017年8月29日上午9:38:45
  */
package com.jianfei.pt.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jianfei.pt.entity.system.LogAccess;
import com.jianfei.pt.service.system.LogAccessService;
import com.jianfei.pt.service.system.RolesService;
import com.jianfei.pt.tools.utils.HttpUtils;

public class LogAccessInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private LogAccessService logAccessService;
	
	@Autowired
	private RolesService rolesService;
	
	public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView modelAndView) throws Exception{
		try {
			if (!request.getRequestURI() .equals("/log/access") && !request.getRequestURI() .equals("/") ) {
				this.logAccessService.insert(new LogAccess((String)request.getSession().getAttribute("usernickname"),request.getRequestURI(),
						new Date(),HttpUtils.getRemoteAddr(request)));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
