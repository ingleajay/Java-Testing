package com.test.Junit5.repeatedtest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTestDisplayName {

	@RepeatedTest(value = 5, name = "{displayName} - {currentRepetition} / {totalRepetitions}")
	@DisplayName("Simple Repeated Test")
	public void simpleRepeatedTest() {
		assertTrue(0 < 5);
	}
	
	@RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
	@DisplayName("Test")
	public void simpleRepeatedTestWithLongDisplayName() {
		assertTrue(0 < 5);
	}
	
	@RepeatedTest(value = 5, name = RepeatedTest.SHORT_DISPLAY_NAME)
	@DisplayName("Check")
	public void simpleRepeatedTestWithShortDisplayName() {
		assertTrue(0 < 5);
	}
}
