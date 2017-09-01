/**
  *project project-second-lib
  *@author changchun.wu
  *2017年8月29日上午9:06:51
  */
package com.jianfei.pt.service.system;

import org.springframework.stereotype.Service;

import com.jianfei.pt.dao.system.LogAccessDao;
import com.jianfei.pt.entity.system.LogAccess;
import com.jianfei.pt.service.base.CrudService;

@Service
public class LogAccessService extends CrudService<LogAccessDao, LogAccess>{

}
