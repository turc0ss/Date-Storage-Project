package com.tmattila.utils;

/***
 * 
 * @author tapsa
 *
 */
public enum LoggerMessages {

	DATE_SAVED("Date saved."),
	ERROR_SAVING_DATE("Error in saving date."),
	SAVE_SUCCESSFUL("Save successful"),
	INSIDE_DATESERVICEIMPL("Inside DateServiceImpl, saveDateToRepository"),
	DATE_SAVED_TO_DB("Date saved to db: ");
	
	/***
	 * Set the String variable to use.
	 */
	private final String string;
	
	/***
	 * constructor for LoggerMessages.
	 * @param string
	 */
	private LoggerMessages(String string) {
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
