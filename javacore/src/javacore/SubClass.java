package javacore;

public class SubClass extends SuperClass {

	@Override
	public boolean checkUpper(String s) {
		char[] charArray = s.toCharArray();
		
		for(char l: charArray) {
			if(Character.isUpperCase(l)) {
				return true;
			} 
			
		}
		return false;
	}

	@Override
	public String lowerToUpper(String s) {
		return s.toUpperCase();
	}

	@Override
	public void addTen(String s) {
		Integer sInt =  Integer.parseInt(s) + 10;
		System.out.println(sInt);
		
		
	}
	
	public static void main(String[] args) {
		SubClass upper = new SubClass();
		
		System.out.println(upper.checkUpper("hello"));
		
		
	}

}
