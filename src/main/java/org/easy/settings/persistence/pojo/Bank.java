package org.easy.settings.persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import org.easy.common.persistence.pojo.CorePojo;


@NamedQueries({
    @NamedQuery(
    name = "getAllBanks",
    query = "from Bank"
    ),
    @NamedQuery(
    name = "findBamkByName",
    query = "from Bank b where b.name = :name"
    	    )
})

/**
 * 
 * @author Mutaz Hussein Kabashi
 *
 */
@Entity
public class Bank extends CorePojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8239569515298569346L;
	private String name;
	private String address;
	private String swiftCode;
	//private Country country;
	private Integer countryId;

	public Bank() {
		super.init();
		init();
	}

	public void init() {
		//country = new Country();
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		//result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((countryId == null) ? 0 : countryId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((swiftCode == null) ? 0 : swiftCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		/*if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;*/
		if (countryId == null) {
			if (other.countryId != null)
				return false;
		} else if (!countryId.equals(other.countryId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (swiftCode == null) {
			if (other.swiftCode != null)
				return false;
		} else if (!swiftCode.equals(other.swiftCode))
			return false;
		return true;
	}

	
	
	
	
	@Override
	public String toString() {
		return "Bank [name=" + name + ", address=" + address + ", swiftCode="
				+ swiftCode + /*", country=" + country + ", countryId="*/
				+ countryId + ", toString()=" + super.toString() + "]";
	}

	public String getName() {
		return name;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(insertable = false, updatable = false)
	/*public Country getCountry() {
		return country;
	}*/

	/*public void setCountry(Country country) {
		this.country = country;
	}*/

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	@Column(name = "COUNTRY_ID")
	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	
	@Transient
	public String getItemLabel() {
		return this.getName();
	}

}
