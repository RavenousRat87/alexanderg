package com.example.agehrmann.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.agehrmann.MyUtilClass;
import com.example.agehrmann.entities.City;
import com.example.agehrmann.repository.ICityRepository;

@RestController
public class DistanceController {

	public static final String START_PARA = "start";
	public static final String END_PARA = "end";

	@Autowired
	private ICityRepository repository;

	/**
	 * Returns the distance between 2 cities. default start is Leipzig
	 * 
	 */
	@GetMapping("/distance")
	public String getDistance(@RequestParam(value = START_PARA, defaultValue = "Leipzig") String start,
			@RequestParam(value = END_PARA, defaultValue = "null") String end) {

		City startcity = repository.findByName(start);
		City endcity = repository.findByName(end);

		if (startcity == null || endcity == null) {
			return "Start- oder Endziel konnte nicht gefunden werden.";
		}

		Double distance = MyUtilClass.calcDistance(startcity, endcity);
		return String.format("Die Entfernung zwischen %s und %s beträgt %s km", start, end, distance);
	}

}
