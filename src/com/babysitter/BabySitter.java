package com.babysitter;



public class BabySitter {

	public int startTime;
	public int endTime;
	public String StartOrEndTimeErrorMessage;

	public BabySitter() {
		this.startTime = 17;
		this.endTime = 4;
	}

	

	public BabySitter(int startTime, int endTime) {
		if( startTime < 17 || startTime > 4) {
			StartOrEndTimeErrorMessage ="I can only babysit between 5pm and 4am.";
			
		}
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getStartOrEndTimeErrorMessage() {
		return StartOrEndTimeErrorMessage;
	}



	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}


}
