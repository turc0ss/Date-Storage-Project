package com.tmattila.service;

import com.tmattila.model.Dates;

/***
 * 
 * @author tapsa
 *
 */
public interface DateService {

	/***
	 * 
	 * @param dateDAO 
	 */
	void saveDateToRepository(final Dates dateDAO);
}
