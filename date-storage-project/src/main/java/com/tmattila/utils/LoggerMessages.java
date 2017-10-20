package com.tmattila.utils;

public enum LoggerMessages {

	DATE_SAVED("Date saved."),
	ERROR_SAVING_DATE("Error in saving date."),
	SAVE_SUCCESSFUL("Save successful"),
	INSIDE_DATESERVICEIMPL("Inside DateServiceImpl, saveDateToRepository"),
	DATE_SAVED_TO_DB("Date saved to db: ");
	
	private final String string;
	
	private LoggerMessages(String string) {
		this.string = string;
	}
	
	public String getString() {
		return string;
	}
}
