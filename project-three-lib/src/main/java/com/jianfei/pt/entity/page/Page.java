/**
  *project project-three-lib
  *@author changchun.wu
  *2017年9月1日上午10:54:52
  */
package com.jianfei.pt.entity.page;

import java.util.ArrayList;
import java.util.List;

import com.jianfei.pt.entity.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Page<T> extends BaseEntity{

	//private int[] defaultPageSizeSelect = {10,20,30,40,50};//显示当前页面的数据条数
	
	//private int pageNo;//页码
	
	//public int pageSize;//默认页展示记录数
	
	//private long totalRecord;//总记录数
	
	//private int viewPageNumber = 8;// 显示页面长度
	
    private List<T> data = new ArrayList<T>();
    
    private T entity; //查询对象
    
    //private String urlParams; //get查询参数封装
    
    //private int ps = 10; //默认值
    
    //private int pn = 1; //默认值
}
