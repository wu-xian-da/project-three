/**
  *project project-second-web
  *@author changchun.wu
  *2017年8月28日下午3:26:59
  */
package com.jianfei.pt.controller.log;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jianfei.pt.entity.system.LogLogin;
import com.jianfei.pt.service.relation.RoleMenuService;
import com.jianfei.pt.service.system.LogLoginService;

@Controller
@RequestMapping("/log/logins")
public class LogLoginController {
	
	@Autowired
	private LogLoginService logLoginService;
	
	@Autowired
	private RoleMenuService roleMenuService;
	
	private void setModel(Model model){
		//分页操作
		model.addAttribute("page",new LogLogin());
	}
	
	@RequestMapping
	public String list(Model model,LogLogin logLogin,HttpServletRequest request){
		//页面传输的pn,ps
		logLogin.setPn(logLogin.pn*logLogin.ps);
		logLogin.setPs(logLogin.ps);
		
		if (logLogin.getLoginname() == null && logLogin.getIp() ==null) {
			//总记录条数
			int totalRecord = logLoginService.findCount();
			model.addAttribute("totalRecord",totalRecord);
			//分页的页数
			int pageNo = (totalRecord % new LogLogin().pageSize) == 0 ? totalRecord / new LogLogin().pageSize : totalRecord / new LogLogin().pageSize + 1 ;
			model.addAttribute("pageNo",pageNo);
			//上一页的数值变化
			model.addAttribute("bianPageShang",logLogin.pn/logLogin.ps-1);
			//下一页的数值变化
			model.addAttribute("bianPageXia",logLogin.pn/logLogin.ps+1);
			
			model.addAttribute("loginsurl","");
		} else {
			//条件查询总记录条数
			int totalRecord = logLoginService.findCountByT(logLogin);
			model.addAttribute("totalRecord",totalRecord);
			//分页的页数
			int pageNo = (totalRecord % new LogLogin().pageSize) == 0 ? totalRecord / new LogLogin().pageSize : totalRecord / new LogLogin().pageSize + 1 ;
			model.addAttribute("pageNo",pageNo);
			//上一页的数值变化
			model.addAttribute("bianPageShang",logLogin.pn/logLogin.ps-1);
			//下一页的数值变化
			model.addAttribute("bianPageXia",logLogin.pn/logLogin.ps+1);
			
			model.addAttribute("loginsurl","&loginname="+logLogin.getLoginname()+"&ip="+logLogin.getIp());
		}
		//分页,条件查询,所有查询
		model.addAttribute("logLogin",this.logLoginService.findCondition(logLogin));
		
		
		this.setModel(model);
		//查询按钮
		model.addAttribute("button_id",this.roleMenuService.findBUTTON(Integer.parseInt(request.getParameter("roleId"))));
		return "log/logins";
	}
}
