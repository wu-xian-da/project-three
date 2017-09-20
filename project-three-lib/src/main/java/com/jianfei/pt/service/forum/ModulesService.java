/**
  *project project-three-lib
  *@author changchun.wu
  *2017年9月15日上午10:20:33
  */
package com.jianfei.pt.service.forum;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jianfei.pt.dao.forum.ModulesDao;
import com.jianfei.pt.entity.forum.Modules;
import com.jianfei.pt.service.base.CrudService;

@Service
public class ModulesService extends CrudService<ModulesDao, Modules> {
	
	/***
	 * 根据父级ID查询父模块下的子模块
	 * @param parentId
	 * @return
	 */
	public List<Modules> findModulesByParentId(int parentId){
		return this.dao.findModulesByParentId(parentId);
	}
}
