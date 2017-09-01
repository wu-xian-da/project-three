/**
  *project project-second-lib
  *@author changchun.wu
  *2017年8月28日下午2:48:54
  */
package com.jianfei.pt.service.system;

import org.springframework.stereotype.Service;

import com.jianfei.pt.dao.system.LogLoginDao;
import com.jianfei.pt.entity.system.LogLogin;
import com.jianfei.pt.service.base.CrudService;

@Service
public class LogLoginService extends CrudService<LogLoginDao, LogLogin> {

}
