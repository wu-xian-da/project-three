/**
  *project project-three-forum
  *@author changchun.wu
  *2017年9月15日上午11:30:14
  */
package com.jianfei.pt.controller.forum;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jianfei.pt.controller.common.PageController;
import com.jianfei.pt.controller.common.TMBSelect;
import com.jianfei.pt.entity.common.NoteStatus;
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
	private ModulesService modulesService;
	
	@Autowired
	private MembersService membersService;
	
	@Autowired
	protected PageController<Notes> pageController;
	
	@Autowired
	private TMBSelect tmbSelect;

	public void setModel(Model model){
		model.addAttribute("status",NoteStatus.values());
		model.addAttribute("modulesall",modulesService.findAll());
		model.addAttribute("allmembers",membersService.findAll());
		model.addAttribute("allmodules",modulesService.findAll());
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String Forminsert(Model model){
		this.setModel(model);
		return "forum/notes/form";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(Model model,Notes notes,HttpServletRequest request){
		notesService.insert(notes);
		return "redirect:/forum/notes/"+request.getSession().getAttribute("membersId");
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String Formupdate(@PathVariable("id")int id,Model model){
		model.addAttribute("forumnotes",notesService.findById(id));
		this.setModel(model);
		return "forum/notes/form";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(Model model,Notes notes,HttpServletRequest request){
		notes.setStatus(NoteStatus.WFB);
		notes.setReleasetime(null);
		notesService.update(notes);
		return "redirect:/forum/notes/"+request.getSession().getAttribute("membersId");
	}
	
	/***
	 * 根据论坛内容ID查询,预览页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/selectnotes/{id}" ,method=RequestMethod.GET)
	public String selectnotes(@PathVariable("id")int id,Model model){
		model.addAttribute("notescontent",notesService.findById(id));
		this.setModel(model);
		return "forum/notes/browse";
	}
	
	/***
	 * 根据会员ID查询发帖内容
	 * @param membersId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{membersId}",method=RequestMethod.GET)
	public String list(@PathVariable("membersId")int membersId,Model model,Notes notes){
		//页面传输的pn,ps
		pageController.setPNPS(model,notes);
		
		//查询总记录条数
		int totalRecord = notesService.findCountBymembersId(membersId);
		pageController.findPage(model,notes,totalRecord);
		model.addAttribute("membersallnotes",notesService.findAllMemberNotesByMembersId(membersId,notes.getPn(),notes.getPs()));
		this.setModel(model);
		return "forum/notes/list";
	}
	
	/***
	 * 根据会员ID查询发帖内容
	 * @param membersId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/jsplist/{childsmodules}",method=RequestMethod.GET)
	public String jsplist(@PathVariable("childsmodules")int childsmodules,Model model,Notes notes){
		//页面传输的pn,ps
		pageController.setPNPS(model,notes);
		
		//查询总记录条数
		int totalRecord = notesService.findCountBychildsmodules(childsmodules);
		pageController.findPage(model,notes,totalRecord);
		
		model.addAttribute("childsnotes",notesService.findNotesByChildsModules(childsmodules,notes.getPn(),notes.getPs()));
		model.addAttribute("childsmodules",childsmodules);
		this.setModel(model);
		return "forum/notes/jsplist";
	}
	
	@RequestMapping(value="memForumlist/{membersId}",method=RequestMethod.GET)
	public String memForumlist(@PathVariable("membersId")int membersId,Model model,Notes notes){
		//页面传输的pn,ps
		pageController.setPNPS(model,notes);
		
		//查询总记录条数
		int totalRecord = notesService.findCountBymembersId(membersId);
		pageController.findPage(model,notes,totalRecord);
		model.addAttribute("notesbymembersId",notesService.findAllMemberNotesByMembersId(membersId,notes.getPn(),notes.getPs()));
		this.setModel(model);
		return "memfor/mem_forumlist";
	}
	
	@RequestMapping(value="/forumlistByparentmodules/{parentmodules}")
	public String forumlistByparentmodules(@PathVariable("parentmodules")int parentmodules,Model model,Notes notes){
		//页面传输的pn,ps
		pageController.setPNPS(model,notes);
		
		//查询总记录条数
		int totalRecord = notesService.findCountByParentModules(parentmodules);
		pageController.findPage(model,notes,totalRecord);
		model.addAttribute("parentmodules",parentmodules);
		model.addAttribute("forumlistByparentmodules",notesService.findNotesByParentModules(parentmodules,notes.getPn(),notes.getPs()));
		this.setModel(model);
		return "jsp/forumlist";
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
