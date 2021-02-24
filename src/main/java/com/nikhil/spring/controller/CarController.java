package com.nikhil.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

import com.nikhil.spring.model.Car;
import com.nikhil.spring.rep.CarRepository;

//@Controller
@RestController
public class CarController {
	@Autowired
	CarRepository repository;
	
	/*
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
		
	}
	*/
	
	@PostMapping("/addCar")  
	//@ResponseBody
	public Car addCar(Car car) {
		repository.save(car);
		return car;
	}
	
	
	@GetMapping("/allCars")
	//@ResponseBody
	public List<Car> getCars() {
		return repository.findAll();
	}
	
	/*
	@RequestMapping("/getCar")
	public ModelAndView getCar(@RequestParam int cid) {
		ModelAndView mvc = new ModelAndView("showCar.jsp");
		Optional<Car> car = repository.findById(cid);
		mvc.addObject(car);
		return mvc;
		
	}
	*/
	
	
	@RequestMapping("/getCars")
	public List<Car> getCar() {
		List<Car> car = repository.findAll();  
		return car;
		
	}
	
	@RequestMapping("/getCarOne/{cid}")
	//@ResponseBody
	public Optional<Car> getCarOne(@PathVariable("cid") int cid) {
		
	
		return repository.findById(cid);
		
	}
	
	@PostMapping("/postCar")  
	public Car postCar(@RequestBody Car car) {
		
		repository.save(car);
		return car;
		
	}
	
	@DeleteMapping("/deleteCar/{cid}")
	public String deleteCar(@PathVariable int cid) {
		
		Car car = repository.getOne(cid);
		repository.delete(car);
		return "deleted"; //cos the entity is already deleted and can't be displayed there after since it doesn't exist after that line is executed technically.
	
	}
	
	@PutMapping("/updateCar")  //shortcut ctrl+shift+o to import.
	public Car createOrUpdateCar(@RequestBody Car car) {
		
		repository.save(car);
		return car;
		
	}
	
	
	
	//technically post,get,request all these mappings can be used interchangeably. it doesn't really matter.
	//and controller(need response body for methods) is what works with chrome not rest controller.
	//mvc is the concept but the actual class doesn't have to be used, it could be simpler.
	//requestparam is for static values(meaning the values typed are not automatically interpreted without specifying the field) in web forms etc. path variable is for restful services like where dynamic value changes in url can and will happen. it's to simplify the url. don't have to specify what the field is that we are talking about again in the url. they both do the same thing, only slightly differently in their appearance of urls and paths.
}	//but if you do want to have same url for all, then it makes sense to have delete, post etc. as distinguishable mappings.
