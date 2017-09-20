/**
  *project project-three-forum
  *@author changchun.wu
  *2017年9月15日上午11:26:25
  */
package com.jianfei.pt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jianfei.pt.controller.common.PageController;
import com.jianfei.pt.controller.common.TMBSelect;
import com.jianfei.pt.entity.forum.Notes;
import com.jianfei.pt.entity.member.Members;
import com.jianfei.pt.service.forum.ModulesService;
import com.jianfei.pt.service.forum.NotesService;
import com.jianfei.pt.service.member.MembersService;

@Controller
@RequestMapping(value="/")
public class LogRegController {
	
	@Autowired
	private MembersService membersService;
	
	@Autowired
	private NotesService notesService;
	
	@Autowired
	private ModulesService modulesService;
	
	@Autowired
	protected PageController<Notes> pageController;
	
	@Autowired
	private TMBSelect tmbSelect;

	/*public void setModel(Model model){
		model.addAttribute("allmembers",membersService.findAll());
		model.addAttribute("allmodules",modulesService.findAll());
	}*/
	
	@RequestMapping
	public String showPage(Model model,HttpServletRequest request,Notes notes){
		
		//页面传输的pn,ps
		pageController.setPNPS(model,notes);
		
		//查询总记录条数
		int totalRecord = notesService.findCountByStatus();
		pageController.findPage(model,notes,totalRecord);
		
		//分页,条件,查询所有
		//model.addAttribute("users",this.notesService.findCondition(notes));
		
		request.getSession().setAttribute("allmembers", membersService.findAll());
		request.getSession().setAttribute("allmodules", modulesService.findAll());
		request.getSession().setAttribute("allnotes", this.notesService.findConditionByStatus(notes));
		//
		request.getSession().setAttribute("notesbymodulesname", notesService.findAll());
		return "index";
	}
	
	@RequestMapping("/log")
	public String LogPage(Model model){
		model.addAttribute("logreg","login");
		return "logreg";
	}
	
	@RequestMapping("/reg")
	public String RegPage(Model model){
		model.addAttribute("logreg","register");
		return "logreg";
	}
	
	@RequestMapping(value="/Reg",method=RequestMethod.POST)
	public String Reg(Model model,String account,String password){
		membersService.insertMembers(account, password);
		return "redirect:/log";
	}
	
	@RequestMapping(value="/Log",method=RequestMethod.POST)
	public String Log(Model model,HttpServletRequest request,String account,String password){
		Members members = membersService.findMembersByAccount(account, password);

		request.getSession().setAttribute("membersId", String.valueOf(members.getId()));
		request.getSession().setAttribute("members", members);
		return "redirect:/member/members";
	}
}
