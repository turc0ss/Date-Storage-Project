package com.tmattila.service;

import com.tmattila.model.Dates;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmattila.repository.DateRepository;

@Service
public class DateServiceImpl implements DateService {

	final static Logger logger = Logger.getLogger(DateServiceImpl.class);
	
	@Autowired
	DateRepository dateRepository;
	
	@Override
	public void saveDateToRepository(Dates dateDAO) {
		
		Dates dates = new Dates();
		dates.setTitle("DATE");
		dates.setDateForm(dateDAO.getDateForm());
		System.out.println("date: " + dates.toString());
		
		logger.info("Date saved to db: " + dateDAO.getDateForm());
		
		dateRepository.save(dates);
	}
}
