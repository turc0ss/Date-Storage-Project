package com.tmattila.utils;

public enum DateStringUtils {

	HEADER_TEXT("Welcome to date storage application. TESTING JIRA FISHEYE APPLICATION LINK TEST 1"),
	BUTTON_TEXT("Click to save the time of button press to database"),
	DATE_TEXT("Date and time of button press: ");
	
	private final String string;
	
	private DateStringUtils(String string) {
		this.string = string;
	}
	
	public String getString() {
		return string;
	}
}
