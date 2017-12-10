package com.babysitter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BabySitterTest {

	String InvalidString = "I can only babysit between 5pm and 4am.";

	@Test
	public void babySitterStartTimeReturns17() {
		BabySitter babySitter = new BabySitter();

		assertEquals(1700, babySitter.getStartTime());
		assertFalse(InvalidString.equals(babySitter.getStartOrEndTimeErrorMessage()));
	}

	@Test

	public void babySitterStartTimeReturnsNewStartTime() {
		BabySitter babySitter = new BabySitter();
		babySitter.setStartTime(1800);

		assertEquals(1800, babySitter.getStartTime());
		assertFalse(InvalidString.equals(babySitter.getStartOrEndTimeErrorMessage()));

	}

	@Test

	public void babySitterLatestEndTime() {
		BabySitter babySitter = new BabySitter();
		assertEquals(400, babySitter.getEndTime());
		assertFalse(InvalidString.equals(babySitter.getStartOrEndTimeErrorMessage()));

	}

	@Test
	public void babySitterEndTimeReturnsNewStartAndEndTime() {
		BabySitter babySitter = new BabySitter();
		babySitter.setStartTime(1800);
		babySitter.setEndTime(300);
		assertEquals(1800, babySitter.getStartTime());
		assertEquals(300, babySitter.getEndTime());
		assertFalse(InvalidString.equals(babySitter.getStartOrEndTimeErrorMessage()));

	}

	@Test()
	public void babySitterInvalidStartTimeWithMessage() {
		BabySitter babySitter = new BabySitter();
		babySitter.setStartTime(1600);
		babySitter.setEndTime(400);
		String InvalidString = "I can only babysit between 5pm and 4am.";
		assertTrue(InvalidString.equals(babySitter.getStartOrEndTimeErrorMessage()));

	}

	@Test()
	public void PaymentFromStartToBedTime12$() {
		BabySitter babySitter = new BabySitter();
		babySitter.setStartTime(1700);
		babySitter.setBedTime(2300);
		babySitter.setEndTime(2300);

		assertEquals(72, babySitter.calculatePayment());
		assertFalse(InvalidString.equals(babySitter.getStartOrEndTimeErrorMessage()));

	}

	@Test()
	public void PaymentFromStartMidnightWithBedTime() {
		BabySitter babySitter = new BabySitter();
		babySitter.setStartTime(1700);
		babySitter.setBedTime(2300);
		babySitter.setEndTime(2400);
		assertEquals(80, babySitter.calculatePayment());
		assertFalse(InvalidString.equals(babySitter.getStartOrEndTimeErrorMessage()));
	}

	@Test()
	public void PaymentFromStartToEndWithBedTime() {
		BabySitter babySitter = new BabySitter();
		babySitter.setStartTime(1800);
		babySitter.setBedTime(2000);
		babySitter.setEndTime(300);
		assertEquals(104, babySitter.calculatePayment());
		assertFalse(InvalidString.equals(babySitter.getStartOrEndTimeErrorMessage()));
	}

	@Test()
	public void PaymentFromStartToEndWithBedTimeNoPartialHours() {
		BabySitter babySitter = new BabySitter();
		babySitter.setStartTime(1850);
		babySitter.setBedTime(2050);
		babySitter.setEndTime(350);
		assertEquals(104, babySitter.calculatePayment());
		assertFalse(InvalidString.equals(babySitter.getStartOrEndTimeErrorMessage()));
	}
}