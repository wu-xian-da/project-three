/**
  *project project-three-forum
  *@author changchun.wu
  *2017年9月15日上午11:29:50
  */
package com.jianfei.pt.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jianfei.pt.entity.common.Gender;
import com.jianfei.pt.entity.forum.Notes;
import com.jianfei.pt.entity.member.Members;
import com.jianfei.pt.service.forum.NotesService;
import com.jianfei.pt.service.member.MembersService;

@Controller
@RequestMapping("/member/members")
public class MembersController {
	
	@Autowired
	private MembersService membersService;
	
	@Autowired
	private NotesService notesService;
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String Formupdate(@PathVariable("id")int id,Model model){
		model.addAttribute("gender",Gender.values());
		model.addAttribute("membersform",membersService.findById(id));
		return "member/members/form";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update (Model model,Members members){
		membersService.update(members);
		model.addAttribute("memberslist",membersService.findById(members.getId()));
		return "member/members/list";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String findMembers(@PathVariable("id")int id,Model model){
		model.addAttribute("memberslist",membersService.findById(id));
		return "member/members/list";
	}
	
	@RequestMapping
	public String list(Model model,HttpServletRequest request){
		List<Notes> notes = notesService.findNotesByMembersId(Integer.parseInt((String) request.getSession().getAttribute("membersId")));
		request.getSession().setAttribute("notes", notes);
		return "memfor/mem_main";
	}
}
