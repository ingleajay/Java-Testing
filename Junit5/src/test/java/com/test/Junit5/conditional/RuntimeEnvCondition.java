package com.test.Junit5.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class RuntimeEnvCondition {

	@Test
	@DisabledOnJre(value=JRE.JAVA_8)
	public void disabledOnJava8() {
		System.out.println("disabled on jre 8");
	}
	
	@Test
	@EnabledOnJre(value=JRE.JAVA_17)
	public void enabledOnJava17() {
		System.out.println("enabled on jre 17");
	}
	
}
