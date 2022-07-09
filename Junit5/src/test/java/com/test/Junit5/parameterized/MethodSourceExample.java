package com.test.Junit5.parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.test.Junit5.parameter.StringHelper;

public class MethodSourceExample {

	@ParameterizedTest
	@MethodSource("stringProvider")
	public void methodSourceTest(String a) {
		assertNotNull(a);
	}
	
	
	public static Stream<String> stringProvider() {
		return Stream.of("dog", "cat", "mouse");
	}
	
	@ParameterizedTest
	@MethodSource("argumentsProvider")
	public void methodSourceTestWithArguments(String input, String expected) {
		StringHelper stringHelper = new StringHelper();
		assertEquals(expected, stringHelper.reverse(input));
	}
	
	public static Stream<Arguments> argumentsProvider() {
		return Stream.of(
				Arguments.arguments("car", "rac"),
				Arguments.arguments("mom", "mom")
		);
	}
	
	@ParameterizedTest
	@MethodSource("sum")
	public void methodSourceTest(int a, int b, int expected) {
		assertEquals(expected,add(a,b));
	}
	
	
	private Integer add(int a, int b) {
		return a+b;
	}

	public static Stream<Arguments> sum() {
		return Stream.of(
				Arguments.arguments(1,2,3),
				Arguments.arguments(3,4,7)
		);
	}
	
	
}
