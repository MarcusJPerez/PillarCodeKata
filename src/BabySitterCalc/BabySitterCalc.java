/*
 * 
 * @author Marcus Perez
 * 
 */
package BabySitterCalc;

public class BabySitterCalc {

	public int startTime;
	public int endTime;
	public int bedTime;
	public int payRateStartToBedtime = 12;
	public int payRateBedTimeToMidnight = 8;
	public int payRateMidnightToEnd = 16;
	public final int MIDNIGHT = 2400;
	public final int MILITARY_CONVERSION = 100;
	public String StartOrEndTimeErrorMessage = null;
	

	public BabySitterCalc() {
		this.startTime = 1700;
		this.endTime = 400;
		this.bedTime = 2400;
	}

	public String getStartOrEndTimeErrorMessage() {
		if ((startTime < 1700 && startTime > 400) || (endTime < 1700 && endTime > 400)) {
			StartOrEndTimeErrorMessage = "I can only babysit between 5pm and 4am.";
		}
		return StartOrEndTimeErrorMessage;
	}

	public int calculatePayment() {
		int totalPayment;

		if (endTime > 400) {
			totalPayment = (payRateStartToBedtime * ((bedTime - startTime) / MILITARY_CONVERSION)
					+ (payRateBedTimeToMidnight * ((endTime - bedTime) / MILITARY_CONVERSION)));
		} else
			totalPayment = ((payRateStartToBedtime * ((bedTime - startTime) / MILITARY_CONVERSION))
					+ (payRateBedTimeToMidnight * ((MIDNIGHT - bedTime) / MILITARY_CONVERSION))
					+ ((endTime * payRateMidnightToEnd) / MILITARY_CONVERSION));

		return totalPayment;

	}

	public int getPayRateStartToBedtime() {
		return payRateStartToBedtime;
	}

	public void setPayRateStartToBedtime(int payRateStartToBedtime) {
		this.payRateStartToBedtime = payRateStartToBedtime;
	}

	public int getPayRateBedTimeToMidnight() {
		return payRateBedTimeToMidnight;
	}

	public void setPayRateBedTimeToMidnight(int payRateBedTimeToMidnight) {
		this.payRateBedTimeToMidnight = payRateBedTimeToMidnight;
	}

	public int getPayRateMidnightToEnd() {
		return payRateMidnightToEnd;
	}

	public void setPayRateMidnightToEnd(int payRateMidnightToEnd) {
		this.payRateMidnightToEnd = payRateMidnightToEnd;
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
