package com.babysitter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class BabySitterTest {

	@Test
	public void babySitterStartTimeReturns17() {
		BabySitter babySitter = new BabySitter();

		assertEquals(17, babySitter.getStartTime());
	}

	@Test

	public void babySitterStartTimeReturnsNewStartTime() {
		BabySitter babySitter = new BabySitter(18);

		assertEquals(18, babySitter.getStartTime());

	}

	@Test

	public void babySitterLatestEndTime() {
		BabySitter babySitter = new BabySitter();
		assertEquals(4, babySitter.getEndTime());

	}
	
	@Test

	public void babySitterEndTimeReturnsNewEndTime() {
		BabySitter babySitter = new BabySitter(18 , 3);
		assertEquals(18, babySitter.getStartTime());
		assertEquals(3, babySitter.getEndTime());

	}
	
}
