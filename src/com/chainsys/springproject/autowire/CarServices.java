package com.chainsys.springproject.autowire;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;

public class CarServices {
    @Autowired
    @Qualifier("SportsCar")
	private Car car;
    public void start() {
    	car.start();
    }
}
