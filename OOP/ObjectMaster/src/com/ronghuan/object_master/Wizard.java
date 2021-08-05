package com.ronghuan.object_master;

public class Wizard extends Human{
	// ATTRIBUTES
	public Wizard() {
		this.health = 50;
		this.intelligence = 8;
	}
	
	
	// METHODS
	public void heal(Human target) {
		target.health += this.intelligence;
	}
	
	public void fireball(Human target) {
		target.health -= 3 * this.intelligence;
	}

}
