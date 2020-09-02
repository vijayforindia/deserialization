/**
 * 
 */
package com.ibm.serial;

import java.io.Serializable;

/**
 * @author vijaykumar
 *
 */
public class TestCompany implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3071565125912900413L;
	
	private int id;
	private String companyName;
	public int number;
	/**
	 * @param id
	 * @param companyName
	 * @param number
	 */
	public TestCompany(int id, String companyName, int number) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.number = number;
	}
	
	
}
