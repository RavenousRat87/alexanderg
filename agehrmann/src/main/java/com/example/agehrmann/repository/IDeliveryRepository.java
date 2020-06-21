package com.example.agehrmann.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.agehrmann.entities.Delivery;

public interface IDeliveryRepository extends MongoRepository<Delivery, String> {
	
}