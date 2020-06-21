package com.example.agehrmann.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.agehrmann.MyUtilClass;
import com.example.agehrmann.entities.City;
import com.example.agehrmann.entities.Delivery;
import com.example.agehrmann.repository.CustomDeliveryRepository;
import com.example.agehrmann.repository.ICityRepository;
import com.example.agehrmann.repository.IDeliveryRepository;

@RestController
public class DeliveryController {

	public static final String PARA_START = "start";
	public static final String PARA_END = "end";
	public static final String PARA_WEIGHT = "weight";

	@Autowired
	private CustomDeliveryRepository customDeliveryRepository;

	@Autowired
	private IDeliveryRepository deliveryRepository;

	@Autowired
	private ICityRepository cityRepository;

	/**
	 * 
	 * 
	 * @return
	 */
	@GetMapping("/delivery")
	public List<Delivery> findAllDeliveriesInNextDay() {
		return customDeliveryRepository.findDeliveriesOfNextWeek();
	}

	/**
	 * Creates a delivery with start and end city and a weight. the delivery is
	 * saved in DB.
	 * 
	 * @return message if the delivery was created
	 */
	@PostMapping("/delivery")
	public String putDelivery(@RequestParam(value = PARA_START) String startCity,
			@RequestParam(value = PARA_END) String endCity, @RequestParam(value = PARA_WEIGHT) Double weight) {

		City foundStartCity = cityRepository.findByName(startCity);
		City foundEndCity = cityRepository.findByName(endCity);

		if (foundStartCity != null && foundEndCity != null && weight != null) {
			Delivery delivery = MyUtilClass.createDelivery(foundStartCity, foundEndCity, weight);
			deliveryRepository.save(delivery);

			DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - hh:mm");
			String dateString = dateFormat.format(delivery.getDeliveryDate());
			return String.format("Die Bestellung wurde erstellt und wird an folgendem Datum geliefert: %s", dateString);
		}

		return "Der Aufruf beinhaltet unkorrekte Parameter";
	}

}
