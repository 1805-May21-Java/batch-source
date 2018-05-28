package javacore;

public class Triangle {
	static void triangle(int n)
    {
      
         //use nested for loop with if statement to to alternate 1 and 0's with for each iteration
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j <= i; j++) 
            {
                if (((i + j) % 2) == 0) 
                    System.out.print("0");
                else
                    System.out.print("1");        
            }
            
            System.out.println();
        } 
    }
	
	
	public static void main(String[] args) {
		
		 int n = 4;
 
	     triangle(n);

	}
}
