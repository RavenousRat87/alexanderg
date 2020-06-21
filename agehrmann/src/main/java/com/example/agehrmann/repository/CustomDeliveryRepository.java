package com.example.agehrmann.repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.agehrmann.MyUtilClass;
import com.example.agehrmann.entities.Delivery;

@Repository
public class CustomDeliveryRepository implements ICustomDeliveryRepository {

	@Autowired
	IDeliveryRepository repository;

	@Override
	public List<Delivery> findDeliveriesOfNextWeek() {

		return repository.findAll().stream().filter(d -> d.getDeliveryDate().after(new Date()))
				.filter(d -> d.getDeliveryDate().before(MyUtilClass.addHours(new Date(), 24)))
				.collect(Collectors.toList());

	}

}
