package com.ronghuan.object_master;

public class Ninja extends Human{
	// CONSTRUCTOR: inherits other attributes from parent class, only change stealth value
	public Ninja() {
		this.stealth = 10;
	}
	
	
	// METHODS
	public void steal(Human target) {
		target.health -= this.stealth;
		this.health += this.stealth;
	}
	
	public void run() {
		this.health -= 10;
	}


}
