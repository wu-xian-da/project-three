/**
  *project project-three-lib
  *@author changchun.wu
  *2017年9月15日上午10:17:23
  */
package com.jianfei.pt.service.member;

import org.springframework.stereotype.Service;

import com.jianfei.pt.dao.member.MembersDao;
import com.jianfei.pt.entity.member.Members;
import com.jianfei.pt.service.base.CrudService;

@Service
public class MembersService extends CrudService<MembersDao, Members>{

	public int insertMembers(String account,String password){
		return this.dao.insertMembers(account, password);
	}
	
	public Members findMembersByAccount(String account,String password){
		return this.dao.findMembersByAccount(account, password);
	}
}
