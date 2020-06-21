package com.example.agehrmann;

import java.util.Calendar;
import java.util.Date;

import com.example.agehrmann.entities.City;
import com.example.agehrmann.entities.Delivery;

public class MyUtilClass {

	private final static double COST_FACTOR = 2.0;

	/**
	 * calculates the distance between 2 cities
	 * 
	 */
	public static double calcDistance(City startCity, City endCity) {
		return Math.sqrt(
				Math.pow((startCity.getX() - endCity.getX()), 2) + Math.pow((startCity.getY() - endCity.getY()), 2));
	}

	/**
	 * calculates cost of one delivery from start to end with the given weight
	 */
	public static Delivery createDelivery(City startCity, City endCity, Double weight) {
		Delivery resultDelivery = null;
		if (startCity != null && endCity != null && weight != null) {
			resultDelivery = new Delivery(startCity, endCity, weight);
			double distance = MyUtilClass.calcDistance(startCity, endCity);
			resultDelivery.setDistance(distance);
			resultDelivery.setCost(distance * COST_FACTOR);
			// Delivery is always 5 hours after creation
			resultDelivery.setDeliveryDate(addHours(new Date(), 5));
		}

		return resultDelivery;
	}

	/**
	 * add hours to the given date using Calendar
	 * 
	 * @return new date where the hours are added
	 */
	public static Date addHours(Date date, int hoursToAdd) {
		Date result = null;
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.HOUR_OF_DAY, hoursToAdd);
			result = cal.getTime();
		}
		return result;
	}
}
