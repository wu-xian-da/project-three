/**
  *project project-second-lib
  *@author changchun.wu
  *2017年8月14日下午2:05:31
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
public class RoleMenu extends BaseEntity{
	
	private String name;

	private int roleId;
	
	private int titleId;
	
	private int menuId;
	
	private int buttonId;
	
	private List<String> roles;
	
	private List<String> titles;
	
	private List<String> menus;
	
	private List<String> buttons;
}
