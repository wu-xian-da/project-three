/**
  *project project-three-lib
  *@author changchun.wu
  *2017年9月15日上午10:19:33
  */
package com.jianfei.pt.service.forum;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jianfei.pt.dao.forum.NotesDao;
import com.jianfei.pt.entity.forum.Notes;
import com.jianfei.pt.service.base.CrudService;

@Service
public class NotesService extends CrudService<NotesDao, Notes> {

	/***
	 * 根据会员ID和状态查询发帖内容
	 * @param id
	 * @return
	 */
	public List<Notes> findNotesByMembersId(int modulesId){
		return this.dao.findNotesByMembersId(modulesId);
	}
	
	/***
	 * 根据会员ID查询发帖内容
	 * @param id
	 * @return
	 */
	public List<Notes> findAllMemberNotesByMembersId(int modulesId){
		return this.dao.findAllMemberNotesByMembersId(modulesId);
	}
	
	public List<Notes> findNotesByChildsModules(int childsmodules){
		return this.dao.findNotesByChildsModules(childsmodules);
	}
}
