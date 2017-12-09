package com.babysitter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BabySitterTest {

	@Test
	public void babySitterStartTimeReturns17() {
		BabySitter  babySitter = new BabySitter();
	
		assertEquals(17, babySitter.startTime() );
		
	
			}



}
