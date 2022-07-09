package com.test.Junit5.asserts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAnnotation {
	
	// assertequals method - check expected and actual value 

	@Test
	void test1() {
		assertEquals(2,2);
	}
	
	@Test
	void test2() {
		assertEquals(3,2);
	}

}
