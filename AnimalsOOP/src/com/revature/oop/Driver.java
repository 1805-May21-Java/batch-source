package com.revature.oop;

public class Driver {

	public static void main(String[] args) {
		
		// create 3 animals
		Mammal bat = new Mammal(false);
		Mammal dolphin = new Mammal(true);
		Animal vulture = new Animal("Vulture", 2, true);
		
		Animal b = bat;
		Object o = bat;
		
		System.out.println(b.numLegs);
		
		// set values for Bat and Dolphin
		bat.name = "Bat";
		bat.numLegs = 2;
		bat.canFly = true;
		dolphin.setName("Dolphin");
		dolphin.setNumLegs(0);
		dolphin.setCanFly(false);
		
		// print out initial stats for all
		System.out.println(vulture.name + " " + vulture.numLegs 
				+ " " + vulture.canFly);
		System.out.println(bat.getName() + " " + bat.numLegs + " " 
				+ bat.canFly + " " + bat.isHasLiveYoung() + " " 
				+ bat.isCanSwim());
		System.out.println(dolphin.getName() + " " + dolphin.numLegs + " " 
				+ dolphin.canFly + " " + dolphin.isHasLiveYoung() + " " 
				+ dolphin.isCanSwim());
		
		// Predator attacks! Animals will lose limbs when attacked.
		// (yes it's grim, sorry)
		dolphin.predatorAttack();
		
		System.out.println(dolphin.getNumLegs());

	}

}
