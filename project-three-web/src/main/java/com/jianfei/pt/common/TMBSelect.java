/**
  *project project-three-web
  *@author changchun.wu
  *2017年9月4日下午5:19:52
  */
package com.jianfei.pt.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.jianfei.pt.entity.relation.UserRole;
import com.jianfei.pt.service.relation.RoleMenuService;
import com.jianfei.pt.service.relation.UserRoleService;
import com.jianfei.pt.service.system.UsersService;

public class TMBSelect {

	@Autowired
	private RoleMenuService roleMenuService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private UsersService usersService;
	
	public void findtmbname(HttpServletRequest request,UserRole userRole){
		
		request.getSession().setAttribute("tmbname", this.roleMenuService.findTMBMenusByRoles(userRole.getRoleId()));
	}
	
	public void findbuttons(HttpServletRequest request,Model model){
		//查询按钮
		model.addAttribute("button_id",this.roleMenuService.findTMBMenusByRoles(Integer.parseInt(request.getParameter("roleId"))));
	}
}
