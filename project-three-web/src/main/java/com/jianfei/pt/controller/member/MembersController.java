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

import com.jianfei.pt.entity.member.Members;
import com.jianfei.pt.service.member.MembersService;

@Controller
@RequestMapping("/member/members")
public class MembersController {

	@Autowired
	private MembersService membersService;
	
	public void setModel(Model model){
		
	}
	
	@RequestMapping
	public String list(Model model,Members members){
		model.addAttribute("allmembers",membersService.findCondition(members));
		return "member/members/list";
	}
}
