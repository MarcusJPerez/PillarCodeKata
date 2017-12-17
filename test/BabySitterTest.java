
/*
 * @author Marcus Perez
 */

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BabySitterTest {

	BabySitter babySitterTest;

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

}
