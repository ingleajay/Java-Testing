package com.testdoubles.dummy;

public class DummyEmailService implements EmailService{

	@Override
	public void sendEmail(String msg) {
		throw new AssertionError("Method not implement");
	}
}
