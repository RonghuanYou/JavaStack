package com.ronghuan.test;

class Bat extends Mammal {	
	// METHODS
	public void fly() {
		if (getBatEnergyLevel() < 50) {
			System.out.println("Sorry, bat cannot fly since energy is lower than 50.");
		} else {
			System.out.println("snort..snort.., decreases energy by 50");
			int curEnergy = getBatEnergyLevel() - 50;
			setBatEnergyLevel(curEnergy);
			displayBatEnergy();
		}
	}
	
	public void eatHuman() {
		System.out.println("So- well, never mind, increase energy by 50");
		int curEnergy = getBatEnergyLevel() + 50;
		setBatEnergyLevel(curEnergy);
		displayBatEnergy();
	}
	
	public void attackTown() {
		if (getBatEnergyLevel() < 100) {
			System.out.println("Sorry, bat cannot attack town since its energy is lower than 100.");
		} else {
			System.out.println("boom...boom.., decreases energy by 100");
			int curEnergy = getBatEnergyLevel() - 100;
			setBatEnergyLevel(curEnergy);
			displayBatEnergy();
		}
	}
}
