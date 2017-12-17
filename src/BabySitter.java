
public class BabySitter {

	private int startTime;
	private int endTime;
	private int bedTime;
	private final int EARLIEST_START_TIME = 1700;
	private final int LATEST_END_TIME = 400;
	private String StartOrEndTimeErrorMessage = null;

	public BabySitter() {

	}
	

	public String determineIfStartAndEndTimesAreBothValid() {
		if ((getStartTime() < EARLIEST_START_TIME && getStartTime() > LATEST_END_TIME)
				|| (getEndTime() < EARLIEST_START_TIME && getEndTime() > LATEST_END_TIME)) {
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

}
