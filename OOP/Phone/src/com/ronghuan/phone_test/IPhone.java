package com.ronghuan.phone_test;

public class IPhone extends Phone implements Ringable{
	// CONSTRUCTOR
	public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}

	
	// ABSTRACT METHOD
	@Override
	public void displayInfo() {
		System.out.println("iPhone " + getVersionNumber() + " from " + getCarrier());
	}

	// INTERFACE METHODS
	@Override
	public String ring() {
		return "iPhone " + getVersionNumber() + " says " + getRingTone();
	}


	@Override
	public String unlock() {
		return "Unlocking via facial recognition";
	}	
}
