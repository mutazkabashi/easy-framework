package org.easy.common.business.service;

import java.io.Serializable;
import java.util.List;

import org.easy.common.persistence.pojo.CorePojo;

//import com.kax.bussines.repository.common.CoreRepository;

public interface CoreService extends Serializable {

	// public CoreRepository cr = null;

	public String add(CorePojo core);

	public String delete(CorePojo core);

	public String update(CorePojo core);

	public String get(CorePojo core);

	public List<CorePojo> getAll();
	
	public CorePojo getById(Object o);

}
