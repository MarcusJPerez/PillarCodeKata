package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.BabySitter;
import src.PaymentRates;

public class PaymentRatesTest {
	BabySitter babySitterTest;
	PaymentRates paymentRatesTest;
	

	@Before
	public void beforeEach() {
		paymentRatesTest = new PaymentRates();
		babySitterTest = new BabySitter();
	}


	

	@Test()
	public void itCanCalculatePayGivenAStartTimeAndNoBedTimeAndAnEndTimeBeforeMidnight() {
		babySitterTest.setStartTime(1700);
		babySitterTest.setEndTime(2300);
		assertEquals(72, paymentRatesTest.calculatePayment(babySitterTest));
	}

	@Test()
	public void itCanCalculatePayGivenAStartTimeBeforeBedTimeAndAnEndTimeBeforeMidnight() {
		babySitterTest.setStartTime(1700);
		babySitterTest.setBedTime(2300);
		babySitterTest.setEndTime(2400);
		assertEquals(80, paymentRatesTest.calculatePayment(babySitterTest));
	}

	@Test()
	public void itCanCalculatePayGivenAStartTimeBeforeBedTimeAndAnEndTimeAfterMidnight() {
		babySitterTest.setStartTime(1800);
		babySitterTest.setBedTime(2000);
		babySitterTest.setEndTime(300);
		assertEquals(104, paymentRatesTest.calculatePayment(babySitterTest));
	}

	@Test()
	public void itCanCalculatePayGivenStartTimeBEforeBedTimeAndAnEndTimeAfterMidnightWithNoPayForPartialHours() {
		babySitterTest.setStartTime(1850);
		babySitterTest.setBedTime(2050);
		babySitterTest.setEndTime(350);
		assertEquals(104, paymentRatesTest.calculatePayment(babySitterTest));
	}
}
