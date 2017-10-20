package com.tmattila.service;

import com.tmattila.model.Dates;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmattila.repository.DateRepository;
import com.tmattila.utils.LoggerMessages;

@Service
public class DateServiceImpl implements DateService {

	final static Logger logger = Logger.getLogger(DateServiceImpl.class);
	
	@Autowired
	DateRepository dateRepository;
	
	@Override
	public void saveDateToRepository(Dates dateDAO) {
		
		logger.info(LoggerMessages.INSIDE_DATESERVICEIMPL.getString());
		Dates dates = new Dates();
		dates.setTitle("DATE");
		dates.setDateForm(dateDAO.getDateForm());
		System.out.println("date: " + dates.toString());
		
		logger.info(LoggerMessages.DATE_SAVED_TO_DB.getString() + dates.getDateForm());
		
		dateRepository.save(dates);
	}
}
