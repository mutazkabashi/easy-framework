package org.easy.common.persistence.repository;

import java.util.List;

import org.easy.common.persistence.pojo.CorePojo;

/**
 * Base Repository that handles the basic CRUD (create,read, update, and delete) operation that almost all entities need
 * 
 * @author Mutaz Hussein Kabashi
 *
 */

  //TODO CHANGE METHODS ACCESS SPECIFIER TO BE PROTECTED INSTEAD OF PUBLIC 

public interface CoreRepository {

	public void save(CorePojo pojo);
 
	public void update(CorePojo pojo);

	public void delete(CorePojo pojo);
	
	public List<CorePojo> selectAll(Object o);
	
	public List<CorePojo> selectAll();  //TODO should be Cheked
	
	public CorePojo getById(Object o);  //TODO should be checked
}
