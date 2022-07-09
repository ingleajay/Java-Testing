package com.test.Junit5.dyamictest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;

public class DynamicContainers {

	private List<String> createOutputList() {
		return Arrays.asList("yaja","god");
	}
	
	@TestFactory
	public Stream<DynamicNode> dyamicTestWithdynamicContaners(){
		return createOutputList().stream().map(input->
		
	    dynamicContainer("Container for " + input,Stream.of(
	    		
	    		dynamicTest("Not null",()->assertNotNull(input)),
	    		dynamicContainer("Properties test : ", Stream.of(
	    				
	    	    		dynamicTest("length > 0", ()->assertTrue(input.length()>0)),
	    	    		dynamicTest("not empty", ()->assertFalse(input.isEmpty()))
	    		))
	    	))
	    		
	    );
	}
}
