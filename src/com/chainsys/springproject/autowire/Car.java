package com.chainsys.springproject.autowire;

import javax.annotation.Resource;     // @Resources not working bzc its deprecated

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;     
import org.springframework.stereotype.Component;

public  class Car {
	@Autowired
	private Engine petrolEngine;
	//@Autowired(required = false)
	@Resource
	private Wheel alloy;

	/*
	 * public Engine getPetrolEngine() { return petrolEngine; }
	 * 
	 * public void setPetrolEngine(Engine petrolEngine) { this.petrolEngine =
	 * petrolEngine; }
	 * 
	 * public Wheel getAlloy() { return alloy; }
	 * 
	 * public void setAlloy(Wheel alloy) { this.alloy = alloy; }
	 */

	public Car() {
		System.out.println("1 Car Object created " + hashCode());
	}

	public void start() {
		petrolEngine.start();
	}

	public void move() {
		alloy.rotate();
	}

	public void begin() {
		System.out.println("Start AnnotationLC");
	}

	public void stop() {
		System.out.println("Stoped AnnotationLC");
	}
}
@Component("SuvCar")
  class SuvCar extends Car {
	  public SuvCar() {
		  System.out.println("Suv Car Object Created");
	  }
	
}  @Component("SportsCar")
  class SportsCar extends Car {
	  public SportsCar() {
		  System.out.println("Suv Car Object Created");
	  }}