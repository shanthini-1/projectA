package com.chainsys.springproject.autowire;

public class Engine {
	
public void start() {
	
	System.out.println("Engine start");
	
}
public Engine() {
	System.out.println("Engine object is created"+hashCode());
}
}
