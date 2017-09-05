/**
  *project project-three-web
  *@author changchun.wu
  *2017年9月4日下午4:54:21
  */
package com.jianfei.pt.common;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.jianfei.pt.entity.common.LoginStatus;
import com.jianfei.pt.entity.system.LogLogin;
import com.jianfei.pt.service.system.LogLoginService;
import com.jianfei.pt.tools.utils.HttpUtils;

public class LogLoginInsert {
	
	@Autowired
	private LogLoginService logLoginService;
	
	public void loginSuccess(HttpServletRequest request,LoginStatus status) throws Exception{
		
		this.logLoginService.insert(new LogLogin((String)request.getSession().getAttribute("usernickname"),new Date(), 
						"Window 10.0 ,Eclipse 4.4, JDK 1.7,Chrome 57.0.2987.133",HttpUtils.getRemoteAddr(request),status.SUCCESS));
			
	}
	
	public void loginFial(HttpServletRequest request,LoginStatus status) throws Exception{
		
		this.logLoginService.insert(new LogLogin((String)request.getSession().getAttribute("usernickname"),new Date(), 
						"Window 10.0 ,Eclipse 4.4, JDK 1.7,Chrome 57.0.2987.133",HttpUtils.getRemoteAddr(request),status.FIAL));
			
	}
}