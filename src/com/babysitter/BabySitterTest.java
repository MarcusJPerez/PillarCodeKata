package com.babysitter;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import  org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;







class BabySitterTest {

	@Test
	public void babySitterStartTimeReturns17() {
		BabySitter babySitter = new BabySitter();

		assertEquals(17, babySitter.getStartTime());
	}

	@Test

	public void babySitterStartTimeReturnsNewStartTime() {
		BabySitter babySitter = new BabySitter();
		babySitter.setStartTime(18);

		assertEquals(18, babySitter.getStartTime());

	}

	@Test

	public void babySitterLatestEndTime() {
		BabySitter babySitter = new BabySitter();
		assertEquals(4, babySitter.getEndTime());

	}
	
	@Test
	public void babySitterEndTimeReturnsNewStartAndEndTime() {
		BabySitter babySitter = new BabySitter(18 , 3);
		assertEquals(18, babySitter.getStartTime());
		assertEquals(3, babySitter.getEndTime());
		
	}
	@Test()
	public void babySitterInvalidStartTimeWithMessage() {
		BabySitter babySitter = new BabySitter(18,3);
		String InvalidString = "I can only babysit between 5pm and 4am.";
		equals(InvalidString.equals(babySitter.getStartOrEndTimeErrorMessage()));
		
	}
	
}
