package com.test.Junit5.dyamictest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import com.test.Junit5.parameter.StringHelper;

public class SimpleDynamic {

	StringHelper str = new StringHelper();
	
	@TestFactory
	public DynamicTest testReverse() {
		return dynamicTest("Dynamic test  for reverse method",()->{
			assertEquals("god", str.reverse("dog"));
		});
	}
}
