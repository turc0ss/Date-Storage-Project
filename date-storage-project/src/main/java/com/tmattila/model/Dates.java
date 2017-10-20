package com.tmattila.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/***
 * 
 * @author tapsa
 *
 */
@Document(collection = "dates")
public class Dates {

	/***
	 * String id, datebase field value id
	 */
	@Id
	private String id;

	/***
	 * String title, database field value Title
	 */
	@Field(value = "Title:")
	private String title;

	/***
	 * variable Date for setting new date time
	 */
	private Date date;

	/***
	 * String date, database field value Date
	 */
	@Field(value = "Date:")
	private String dateForm;

	/***
	 * Constructor Dates
	 */
	public Dates() {

	}

	/***
	 * getter for title
	 * @return title
	 */
	public final String getTitle() {
		return title;
	}

	/***
	 * setter for title
	 * @param title ***is the title parameter***
	 * 
	 */
	public final void setTitle(final String title) {
		this.title = title;
	}

	/***
	 * getter for date
	 * @return date
	 */
	public final Date getDate() {
		return this.date;
	}

	/***
	 * setter for date
	 * @param date ***is the date parameter***
	 */
	public final void setDate(final Date date) {
		this.date = new Date();
	}

	/***
	 * getter for dateform
	 * @return dateform
	 */
	public final String getDateForm() {
		return this.dateForm;
	}

	/***
	 * setter for dateform, will perform modifications to the new date
	 */
	public final void setDateForm(final String dateForm) {
		Date date = new Date();
		DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.dateForm = dateF.format(date);
	}

	/***
	 * toString method for showing the data
	 */
	@Override
	public final String toString() {
		return this.date + " --- " + this.dateForm;
	}
}
