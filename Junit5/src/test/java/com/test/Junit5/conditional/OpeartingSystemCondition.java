package com.test.Junit5.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class OpeartingSystemCondition {

	@Test
	@EnabledOnOs(value=OS.WINDOWS)
	public void enableOnWindows() {
		System.out.println("Only excute on windows");
	}
	
	@Test
	@EnabledOnOs(value=OS.MAC)
	public void enableOnMac() {
		System.out.println("Only excute on mac");
	}
	
	@Test
	@EnabledOnOs(value= {OS.MAC,OS.WINDOWS})
	public void enableOnBoth() {
		System.out.println("Only excute on mac");
	}
	
	@Test
	@DisabledOnOs(value=OS.WINDOWS)
	public void disableOnWindow() {
		System.out.println("Only excute on mac");
	}
	
}
