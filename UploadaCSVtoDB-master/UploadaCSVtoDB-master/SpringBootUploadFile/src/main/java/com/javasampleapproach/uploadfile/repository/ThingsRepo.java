package com.javasampleapproach.uploadfile.repository;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.uploadfile.model.ThingsD;

public interface ThingsRepo extends CrudRepository<ThingsD,String> {

	
}
