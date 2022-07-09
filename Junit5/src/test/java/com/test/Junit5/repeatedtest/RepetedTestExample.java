package com.test.Junit5.repeatedtest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class RepetedTestExample {
	@BeforeAll
	public static void beforeAll() {
		System.out.println("@BeforeAll got executed !!!");
	}
	
	public  RepetedTestExample() {
		System.out.println("Constructor got executed !!!");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("@BeforeEach got executed !!!");
	}
	
	@RepeatedTest(5)
	public void simpleRepeatedTest() {
		assertTrue(0 < 5);
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("@AfterEach got executed !!!");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("@AfterAll got executed !!!");
	}
}
