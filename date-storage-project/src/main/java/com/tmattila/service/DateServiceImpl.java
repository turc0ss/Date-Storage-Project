package com.tmattila.service;

import com.tmattila.model.Dates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmattila.repository.DateRepository;

@Service
public class DateServiceImpl implements DateService {

	@Autowired
	DateRepository dateRepository;
	
	@Override
	public void saveDateToRepository(Dates dateDAO) {
		
		Dates dates = new Dates();
		dates.setTitle("DATE");
		dates.setDateForm(dateDAO.getDateForm());
		System.out.println("date: " + dates.toString());
		
		dateRepository.save(dates);
	}
}
