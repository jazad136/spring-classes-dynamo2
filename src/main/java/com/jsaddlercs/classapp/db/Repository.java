package com.jsaddlercs.classapp.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jsaddlercs.classapp.model.ClassesModel;

public interface Repository extends MongoRepository<ClassesModel, Long>{
	
}
