package com.ibm.serial;

import java.io.Serializable;

public class Company implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5537945405591286515L;
	

	private int id;
	private String companyName;
	private int noOfSisterCompany;
	/**
	 * @param id
	 * @param companyName
	 * @param noOfSisterCompany
	 */
	public Company(int id, String companyName, int noOfSisterCompany) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.noOfSisterCompany = noOfSisterCompany;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the noOfSisterCompany
	 */
	public int getNoOfSisterCompany() {
		return noOfSisterCompany;
	}
	/**
	 * @param noOfSisterCompany the noOfSisterCompany to set
	 */
	public void setNoOfSisterCompany(int noOfSisterCompany) {
		this.noOfSisterCompany = noOfSisterCompany;
	}
	
	
	
}
