/**
  *project project-second-lib
  *@author changchun.wu
  *2017年8月14日下午2:07:48
  */
package com.jianfei.pt.dao.relation;

import java.util.List;

import com.jianfei.pt.dao.base.CrudDao;
import com.jianfei.pt.entity.relation.RoleMenu;
import com.jianfei.pt.entity.system.Menus;

public interface RoleMenuDao extends CrudDao<RoleMenu> {

	/***
	 * 根据roleId查询RoleMenu
	 * @param id
	 * @return
	 */
	public List<RoleMenu> findRoleByRoleId(int id);
	
	public List<RoleMenu> findRolesRoleId();
	
	/***
	 * 查询角色与权限之间的关联
	 * @param roleId
	 * @return
	 */
	public List<Menus> findTMBMenusByRoles(int roleId);
	
}
