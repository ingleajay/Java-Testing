package com.test.Junit5.dyamictest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import com.test.Junit5.parameter.StringHelper;

public class DynamicWithCollection {

	StringHelper str = new StringHelper();

	@TestFactory
	@DisplayName("Test-cases")
	public Collection<DynamicTest> dynamicTestCollection(){
		
		List<String> linput = createInputList();
		List<String> loutput = createOutputList();
		
		Collection<DynamicTest> dynamicTests =  new ArrayList<DynamicTest>();
		for(int i=0; i<linput.size();i++) {
			String input = linput.get(i);
			String output = loutput.get(i);
			
			DynamicTest dynamicTest = dynamicTest("Dyanmic - " + input,()->{
				assertEquals(output, str.reverse(input));
			});
			
			dynamicTests.add(dynamicTest);
		}
		return dynamicTests;
		
	}

	private List<String> createOutputList() {
		return Arrays.asList("yaja","god");
	}

	private List<String> createInputList() {
		return Arrays.asList("ajay","dog");
	}
	
}
