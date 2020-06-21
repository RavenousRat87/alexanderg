package com.example.agehrmann.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.agehrmann.entities.City;
import com.example.agehrmann.repository.ICityRepository;

@RestController
public class CityController {

	public static final String PARA_NAME = "name";
	public static final String PARA_X = "x";
	public static final String PARA_Y = "y";

	@Autowired
	private ICityRepository repository;

	/**
	 * Looks for the given city in Repository and returns a message if the city
	 * already exists
	 */
	@GetMapping("/city")
	public String findCity(@RequestParam(value = PARA_NAME) String cityName) {

		City foundCity = repository.findByName(cityName);
		if (foundCity != null) {
			return String.format("%s ist vorhanden und hat die Koordinaten (%s, %s)", foundCity.getName(),
					foundCity.getX(), foundCity.getY());
		}

		return String.format("%s ist noch nicht eingetragen.", cityName);
	}

	/**
	 * creates a city or updates if it already exists.
	 * 
	 * @param cityName name of the city
	 * @param x        x coordinate of the city
	 * @param y        y coordinate of the city
	 * @return message if the city was created/updated
	 */
	@PostMapping("/city")
	public String putCity(@RequestParam(value = PARA_NAME) String cityName, @RequestParam(value = PARA_X) String x,
			@RequestParam(value = PARA_Y) String y) {
		Double xDouble = null;
		Double yDouble = null;

		// check if input of coordinates is correct
		try {
			xDouble = Double.parseDouble(x);
			yDouble = Double.parseDouble(y);
			if (xDouble < 0 || yDouble < 0) {
				return "Koordinaten müssen positiv sein.";
			}
		} catch (Exception e) {
			return "Die Koordinaten sind nicht korrekt.";
		}

		City foundCity = repository.findByName(cityName);
		if (foundCity != null) {
			// update city
			foundCity.setX(xDouble);
			foundCity.setY(yDouble);

			repository.save(foundCity);
			return String.format("%s war bereits vorhanden und wurde aktualisiert", foundCity.getName());
		}

		// save city if not already in database
		repository.save(new City(cityName, xDouble, yDouble));
		return String.format("%s wurde gespeichert.", cityName);
	}

}
