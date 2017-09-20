/**
  *project project-three-web
  *@author changchun.wu
  *2017年9月15日上午10:38:18
  */
package com.jianfei.pt.controller.forum;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jianfei.pt.entity.forum.Modules;
import com.jianfei.pt.entity.forum.Notes;
import com.jianfei.pt.service.forum.ModulesService;
import com.jianfei.pt.service.forum.NotesService;
import com.jianfei.pt.service.member.MembersService;

@Controller
@RequestMapping("/forum/notes")
public class NotesController {
	
	@Autowired
	private NotesService notesService;
	
	@Autowired
	private MembersService membersService;
	
	@Autowired
	private ModulesService modulesService;
	
	public void setModel(Model model){
		model.addAttribute("allmembers",membersService.findAll());
		model.addAttribute("allmodules",modulesService.findAll());
	}

	@RequestMapping
	public String list(Notes notes,Model model){
		model.addAttribute("allnotes",notesService.findCondition(notes));
		this.setModel(model);
		return "forum/notes/list";
	}
	
	/***
	 * 根据论坛内容ID查询,预览页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/selectnotes/{id}" ,method=RequestMethod.GET)
	public String selectnotes(@PathVariable("id")int id,Model model){
		this.setModel(model);
		model.addAttribute("notescontent",notesService.findById(id));
		return "forum/notes/browse";
	}
	
	/***
	 * 二级联动
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/modules/{parentmodules}",method=RequestMethod.GET)
	public void modules(@PathVariable("parentmodules")int parentmodules,HttpServletResponse response){
		List<Modules> moduleslist = modulesService.findModulesByParentId(parentmodules);
		if(moduleslist.size()!=0){
	 		String str1 = "";
	 		for(Modules m:moduleslist){
	 			String childsmodules = m.getId()+"";
	 			String name = m.getName();
	 			str1 = str1+childsmodules+","+name+"-";
	 		}
	 		String str2 = str1.substring(0, str1.length()-1);
			try {
				response.getWriter().write(str2.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				response.getWriter().write("0");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
