package com.example.agehrmann.entities;

import org.springframework.data.annotation.Id;

public class City {

	@Id
	private String id;

	private String name;
	private double x;
	private double y;

	public City() {
	}

	public City(String name, Double x, Double y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("City[id=%s, x='%s', y='%s']", id, x, y);
	}

}
