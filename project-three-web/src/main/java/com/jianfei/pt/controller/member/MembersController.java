/**
  *project project-three-web
  *@author changchun.wu
  *2017年9月15日上午10:37:46
  */
package com.jianfei.pt.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jianfei.pt.common.PageController;
import com.jianfei.pt.common.TMBSelect;
import com.jianfei.pt.entity.member.Members;
import com.jianfei.pt.entity.system.Users;
import com.jianfei.pt.service.member.MembersService;

@Controller
@RequestMapping("/member/members")
public class MembersController {

	@Autowired
	private MembersService membersService;
	
	@Autowired
	protected PageController<Members> pageController;
	
	@Autowired
	private TMBSelect tmbSelect;
	
	public void setModel(Model model){
		
	}
	
	@RequestMapping
	public String list(Model model,Members members){
		//页面传输的pn,ps
		pageController.setPNPS(model,members);
		
		//判断页面传参是否为null
		if (members.getUsername() == null && members.getAccount() == null) {
			//查询总记录条数
			int totalRecord = membersService.findCount();
			pageController.findPage(model, members,totalRecord);
		} else {
			//条件查询总记录条数
			int totalRecord = membersService.findCountByT(members);
			pageController.findPageCondition(model, members,totalRecord);
			
			model.addAttribute("jspurl","&account="+members.getAccount()+"&username="+members.getUsername());
		}
		model.addAttribute("allmembers",membersService.findCondition(members));
		return "member/members/list";
	}
}
