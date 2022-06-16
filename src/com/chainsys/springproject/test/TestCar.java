package com.chainsys.springproject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.springproject.beans.Car;
import com.chainsys.springproject.beans.Engine;
import com.chainsys.springproject.beans.Lunch;
import com.chainsys.springproject.beans.Wheel;

public class TestCar {
  public static void firstTest() {
	  ApplicationContext ac = new ClassPathXmlApplicationContext("car.xml");
	//  Car c = ac.getBean(Car.class);
	  Car car = ac.getBean("jaguvar", Car.class);
	   System.out.println("kowsi is a good girl");

	  car.start();
	  car.move();
  }
}
