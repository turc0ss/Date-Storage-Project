package com.tmattila.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tmattila.model.Dates;

@Repository
public interface DateRepository extends MongoRepository<Dates, Date>{

}
