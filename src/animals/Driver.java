package animals;

public class Driver {
	
	public static void main(String[] args) {
		//Testing override polymorphism by making mm into cow and mammal and see their difference
		//with the use of function staticMethod
		Mammal mm = new Cow();
		mm.staticMethod();

		mm = new Mammal();
		mm.staticMethod();
		
		//Testing the function speedUp and slowDown, and making sure NegativeSpeedException works
		System.out.println();
		Horse hh = new Horse(50);
		hh.speedUp(15);
		hh.slowDown(35);
		//testing overload polymorphism by making speedUp and slowDown with 2 vriations, one for
		// int and one for double
		hh.speedUp(12.6);
		hh.slowDown(7.8);
		// double // in order to not make exception come out
		//hh.slowDown(58);
		
		System.out.println();
		Cow cc = new Cow();
		cc.milkCow(1);
		//testing the new cow class, and EmptyMilkException from milkCow function works
		//cc.milkCow(2);
		
		System.out.println();
		Rattlesnake rs = new Rattlesnake();
		//testing out function method from Animal class is working
		rs.makeNoise();
		rs.lifeExpectancy();
	}
}
