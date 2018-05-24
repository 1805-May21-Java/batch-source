package questions;

//Completed
public class Q13TriangleLoop {
	
	public void printTriangle() {
		String line = "";
		for(int i = 0; i < 4; i++) {
			if(i % 2 == 0) {
				line = "0" + line;
				System.out.println(line);
			}else {
				line = '1' + line;
				System.out.println(line);
			}
		}
	}
}
