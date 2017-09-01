/**
  *project project-second-lib
  *@author changchun.wu
  *2017年8月12日下午1:05:37
  */
package com.jianfei.pt.entity.relation;

import java.util.List;

import com.jianfei.pt.entity.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class UserRole extends BaseEntity{
	
	private int userId;
	
	private int roleId;
	
	private List<String> roles;
	
	private List<String> users;
	
}
