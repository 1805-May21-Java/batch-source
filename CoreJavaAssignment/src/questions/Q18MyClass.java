package questions;

//Q18MyClass extends Q18MyAbstractClass and overrides the abstract methods
//into concrete methods
public class Q18MyClass extends Q18MyAbstractClass{

	@Override
	public boolean hasUpperCase(String str) {
		//iterates through a for loop, if an upperCase character is found
		//method returns true, else returns false.
		//temp stores character at str index
		String temp;
		for(int i = 0; i < str.length(); i++) {
			
			temp = Character.toString(str.charAt(i));
			//if temp.equals() any of these strings then the loop continues
			if(temp.equals(" ") || temp.equals(".") || temp.equals("?") ||
					temp.equals("!")) {
				continue;
			}
			
			//checks if temp.equals the uppercase version of itself,
			//returns true
			if(temp.equals(temp.toUpperCase())) {
				return true;
			}
		}
		//for loop found no upperCase characters and returns false
		return false;
	}

	@Override
	public String lowerToUpper(String str) {
		//temp is used to store changed and unchanged characters in str.
		String temp = "";
		for(int i = 0; i < str.length(); i++) {
			//Checks for lowercase characters, if found, then uppercase
			//version of the character is concatenated to temp
			//Else statement concatenates characters as they are already
			//uppercased.
			if(Character.toString(str.charAt(i)).equals(
					Character.toString(str.charAt(i)).toLowerCase())) {
				temp += Character.toString(str.charAt(i)).toUpperCase();
			}else {
				temp += Character.toString(str.charAt(i));
			}
		}
		return temp;
		
	}

	@Override
	public int stringToInt(String str) {
		//strToInt will be returned, default value -1 given
		int strToInt = -1;
		//try/catch checks if str can be parsed as an integer
		//catches NumberFormatException is .parseInt() is not possible
		try {
			strToInt = Integer.parseInt(str);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		//strToInt is then returned
		return strToInt;
	}

}
