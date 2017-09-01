/**
  *project project-second-web
  *@author changchun.wu
  *2017年8月29日上午9:08:35
  */
package com.jianfei.pt.controller.log;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jianfei.pt.entity.system.LogAccess;
import com.jianfei.pt.service.relation.RoleMenuService;
import com.jianfei.pt.service.system.LogAccessService;

@Controller
@RequestMapping("/log/access")
public class LogAccessController {

	@Autowired
	private LogAccessService logAccessService;
	
	@Autowired
	private RoleMenuService roleMenuService;
	
	private void setModel(Model model){
		//分页操作
		model.addAttribute("page",new LogAccess());
	}
	
	@RequestMapping
	public String list(Model model,LogAccess logAccess,HttpServletRequest request){
		
		//页面传输的pn,ps
		logAccess.setPn(logAccess.pn*logAccess.ps);
		logAccess.setPs(logAccess.ps);
		
		if (logAccess.getLoginname() == null && logAccess.getIp() ==null) {
			//总记录条数
			int totalRecord = logAccessService.findCount();
			model.addAttribute("totalRecord",totalRecord);
			//分页的页数
			int pageNo = (totalRecord % new LogAccess().pageSize) == 0 ? totalRecord / new LogAccess().pageSize : totalRecord / new LogAccess().pageSize + 1 ;
			model.addAttribute("pageNo",pageNo);
			//上一页的数值变化
			model.addAttribute("bianPageShang",logAccess.pn/logAccess.ps-1);
			//下一页的数值变化
			model.addAttribute("bianPageXia",logAccess.pn/logAccess.ps+1);

			model.addAttribute("accessurl","");
		} else {
			//条件查询总记录条数
			int totalRecord = logAccessService.findCountByT(logAccess);
			model.addAttribute("totalRecord",totalRecord);
			//分页的页数
			int pageNo = (totalRecord % new LogAccess().pageSize) == 0 ? totalRecord / new LogAccess().pageSize : totalRecord / new LogAccess().pageSize + 1 ;
			model.addAttribute("pageNo",pageNo);
			//上一页的数值变化
			model.addAttribute("bianPageShang",logAccess.pn/logAccess.ps-1);
			//下一页的数值变化
			model.addAttribute("bianPageXia",logAccess.pn/logAccess.ps+1);
			
			model.addAttribute("accessurl","&loginname="+logAccess.getLoginname()+"&ip="+logAccess.getIp());
		}
		//分页,条件查询,所有查询
		model.addAttribute("logAccess",this.logAccessService.findCondition(logAccess));
		
		
		this.setModel(model);
		//查询按钮
		model.addAttribute("button_id",this.roleMenuService.findBUTTON(Integer.parseInt(request.getParameter("roleId"))));
		return "log/access";
	}
}
