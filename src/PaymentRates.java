/*
 * @author Marcus Perez
 */

public class PaymentRates {

	private final int PAY_RATE_START_TO_BED_TIME = 12;
	private final int PAY_RATE_BEDTIME_TO_MIDNIGHT = 8;
	private final int PAY_RATE_MIDNIGHT_TO_END = 16;
	private final int MIDNIGHT = 2400;
	private final int MILITARY_CONVERSION = 100;
	private String StartOrEndTimeErrorMessage = null;

	public String determineIfStartAndEndTimesAreBothValid(BabySitter babySitter) {
		if ((babySitter.getStartTime() < 1700 && babySitter.getStartTime() > 400)
				|| (babySitter.getEndTime() < 1700 && babySitter.getEndTime() > 400)) {
			StartOrEndTimeErrorMessage = "I can only babysit between 5pm and 4am.";
		}
		return StartOrEndTimeErrorMessage;
	}

	public int calculatePayment(BabySitter babySitter) {
		if (babySitter.getEndTime() > 400) {
			return calculatePaymentForHoursWithAnEndTimeBeforeMidnight(babySitter);
		} else
			return calculatePaymentForHoursWithAnEndTimeAfterMidnight(babySitter);

	}

	private int calculatePaymentForHoursWithAnEndTimeAfterMidnight(BabySitter babySitter) {
		return calculatePaymentFromStartToBedTime(babySitter)

				+ PAY_RATE_BEDTIME_TO_MIDNIGHT * ((MIDNIGHT - babySitter.getBedTime()) / MILITARY_CONVERSION)

				+ (babySitter.getEndTime() * PAY_RATE_MIDNIGHT_TO_END) / MILITARY_CONVERSION;
	}

	private int calculatePaymentForHoursWithAnEndTimeBeforeMidnight(BabySitter babySitter) {
		return calculatePaymentFromStartToBedTime(babySitter)

				+ PAY_RATE_BEDTIME_TO_MIDNIGHT
						* ((babySitter.getEndTime() - babySitter.getBedTime()) / MILITARY_CONVERSION);
	}

	private int calculatePaymentFromStartToBedTime(BabySitter babySitter) {
		return (PAY_RATE_START_TO_BED_TIME
				* ((babySitter.getBedTime() - babySitter.getStartTime()) / MILITARY_CONVERSION));

	}
}