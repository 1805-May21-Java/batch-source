package com.revature.animals;
import java.util.*;

public class AnimalDriver {
	public static void main(String args[]) {
		// We are encapsulating over 100 lines of code worth of parameters, behaviors,
		// and such into two variables in two lines. That's encapsulation in a nutshell.
		Dolphin d = new Dolphin(0, 100, 440, 15, 25, "Joe", 10);
		Dog g = new Dog(4, 100, 50, 3, 10, "Dolphin", 5.1f, "Pecan");
		Scanner s = new Scanner(System.in);
		
		// Torpedo firing time. More examples of abstraction: we
		// can decipher this code without diving into the rest of
		// the classes in this package!
		System.out.println("Type the number of torpedos for " + d.getName() + " the Dolphin to fire, then press Enter!");
		System.out.println("You have " + d.getNumTorpedos() + " torpedos left.");
		while(d.getNumTorpedos() > 0) {
			System.out.print("Number of torpedos to fire: ");
			int fireCount = s.nextInt();
			d.launchTorpedos(fireCount);
			System.out.println("\nYou have " + d.getNumTorpedos() + " torpedos left.");
		}
		System.out.println("\n" + d.getName() + " has successfully fired 100 torpedos. Good job!");

		System.out.println("Now type the number of torpedos for " + g.getName() + " the Dog to fire, then press Enter!");
		System.out.println("You have " + g.getNumTorpedos() + " torpedos left.");
		while(g.getNumTorpedos() > 0) {
			System.out.print("Number of torpedos to fire: ");
			int fireCount = s.nextInt();
			g.launchTorpedos(fireCount);
			System.out.println("\nYou have " + g.getNumTorpedos() + " torpedos left.");
		}
		System.out.println("\n" + g.getName() + " has successfully fired 100 torpedos. Good job!");
		
		s.close();
	}
}
