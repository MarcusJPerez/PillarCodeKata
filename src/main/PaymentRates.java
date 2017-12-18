package main;

public class PaymentRates {

	private final int PAY_RATE_START_TO_BED_TIME = 12;
	private final int PAY_RATE_BEDTIME_TO_MIDNIGHT = 8;
	private final int PAY_RATE_MIDNIGHT_TO_END = 16;
	private final int MIDNIGHT = 2400;
	private final int CONVERSION_24_HOUR_TIME = 100;
	private final int LATEST_END_TIME = 400;

	public int calculatePayment(BabySitter babySitter) {
		int paymentReturnValue = calculatePaymentForHoursWithAnEndTimeAfterMidnight(babySitter);

		if (babySitter.getEndTime() > LATEST_END_TIME) {
			paymentReturnValue = calculatePaymentForHoursWithAnEndTimeBeforeMidnight(babySitter);
		}
		return paymentReturnValue;
	}

	private int calculatePaymentForHoursWithAnEndTimeAfterMidnight(BabySitter babySitter) {
		int paymentForHoursFromMidnightToEnd = (babySitter.getEndTime() * PAY_RATE_MIDNIGHT_TO_END)
				/ CONVERSION_24_HOUR_TIME;
		int paymentForHoursFromBedTimeToMidnight = PAY_RATE_BEDTIME_TO_MIDNIGHT
				* convertFor24HourTime(MIDNIGHT, babySitter.getBedTime());

		return calculatePaymentFromStartToBedTime(babySitter) + paymentForHoursFromBedTimeToMidnight
				+ paymentForHoursFromMidnightToEnd;
	}

	private int calculatePaymentForHoursWithAnEndTimeBeforeMidnight(BabySitter babySitter) {
		int hoursWorkdFromStartToEnd = convertFor24HourTime(babySitter.getEndTime(), babySitter.getStartTime());
		int hoursWorkdFromBedToEndTime = convertFor24HourTime(babySitter.getEndTime(), babySitter.getBedTime());
		int retVal = calculatePaymentFromStartToBedTime(babySitter)
				+ PAY_RATE_BEDTIME_TO_MIDNIGHT * hoursWorkdFromBedToEndTime;

		if (babySitter.getBedTime() == 0) {

			retVal = (PAY_RATE_START_TO_BED_TIME * hoursWorkdFromStartToEnd);
		}
		return retVal;
	}

	private int calculatePaymentFromStartToBedTime(BabySitter babySitter) {
		int hoursWorkedFromStartToBedTime = convertFor24HourTime(babySitter.getBedTime(), babySitter.getStartTime());

		return (PAY_RATE_START_TO_BED_TIME * hoursWorkedFromStartToBedTime);

	}

	private int convertFor24HourTime(int startTime, int subtractingTime) {

		return ((startTime - subtractingTime) / CONVERSION_24_HOUR_TIME);
	}
}
