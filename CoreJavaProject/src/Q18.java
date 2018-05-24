
public class Q18 extends Q18Super{

	public static void main(String[] args) {
		//I can't make the methods static since they're inherited, so I need to create an instance of this class
		
		Q18 q18 = new Q18();
		System.out.println(q18.isUpper("hello!"));
		System.out.println(q18.strToUpper("Hello"));
		System.out.println(q18.strToInt("18"));
		
	}

	@Override
	boolean isUpper(String str) {
		//if there's any upper cases letters then the toLower will change the string and they won't be equal
		//if there's no lower cases, then that method won't do anything
		return str.equals(str.toLowerCase());
	}

	//just uses the toUpperCase to convert
	@Override
	String strToUpper(String str) {
		return str.toUpperCase();
	}

	//Tries to convert str to an int, if not able to then throw an exception and return 0
	@Override
	int strToInt(String str) {
		try {
		return Integer.parseInt(str)+10;
		}catch (NumberFormatException e) {
			System.out.println("Cannot be converted to an int!");
			return 0;
		}
	}

}
