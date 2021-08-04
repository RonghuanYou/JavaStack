package com.ronghuan.test;

public class Mammal {
	// ATTRIBUTES
	protected int energyLevel = 100;
	protected int batEnergyLevel = 300;

	
	// CONSTRUCTOR
	public Mammal() {
		super();
		this.energyLevel = energyLevel;
		this.batEnergyLevel = batEnergyLevel;
	}
	
	// GETTERS/SETTERS
	
	public int getEnergyLevel() {
		return energyLevel;
	}
	
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int getBatEnergyLevel() {
		return batEnergyLevel;
	}
	
	public void setBatEnergyLevel(int batEnergyLevel) {
		this.batEnergyLevel = batEnergyLevel;
	}
	
	// OTHER METHODS
	public int displayEnergy() {
		System.out.println(this.energyLevel);
		return this.energyLevel;
	}
	

	public int displayBatEnergy() {
		System.out.println(this.batEnergyLevel);
		return this.batEnergyLevel;
	}
	
}
