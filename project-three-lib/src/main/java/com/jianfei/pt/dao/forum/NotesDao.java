/**
  *project project-three-lib
  *@author changchun.wu
  *2017年9月15日上午10:15:28
  */
package com.jianfei.pt.dao.forum;

import java.util.List;

import com.jianfei.pt.dao.base.CrudDao;
import com.jianfei.pt.entity.forum.Notes;

public interface NotesDao extends CrudDao<Notes> {

	public List<Notes> findNotesByMembersId(int modulesId);
	
	public List<Notes> findAllMemberNotesByMembersId(int modulesId);
	
	public List<Notes> findNotesByChildsModules(int childsmodules);

}
