package com.tmattila.service;

import com.tmattila.model.Dates;

/***
 * 
 * @author tapsa
 *
 */
public interface DateService {
	 void saveDateToRepository(final Dates dateDAO);
}
