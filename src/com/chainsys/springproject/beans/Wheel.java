package com.chainsys.springproject.beans;

public class Wheel {
public void rotate() {
	System.out.println("Wheel is rotating");
}

public Wheel() {
	System.out.println("Wheel object is created" + hashCode());
}
}
