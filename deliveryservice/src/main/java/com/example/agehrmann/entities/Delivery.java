package com.example.agehrmann.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Delivery {

	@Id
	private String id;

	private City startCity;
	private City endCity;
	private Double distance;
	private Double weight;
	private Double cost;
	private Date deliveryDate;

	public Delivery(City startCity, City endCity, Double weight) {
		super();
		this.startCity = startCity;
		this.endCity = endCity;
		this.weight = weight;
	}

	public City getStartCity() {
		return startCity;
	}

	public void setStartCity(City startCity) {
		this.startCity = startCity;
	}

	public City getEndCity() {
		return endCity;
	}

	public void setEndCity(City endCity) {
		this.endCity = endCity;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getId() {
		return id;
	}

}
