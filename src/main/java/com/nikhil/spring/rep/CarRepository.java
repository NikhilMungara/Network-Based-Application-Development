package com.nikhil.spring.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.nikhil.spring.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
	

	List<Car> findByCmodel(String cmodel);
	

}
