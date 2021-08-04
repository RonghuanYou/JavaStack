package com.ronghuan.test;

public class Gorilla extends Mammal {
	// METHODS:
	public void throwSomething() {
		System.out.println("Gorilla has thrown somthing and descreases its energy by 5.");
		int curEnergy = getEnergyLevel() - 5;
		setEnergyLevel(curEnergy);
		displayEnergy();
	}
	
	public void eatBananas() {
		System.out.println("Gorilla ate one banana and increases its energy by 10.");
		int curEnergy = getEnergyLevel() + 10;
		setEnergyLevel(curEnergy);
		displayEnergy();
	}

	public void climb() {
		System.out.println("Gorilla has climbed a tree and descreases its energy by 10.");
		int curEnergy = getEnergyLevel() - 10;
		setEnergyLevel(curEnergy);
		displayEnergy();
	}

}
