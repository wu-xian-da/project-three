/**
  *project project-three-web
  *@author changchun.wu
  *2017年9月15日上午10:38:43
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
import com.jianfei.pt.service.forum.ModulesService;

@Controller
@RequestMapping("/forum/modules")
public class ModulesController {
	
	@Autowired
	private ModulesService modulesService;
	
	public void setModel(Model model){
		model.addAttribute("modulesalllist",modulesService.findAll());
	}

	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String Forminsert(Modules modules,Model model){
		this.setModel(model);
		return "forum/modules/form";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(Modules modules,Model model){
		modulesService.insert(modules);
		return "redirect:/forum/modules";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String Formupdate(Model model,@PathVariable("id")int id){
		this.setModel(model);
		model.addAttribute("entitymodules",modulesService.findById(id));
		return "forum/modules/form";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(Model model,@PathVariable("id")int id,Modules modules){
		List<Modules> module = modulesService.findModulesByParentId(id);
		if(module.size() != 0){
			
		}else{
			
		}
		modulesService.update(modules);
		return "redirect:/forum/modules";
	}
	
	@RequestMapping
	public String list(Model model,Modules modules){
		model.addAttribute("allmodules",modulesService.findCondition(modules));
		this.setModel(model);
		return "forum/modules/list";
	}
	
	@RequestMapping(value="selectmodulesById/{id}",method=RequestMethod.GET)
	public void selectmodulesById(@PathVariable("id")int id,HttpServletResponse response){
		List<Modules> module = modulesService.findModulesByParentId(id);
		if(module.size() != 0){
			try {
				response.getWriter().write("1");
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
