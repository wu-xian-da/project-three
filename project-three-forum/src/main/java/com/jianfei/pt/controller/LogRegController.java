/**
  *project project-three-forum
  *@author changchun.wu
  *2017年9月15日上午11:26:25
  */
package com.jianfei.pt.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	/***
	 * 首页
	 * @param model
	 * @param request
	 * @param notes
	 * @return
	 */
	@RequestMapping
	public String showPage(Model model,HttpServletRequest request,Notes notes){
		
		//页面传输的pn,ps
		pageController.setPNPS(model,notes);
		
		//查询总记录条数
		int totalRecord = notesService.findCountByStatus();
		pageController.findPage(model,notes,totalRecord);
		
		//分页,条件,查询所有
		request.getSession().setAttribute("allnotes", this.notesService.findConditionByStatus(notes));
		
		request.getSession().setAttribute("allmembers", membersService.findAll());
		request.getSession().setAttribute("allmodules", modulesService.findAll());
		
		//
		request.getSession().setAttribute("notesbymodulesname", notesService.findAll());
		return "index";
	}
	
	/***
	 * 跳转登录页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/log")
	public String LogPage(Model model){
		model.addAttribute("logreg","login");
		return "logreg";
	}
	
	/***
	 * 跳转注册页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/reg")
	public String RegPage(Model model){
		model.addAttribute("logreg","register");
		return "logreg";
	}
	
	/***
	 * 注册用户
	 * @param model
	 * @param account
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/Reg",method=RequestMethod.POST)
	public String Reg(Model model,String account,String password){
		membersService.insertMembers(account, password);
		return "redirect:/log";
	}
	
	/***
	 * 用户登录
	 * @param model
	 * @param request
	 * @param account
	 * @param password
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/Log",method=RequestMethod.POST)
	public String Log(Model model,HttpServletRequest request,String account,String password,HttpServletResponse response) throws IOException{
		Members members = membersService.findMembersByAccount(account, password);
		if (members != null) {
			request.getSession().setAttribute("membersId", String.valueOf(members.getId()));
			request.getSession().setAttribute("members", members);
			return "redirect:/member/members";
		}
		//response.sendRedirect("http://localhost:8888/log?error=fail");
		return "redirect:/log";
	}
}
