package com.example.agehrmann.repository;

import java.util.List;

import com.example.agehrmann.entities.Delivery;

public interface ICustomDeliveryRepository {

	/**
	 * finds all deliveries between now and now+24hours
	 * 
	 * @return List of deliveries. Returns empty list f nothing was found
	 */
	public List<Delivery> findDeliveriesOfNextWeek();

}
