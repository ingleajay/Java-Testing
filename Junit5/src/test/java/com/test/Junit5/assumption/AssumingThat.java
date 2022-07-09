package com.test.Junit5.assumption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;

public class AssumingThat {
	
	// write in VM arg -> right click - run config - vm arg = 
	// - en 
	// -DENV=DEV

	@Test
	public void assumingThatWithBooleanCondition() {
		assumingThat("DEV".equals(System.getProperty("ENV")), () -> {
			System.out.println("Dev environment !!!");
			assertEquals(5, 3 + 2);
		});
		// below code gets executed in every environment
		System.out.println("Executed in every environment !!!");
		assertEquals(3, 2 + 1);
	}
	
	@Test
	public void assumingThatWithBooleanSupplier() {
		assumingThat(() -> "DEV".equals(System.getProperty("ENV")), () -> {
			System.out.println("Dev environment !!!");
			assertEquals(5, 3 + 2);
		});
		// below code gets executed in every environment
		System.out.println("Executed in every environment !!!");
		assertEquals(3, 2 + 1);
	}
}
