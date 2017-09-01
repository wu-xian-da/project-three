/**
  *project project-second-lib
  *@author changchun.wu
  *2017年8月11日上午9:55:33
  */
package com.jianfei.pt.dao.system;

import java.util.Date;

import com.jianfei.pt.dao.base.CrudDao;
import com.jianfei.pt.entity.system.Users;

public interface UsersDao extends CrudDao<Users>{
	/***
	 * 用户登录
	 * @param loginTime
	 * @return
	 */
	public Users findUsersByNickname(String nickname);
	
	public int insertLoginTime(Date loginTime);
	
	public int updateLoginTimeAndIp(Users users);
	
	public int insertUserRoleId(int userId,int roleId); 
}
