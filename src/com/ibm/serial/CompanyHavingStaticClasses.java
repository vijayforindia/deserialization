package com.ibm.serial;

import java.io.Serializable;



public class CompanyHavingStaticClasses implements Serializable{

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
	public CompanyHavingStaticClasses(int id, String companyName, int noOfSisterCompany) {
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
	
	 public static class ClientConfig implements Serializable
	    {
		 /**
		 * 
		 */
		private static final long serialVersionUID = -9108583017894752367L;
		
			public int heartBeatRateSec;
	        public TestCompany lcdo;
	        public Integer hbFromServerRateSec = null;
	        
	        public ClientConfig(int heartBeatRateSec, TestCompany lcdo)
	        {
	            this.heartBeatRateSec = heartBeatRateSec;
	            this.lcdo = lcdo;
	        }        
	        public ClientConfig(int heartBeatRateSec, TestCompany lcdo,
	        		Integer hbFromServerRateSec)
	        {
	            this.heartBeatRateSec = heartBeatRateSec;
	            this.lcdo = lcdo;
	            this.hbFromServerRateSec = hbFromServerRateSec;
	        }
	    }

	    public static class SCConfig extends ClientConfig implements Serializable
	    {
	    	/**
			 * 
			 */
			private static final long serialVersionUID = 8999392278461600198L;

			
			public int scToServerHBInterval = 60;	//	in seconds 	- 1 min

	    	public int agentToScHBInterval	 = 60;	//	in seconds 	- 1 min

	    	public int scToAgentHBInterval	 = 300;	// in seconds	- 5 min
	        
	    	public int serverToSCHBInterval = 300;  // in seconds	- 5 min
	    							
	        public SCConfig(TestCompany lcdo,int serverToSCHBInterval,int scToServerHBInterval,int agentToScHBInterval,int scToAgentHBInterval)
	        {        
	        	super(agentToScHBInterval, lcdo, scToAgentHBInterval);
	        	this.serverToSCHBInterval= serverToSCHBInterval; 
	        	this.scToServerHBInterval = scToServerHBInterval;
	        	this.agentToScHBInterval = agentToScHBInterval;
	        	this.scToAgentHBInterval = scToAgentHBInterval;
	        }        
	    }
	     private String signature;

		public String getSignature() {
			return signature;
		}


		public void setSignature(String signature) {
			this.signature = signature;
		}
	
}
