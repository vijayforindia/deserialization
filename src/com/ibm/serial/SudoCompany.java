/**
 * 
 */
package com.ibm.serial;

/**
 * @author vijaykumar
 *
 */
public class SudoCompany extends Company {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6834175189818422195L;

	/**
	 * @param id
	 * @param companyName
	 * @param noOfSisterCompany
	 * @param otherMainWork
	 */
	public SudoCompany(int id, String companyName, int noOfSisterCompany, String otherMainWork) {
		super(id, companyName, noOfSisterCompany);
		this.otherMainWork = otherMainWork;
	}

	private String otherMainWork;

	/**
	 * @return the otherMainWork
	 */
	public String getOtherMainWork() {
		return otherMainWork;
	}

	/**
	 * @param otherMainWork the otherMainWork to set
	 */
	public void setOtherMainWork(String otherMainWork) {
		this.otherMainWork = otherMainWork;
	}
	
}
