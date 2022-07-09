package com.test.Junit5.parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.test.Junit5.parameter.StringHelper;

public class CSVFIleSourceExample {

	@ParameterizedTest
	@CsvFileSource(resources = "/reverse.csv")
	public void csvFileSourceDemoTest(String input, String expect) {
		StringHelper stringHelper = new StringHelper();
		assertEquals(expect, stringHelper.reverse(input));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/reverse.csv", numLinesToSkip = 1)
	public void csvFileSourceDemoWithNumberOfLinesToSkipTest(String input, String expect) {
		StringHelper stringHelper = new StringHelper();
		assertEquals(expect, stringHelper.reverse(input));
	}

}
