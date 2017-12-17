
public class BabySitter {

	private int startTime;
	private int endTime;
	private int bedTime;

	public BabySitter() {
		this.startTime = 1700;
		this.endTime = 400;
		this.bedTime = 2400;

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
