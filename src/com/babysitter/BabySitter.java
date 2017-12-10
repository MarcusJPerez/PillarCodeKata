package com.babysitter;

public class BabySitter {

	public int startTime;
	public int endTime;
	public int bedTime;
	public int payRateStartToBedtime = 12;
	
	public String StartOrEndTimeErrorMessage;

	public BabySitter() {
		this.startTime = 1700;
		this.endTime = 400;
		this.bedTime = 2400;
	}

	public BabySitter(int startTime, int endTime, int bedTime) {
		getStartOrEndTimeErrorMessage();
		this.startTime = startTime;
		this.endTime = endTime;
		this.bedTime = bedTime;
	}

	public String getStartOrEndTimeErrorMessage() {
		if (startTime < 1700 || startTime > 400 || endTime < 1700 || endTime > 400) {
			StartOrEndTimeErrorMessage = "I can only babysit between 5pm and 4am.";
		}
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

	public int getBedTime() {
		return bedTime;
	}

	public void setBedTime(int bedTime) {
		this.bedTime = bedTime;
	}

	public int calculatePayment() {
		
		
		return payRateStartToBedtime * (bedTime - startTime)/(100);
		
		
	}

	

}
