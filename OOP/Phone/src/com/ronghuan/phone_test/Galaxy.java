package com.ronghuan.phone_test;

public class Galaxy extends Phone implements Ringable{
	// CONSTRUCTOR
	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}

	// ATTRIBUTE METHOD
	@Override
	public void displayInfo() {
		System.out.println("Galaxy " + getVersionNumber() + " from " + getCarrier());
	}

	// INTERFACE METHODS
	@Override
	public String ring() {
		return "Galaxy " + getVersionNumber() + " says " + getRingTone();
	}

	@Override
	public String unlock() {
		return "Unlocking via finger print";
	}

}
