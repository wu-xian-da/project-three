/**
  *project project-frist
  *@author changchun.wu
  *2017年8月1日下午2:31:15
  */
package com.jianfei.pt.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jianfei.pt.entity.common.LoginStatus;
import com.jianfei.pt.entity.relation.UserRole;
import com.jianfei.pt.entity.system.LogLogin;
import com.jianfei.pt.entity.system.Users;
import com.jianfei.pt.service.relation.RoleMenuService;
import com.jianfei.pt.service.relation.UserRoleService;
import com.jianfei.pt.service.system.LogLoginService;
import com.jianfei.pt.service.system.UsersService;
import com.jianfei.pt.tools.utils.HttpUtils;


@Controller
@RequestMapping(value="/")
public class LoginController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private RoleMenuService roleMenuService;
	
	@Autowired
	private LogLoginService logLoginService;
	
	@RequestMapping
	public String loginPage(){
		return "login";
	}
	
	@GetMapping("/login")
	public String loginForm(Model model){
		return "login";
	}
	
	@PostMapping("/login")
	public String loginUsers(Model model,Users users,HttpServletRequest request,HttpServletResponse response,LoginStatus status) throws IOException{
		Users user = usersService.findUsersByNcikname(users.getNickname());
		if (user != null) {
			if (users.getNickname().equals(user.getNickname()) && users.getPassword().equals(user.getPassword())) {
				user.setLoginTime(new Date());
				user.setIp(HttpUtils.getRemoteAddr(request));
				usersService.updateLoginTimeAndIp(user);
				//先根据用户查询角色
				UserRole userRole = userRoleService.findById(user.getId());

				//model 存放roleId
				model.addAttribute("roleid",userRole.getRoleId());
				model.addAttribute("user",users.getNickname());
				
				request.getSession().setAttribute("usernickname", users.getNickname());
				/* 	
				 * 再根据角色查询权限
				 * framset页面之间的跳转传值使用request.getSession().setAttribute();
				 *	
				*/
				//查询子级菜单
				request.getSession().setAttribute("rolemenus", this.roleMenuService.findMENU(userRole.getRoleId()));
				//查询父级菜单
				request.getSession().setAttribute("roletitle", this.roleMenuService.findTITLE(userRole.getRoleId()));
				//登录日志添加
				this.logLoginService.insert(new LogLogin(users.getNickname(),new Date(), "Window 10.0 ,Eclipse 4.4, JDK 1.7,Chrome 57.0.2987.133",HttpUtils.getRemoteAddr(request),status.SUCCESS));
				System.out.println("登录成功");
				return "jsp/index";
			} else if (users.getNickname().equals(user.getNickname()) && !users.getPassword().equals(user.getPassword())){
				//登录日志添加
				this.logLoginService.insert(new LogLogin(users.getNickname(),new Date(),"Window 10.0 ,Eclipse 4.4, JDK 1.7,Chrome 57.0.2987.133",HttpUtils.getRemoteAddr(request),status.FIAL));
				response.sendRedirect("http://localhost:8080?error2=password");
				return "login";
			} else {
				//登录日志添加
				this.logLoginService.insert(new LogLogin(users.getNickname(),new Date(),"Window 10.0 ,Eclipse 4.4, JDK 1.7,Chrome 57.0.2987.133",HttpUtils.getRemoteAddr(request),status.FIAL));
				response.sendRedirect("http://localhost:8080?error1=nickname");
				return "login";
			}
		}else {
			//登录日志添加
			this.logLoginService.insert(new LogLogin(users.getNickname(),new Date(),"Window 10.0 ,Eclipse 4.4, JDK 1.7,Chrome 57.0.2987.133",HttpUtils.getRemoteAddr(request),status.FIAL));
			System.out.println("登录失败");
			response.sendRedirect("http://localhost:8080?error3=fail");
			return "login";
		}
	}
}