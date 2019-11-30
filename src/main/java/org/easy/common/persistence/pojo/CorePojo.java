package org.easy.common.persistence.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.easy.common.Core;



@MappedSuperclass
public class CorePojo extends Core implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 893470418259662301L;
	
	private static final Logger logger =getLogger();
	
	


	private Integer id;
	
	
	private Integer version;
	
	
	private String itemLabel;
	
	
	/**
	 * timestamp when the record was originally created.
	 *
	 */
	private Date creationDate;

	/**
	 * timestamp when the record was last updated.
	 *
	 */
	private Date lastUpdated;
	
	public CorePojo(){
		logger.debug("CorePojo Constructor start");
		init();
		logger.info("Creatindate and lastUpdated Field has been init Succefully @Constructor ");
		logger.debug("CorePojo Constructor end ");
	}
	
	
	public void init(){
		logger.debug("CorePojo init() start");
		creationDate = new Date();
		lastUpdated  = new Date();
		logger.debug("CorePojo init() end");
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CorePojo other = (CorePojo) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "CorePojo [id=" + id + ", version=" + version
				+ ", creationDate=" + creationDate + ", lastUpdated="
				+ lastUpdated + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	@Version
	public Integer getVersion() {
		return version;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Transient
	public String getItemLabel() {
		return itemLabel;
	}


	public void setItemLabel(String itemLabel) {
		this.itemLabel = itemLabel;
	}


	public Date getCreationDate() {
		return creationDate;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
