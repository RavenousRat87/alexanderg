package com.example.agehrmann.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.agehrmann.entities.City;

public interface ICityRepository extends MongoRepository<City, String> {

	  public City findByName(String name);

	}