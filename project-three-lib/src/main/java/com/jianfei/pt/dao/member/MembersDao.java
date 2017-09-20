/**
  *project project-three-lib
  *@author changchun.wu
  *2017年9月15日上午10:14:39
  */
package com.jianfei.pt.dao.member;

import com.jianfei.pt.dao.base.CrudDao;
import com.jianfei.pt.entity.member.Members;

public interface MembersDao extends CrudDao<Members>{

	public int insertMembers(String account,String password);
	
	public Members findMembersByAccount(String account,String password);
}
