package test;

/*
 * @author Marcus Perez
 */

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.BabySitter;

public class BabySitterTest {

	BabySitter babySitterTest;
	String InvalidString = "I can only babysit between 5pm and 4am.";

	@Before
	public void beforeEach() {
		babySitterTest = new BabySitter();
	}

	@Test
	public void itCanReturnAGivenStartTime() {
		babySitterTest.setStartTime(1700);
		assertEquals(1700, babySitterTest.getStartTime());
	}

	@Test
	public void itCanReturnAGivenBedTime() {
		babySitterTest.setBedTime(2200);
		assertEquals(2200, babySitterTest.getBedTime());
	}

	@Test
	public void itCanReturnAGivenEndTime() {
		babySitterTest.setEndTime(400);
		assertEquals(400, babySitterTest.getEndTime());
	}

	@Test()
	public void itCanDetermineThatAnInvalidStartTimeRerturnsTheInvalidMessage() {
		babySitterTest.setStartTime(1600);
		babySitterTest.setEndTime(400);
		assertEquals(true,
				InvalidString.equals(babySitterTest.determineIfStartAndEndTimesAreBothValid()));
	}

	@Test()
	public void itCanDetermineThatAnInvalidEndTimeRerturnsTheInvalidMessage() {
		babySitterTest.setStartTime(1700);
		babySitterTest.setEndTime(500);
		assertEquals(true,
				InvalidString.equals(babySitterTest.determineIfStartAndEndTimesAreBothValid()));
	}

	@Test()
	public void itCanDetermineThatAVaildStartTimeDoesNotReturnTheInvalidTimeMessage() {
		babySitterTest.setStartTime(1700);
		assertEquals(false,
				InvalidString.equals(babySitterTest.determineIfStartAndEndTimesAreBothValid()));
	}
	@Test()
	public void itCanDetermineThatAValidEndTimeDoesNotReturnTheInvalidTimeMessage() {
		babySitterTest.setEndTime(400);
		assertEquals(false,
				InvalidString.equals(babySitterTest.determineIfStartAndEndTimesAreBothValid()));
	}

}
