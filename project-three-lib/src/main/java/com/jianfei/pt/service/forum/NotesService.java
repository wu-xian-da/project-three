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
	public List<Notes> findAllMemberNotesByMembersId(int modulesId,int pn,int ps){
		return this.dao.findAllMemberNotesByMembersId(modulesId,pn,ps);
	}
	
	public int findCountBymembersId(int membersId){
		return this.dao.findCountBymembersId(membersId);
	}
	
	
	public List<Notes> findNotesByChildsModules(int childsmodules,int pn,int ps){
		return this.dao.findNotesByChildsModules(childsmodules,pn,ps);
	}
	
	
	/***
	 * 根据状态查询论坛文章
	 * @param notes
	 * @return
	 */
	public List<Notes> findConditionByStatus(Notes notes){
		return this.dao.findConditionByStatus(notes);
	}
	
	/**
	 * 根据状态查询论坛文章的数量
	 * @param notes
	 * @return
	 */
	public int findCountByStatus(){
		return this.dao.findCountByStatus();
	}
	
	public int findCountBychildsmodules(int childsmodules){
		return this.dao.findCountBychildsmodules(childsmodules);
	}

	public int findCountByParentModules(int parentmodules) {
		// TODO Auto-generated method stub
		return this.dao.findCountByParentModules(parentmodules);
	}

	public List<Notes> findNotesByParentModules(int parentmodules, int pn, int ps) {
		// TODO Auto-generated method stub
		return this.dao.findNotesByParentModules(parentmodules,pn,ps);
	}

}
