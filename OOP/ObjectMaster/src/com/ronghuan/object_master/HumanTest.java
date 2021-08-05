package com.ronghuan.object_master;

public class HumanTest {
	public static void main(String[] args) {
		// CREATE TWO OBJECTS 
		Human human1 = new Human();
		Human human2 = new Human();
		
		// HUMNA1 ATTACKS HUMAN2
		human1.attack(human2);
		
		// HUMAN2 REDUCE HEALTH BY 3
		System.out.println(human2.getHealth());

		
		// ---------- part 2------------
		Ninja ninja1 = new Ninja();		   // instantiate a ninja 
		Wizard wizard1 = new Wizard();     // instantiate a wizard
		Samurai samurai1 = new Samurai();  // instantiate a samurai
		
		ninja1.steal(wizard1);
		System.out.println(wizard1.getHealth());
		
	}
}
