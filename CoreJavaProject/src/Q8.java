import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q8 {

	public static void main(String[] args) {
		//Written using block selection, String Builder so that I can easily reverse it
		List<StringBuilder> arrayList = new ArrayList<StringBuilder>();
		arrayList.add(new StringBuilder("karan"));
		arrayList.add(new StringBuilder("madam")); 
		arrayList.add(new StringBuilder("tom")); 
		arrayList.add(new StringBuilder("civic")); 
		arrayList.add(new StringBuilder("radar")); 
		arrayList.add(new StringBuilder("jimmy"));
		arrayList.add(new StringBuilder("kayak"));
		arrayList.add(new StringBuilder("john"));
		arrayList.add(new StringBuilder("refer")); 
		arrayList.add(new StringBuilder("billy"));
		arrayList.add(new StringBuilder("did"));
		
		//Filters by if the reverse equals the regular, then converts the stream to a list
		//I come from Python so filter was my first thought, and I searched how to do that in Java
		//If I knew this statement would look like this I would have done it in a more readable loop 
		//to check for palindromes, but by the time I realized that it was too late
		List<StringBuilder> palinList = arrayList.stream().filter(x -> x.toString()
				.equals((x.reverse().toString()))).collect(Collectors.toList());
		System.out.println(palinList);
	}

}
