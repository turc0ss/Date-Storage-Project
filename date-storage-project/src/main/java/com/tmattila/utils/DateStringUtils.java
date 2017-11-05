package com.tmattila.utils;

/***
 * 
 * @author tapsa
 *
 */
public enum DateStringUtils {

	HEADER_TEXT("Welcome to date storage application TEST GRTP-10 layout change sharded db"),
	BUTTON_TEXT("Click to save the time of button press to database"),
	DATE_TEXT("Date and time of button press: ");
	
	/***
	 * Set the String variable to use.
	 */
	private final String string;
	
	/***
	 * constructor for DateStringUtils.
	 * @param string
	 */
	private DateStringUtils(final String string) {
		this.string = string;
	}
	
	/***
	 * 
	 * @return string
	 */
	public String getString() {
		return string;
	}
}
