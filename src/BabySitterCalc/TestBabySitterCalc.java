/*
 * 
 * @author Marcus Perez
 * 
 */

package BabySitterCalc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestBabySitterCalc {

		BabySitterCalc testBabySitterCalc;
		String InvalidString = "I can only babysit between 5pm and 4am.";
		
		@Before
		public void beforeEach() {
			testBabySitterCalc = new BabySitterCalc();
		}

		@Test
		public void babySitterStartTimeReturns1700() {
			assertEquals(1700, testBabySitterCalc.getStartTime());
			
		}

		@Test

		public void babySitterStartTimeReturnsNewStartTime() {
			testBabySitterCalc.setStartTime(1800);

			assertEquals(1800, testBabySitterCalc.getStartTime());

		}

		@Test

		public void babySitterEndTimeReturnsNewEndTime() {
			assertEquals(400, testBabySitterCalc.getEndTime());
		}

		@Test
		public void babySitterStartTimeReturnsNewStart() {
			testBabySitterCalc.setStartTime(1800);
			testBabySitterCalc.setEndTime(300);
			assertEquals(1800, testBabySitterCalc.getStartTime());
		}
		
		public void babySitterEndTimeReturnsNewEnd() {
			testBabySitterCalc.setStartTime(1800);
			testBabySitterCalc.setEndTime(300);
			assertEquals(300, testBabySitterCalc.getEndTime());
		}

		@Test()
		public void invalidStartTimeReturnsInvalidMessage() {
			testBabySitterCalc.setStartTime(1600);
			testBabySitterCalc.setEndTime(400);
			assertEquals(true, InvalidString.equals(testBabySitterCalc.getStartOrEndTimeErrorMessage()));

		}
		@Test()
		public void validStartTimeDoesNotReturnInvalidMessage() {
			testBabySitterCalc.setStartTime(1700);
			testBabySitterCalc.setEndTime(400);
			assertEquals(false, InvalidString.equals(testBabySitterCalc.getStartOrEndTimeErrorMessage()));

		}

		@Test()
		public void returnPaymentForStartTimeToBedTime() {
			testBabySitterCalc.setStartTime(1700);
			testBabySitterCalc.setBedTime(2300);
			testBabySitterCalc.setEndTime(2300);

			assertEquals(72, testBabySitterCalc.calculatePayment());

		}

		@Test()
		public void returnPaymentForStartTimeToMidnightWithBedtime() {
			testBabySitterCalc.setStartTime(1700);
			testBabySitterCalc.setBedTime(2300);
			testBabySitterCalc.setEndTime(2400);
			assertEquals(80, testBabySitterCalc.calculatePayment());
		}

		@Test()
		public void returnPaymentForStartTimeToEndTimeWithBedtime() {
			testBabySitterCalc.setStartTime(1800);
			testBabySitterCalc.setBedTime(2000);
			testBabySitterCalc.setEndTime(300);
			assertEquals(104, testBabySitterCalc.calculatePayment());
		}

		@Test()
		public void returnPaymentForStartTimeToEndTimeWithBedtimeNoPartialHoursIncluded() {
			testBabySitterCalc.setStartTime(1850);
			testBabySitterCalc.setBedTime(2050);
			testBabySitterCalc.setEndTime(350);
			assertEquals(104, testBabySitterCalc.calculatePayment());
		}
}
