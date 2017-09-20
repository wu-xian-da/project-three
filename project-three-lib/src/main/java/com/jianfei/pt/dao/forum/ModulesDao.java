/**
  *project project-three-lib
  *@author changchun.wu
  *2017年9月15日上午10:16:10
  */
package com.jianfei.pt.dao.forum;

import java.util.List;

import com.jianfei.pt.dao.base.CrudDao;
import com.jianfei.pt.entity.forum.Modules;

public interface ModulesDao extends CrudDao<Modules> {

	public List<Modules> findModulesByParentId(int parentId);
	
}
