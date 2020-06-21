package com.example.agehrmann;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.agehrmann.entities.City;
import com.example.agehrmann.repository.ICityRepository;

@SpringBootApplication
public class AgehrmannApplication implements CommandLineRunner {

	@Autowired
	private ICityRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AgehrmannApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		// save a couple of cities
		repository.save(new City("Leipzig", 80., 50.));
		repository.save(new City("Berlin", 60., 30.));
		repository.save(new City("München", 40., 80.));
		repository.save(new City("Hamburg", 30., 20.));
		repository.save(new City("Dortmund", 10., 40.));
		repository.save(new City("Frankfurt", 20., 40.));

	}

}
