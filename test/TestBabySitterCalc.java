/*
 * @author Marcus Perez
 */

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestBabySitterCalc {

	BabySitter babySitterTest;
	PaymentRates paymentRatesTest;
	String InvalidString = "I can only babysit between 5pm and 4am.";

	@Before
	public void beforeEach() {
		paymentRatesTest = new PaymentRates();
		babySitterTest = new BabySitter();
	}
	@Test
	public void babySitterStartTimeReturns1700() {
		assertEquals(1700, babySitterTest.getStartTime());
	}
	@Test
	public void babySitterStartTimeReturnsNewStartTime() {
		babySitterTest.setStartTime(1800);
		assertEquals(1800, babySitterTest.getStartTime());
	}
	@Test
	public void babySitterEndTimeReturnsNewEndTime() {
		assertEquals(400, babySitterTest.getEndTime());
	}
	@Test
	public void babySitterStartTimeReturnsNewStart() {
		babySitterTest.setStartTime(1800);
		babySitterTest.setEndTime(300);
		assertEquals(1800, babySitterTest.getStartTime());
	}
	@Test
	public void babySitterEndTimeReturnsNewEnd() {
		babySitterTest.setStartTime(1800);
		babySitterTest.setEndTime(300);
		assertEquals(300, babySitterTest.getEndTime());
	}
	@Test()
	public void invalidStartTimeReturnsInvalidMessage() {
		babySitterTest.setStartTime(1600);
		babySitterTest.setEndTime(400);
		assertEquals(true, InvalidString.equals(paymentRatesTest.determineIfStartAndEndTimesAreBothValid(babySitterTest)));
	}
	@Test()
	public void validStartTimeDoesNotReturnInvalidMessage() {
		babySitterTest.setStartTime(1700);
		babySitterTest.setEndTime(400);
		assertEquals(false, InvalidString.equals(paymentRatesTest.determineIfStartAndEndTimesAreBothValid(babySitterTest)));
	}
	@Test()
	public void returnPaymentForStartTimeToBedTime() {
		babySitterTest.setStartTime(1700);
		babySitterTest.setBedTime(2300);
		babySitterTest.setEndTime(2300);
		assertEquals(72, paymentRatesTest.calculatePayment(babySitterTest));
	}
	@Test()
	public void returnPaymentForStartTimeToMidnightWithBedtime() {
		babySitterTest.setStartTime(1700);
		babySitterTest.setBedTime(2300);
		babySitterTest.setEndTime(2400);
		assertEquals(80, paymentRatesTest.calculatePayment(babySitterTest));
	}
	@Test()
	public void returnPaymentForStartTimeToEndTimeWithBedtime() {
		babySitterTest.setStartTime(1800);
		babySitterTest.setBedTime(2000);
		babySitterTest.setEndTime(300);
		assertEquals(104, paymentRatesTest.calculatePayment(babySitterTest));
	}
	@Test()
	public void returnPaymentForStartTimeToEndTimeWithBedtimeNoPartialHoursIncluded() {
		babySitterTest.setStartTime(1850);
		babySitterTest.setBedTime(2050);
		babySitterTest.setEndTime(350);
		assertEquals(104, paymentRatesTest.calculatePayment(babySitterTest));
	}
}
