package com.babysitter;

public class BabySitter {

	public int startTime;
	public int endTime;

	public BabySitter() {
		this.startTime = 17;
		this.endTime = 4;
	}

	public BabySitter(int startTime) {
		this.startTime = startTime;

	}

	public BabySitter(int startTime, int endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
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
