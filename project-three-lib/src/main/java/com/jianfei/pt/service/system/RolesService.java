/**
  *project project-second-lib
  *@author changchun.wu
  *2017年8月11日上午9:59:52
  */
package com.jianfei.pt.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianfei.pt.dao.system.RolesDao;
import com.jianfei.pt.entity.system.Roles;
import com.jianfei.pt.service.base.CrudService;

@Service
public class RolesService extends CrudService<RolesDao, Roles> {

	@Autowired
	private RolesDao rolesDao;
	
	public Roles findRolesByRolename(String rolename){
		return this.rolesDao.findRolesByRolename(rolename);
	}
	
	/*public int insertRoleMenu(int id,int titleId,int menuId,int buttonId){
		return this.rolesDao.insertRoleMenu(id,titleId, menuId,buttonId);
	}*/
	
	public int insertRoleMenu(int id,int menubutton){
		return this.rolesDao.insertRoleMenu(id,menubutton);
	}
}
