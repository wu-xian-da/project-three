/**
  *project project-second-lib
  *@author changchun.wu
  *2017年8月14日下午2:05:31
  */
package com.jianfei.pt.entity.relation;

import java.util.List;

import com.jianfei.pt.entity.base.BaseEntity;
import com.jianfei.pt.entity.system.Menus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class RoleMenu extends BaseEntity{
	
	private String name;

	private int roleId;
	
	private int menusId;
	
	private List<String> roles;
	
	private Menus roleTMB;
	
}
