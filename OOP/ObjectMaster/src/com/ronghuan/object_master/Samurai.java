package com.ronghuan.object_master;

public class Samurai extends Human {
	// attribute
	private static int numSamurai = 0;
	
	// constructor
	public Samurai() {
		this.health = 200;
		numSamurai += 1;
	}
	
	// methods
	public void deathBlow(Human target) {
		target.health = 0;
		this.health /= 2;
	}
	
	public void meditate() {
		this.health = 200;
	}
	
	// class method
	public static int howMany() {
		return Samurai.numSamurai;
	}
	
	
}
