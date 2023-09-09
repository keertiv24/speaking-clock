
package com.Speakingclock.Speaking.clock.testClock;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.Speakingclock.Speaking.clock.exception.GlobalExceptionHandler;
import com.Speakingclock.Speaking.clock.serviceImpl.SpeakingclockService;
import com.Speakingclock.Speaking.clock.util.SpeakingClockConstants;


public class SpeakingClockTest {

	// @Autowired //private SpeakingclockService speakingclockServicetest;

	@Test
	public void whenEnteredLettersInsteadOfIntegers_thenShouldReturnException() {
		
		Exception exception = assertThrows(NumberFormatException.class, () -> {
			SpeakingclockService speakingclockService = new SpeakingclockService();
			speakingclockService.formatTime("12:aa");
	    });

		String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(SpeakingClockConstants.ERROR_MESSAGE));
		
		
	}

	@Test
	public void whenEnteredSemicolonInsteadOfColon_thenShouldReturnException() {
		Exception exception = assertThrows(NumberFormatException.class, () -> {
			SpeakingclockService speakingclockService = new SpeakingclockService();
			speakingclockService.formatTime("12;13");
		});
	}
		

	@Test
	public void whenEnteredMidday_thenShouldReturnItsMidday() throws Exception {
		SpeakingclockService speakingclockService = new SpeakingclockService();
		assertEquals("It's Midday", speakingclockService.formatTime("12:00"));
	}

	@Test
	public void whenEnteredMidnight_thenShouldReturnItsMidnight() throws Exception {
		SpeakingclockService speakingclockService = new SpeakingclockService();
		assertEquals("It's Midnight", speakingclockService.formatTime("24:00"));
	}

	@Test
	public void whenEnteredTwelveFifty_thenShouldReturnItsTwelveFifty() throws Exception {
		SpeakingclockService speakingclockService = new SpeakingclockService();
		assertEquals("It's twelve fifty ", speakingclockService.formatTime("12:50"));
	}

	@Test
	public void whenEnteredOne_thenShouldReturnItsOne() throws Exception {
		SpeakingclockService speakingclockService = new SpeakingclockService();

		assertEquals("It's one ", speakingclockService.formatTime("13:00"));
	}

	@Test
	public void whenEnteredTwoOhSix_thenShouldReturnItsTwoOhSix() throws Exception {
		SpeakingclockService speakingclockService = new SpeakingclockService();

		assertEquals("It's two oh six ", speakingclockService.formatTime("14:06"));
	}

	@Test
	public void whenEnteredFiveFifteen_thenShouldReturnItsFiveFifteen() throws Exception {
		SpeakingclockService speakingclockService = new SpeakingclockService();

		assertEquals("It's five fifteen ", speakingclockService.formatTime("17:15"));
	}

}
