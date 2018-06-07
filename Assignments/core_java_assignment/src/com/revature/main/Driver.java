package com.revature.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.lang.reflect.*;


public class Driver {

	public static void main(String[] args) 
	{
		
		
		//1 Question Bubble Sort
		//We create integer array and put values inside the array
		//We display the value before we sorted and the value after sorted.
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Question 1 Result: ");
		Integer[] array = {20, 2, 40, 24, 8};
		System.out.println("The result before bubble sort: ");
		for(Integer i: array)
		{
			System.out.print(i+" ");
		}
		
		BubbleSort.sort(array);
		System.out.println("\nThe result after bubble sort: ");

		for(Integer i: array)
		{
			System.out.print(i+" ");
		}


		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//2 Question Fibinacci First 25
		//We give a constant value number and check the outcome 
		int number = 25;
		System.out.println("Question 2 Result: ");	
		System.out.print("The Fibinacci number of "+number+" is: ");
		System.out.println(Fibinacci.calculate(number));
		
		
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//3 Question Reverse a string without a temporary variable
		//We assigned a a string value in String and check if the outcome is reversed text
		System.out.println("Question 3 Result: ");	
		String text = "HelloWorld";
		String reverse = ReverseString.reverse(text);
		System.out.print("Your reverse \""+text+"\" is: ");
		System.out.println("\""+reverse+"\"");
		
		
		
		
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//4 Question 
		//we assigned integer value to testNumber and do the factorial calculation on the testNumber
		System.out.println("Question 4 Result: ");	
		int testNumber =6;
		System.out.print("The factorial of "+testNumber+" is: ");
		System.out.println(Factorial.calculate(testNumber));
		
		
		
		
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//5 Question 
		//We assigned a string value to testStr, and integer value to toIndex for our argument inputs.
		System.out.println("Question 5 Result: ");	
		String testStr = "HelloMyClass";
		int toIndex =7;
		StringBuilder newString = SubString.to(testStr, toIndex);
		System.out.println("The substring of \""+testStr+"\" from 0 to "+toIndex+" index is: ");
		System.out.println("\""+newString+"\"");
		
		
		
		
		
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//6 Question 
		// we assigned integer value to "value" and use ternary operation to decide if it should return string "Even" or "Odd"
		System.out.println("Question 6 Result: ");	
		int value = 82;	
		String evenOrOdd = (IsEven.isEven(value))? "Even": "Odd";;
		System.out.println("The value: "+ value+ " is "+ evenOrOdd);
		
		
		
		
		
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//7 Question 
		//We created arraylist employees and assigned Employee object in the arraylist
		//we create instances for our argument inputs in collection.sort() method. 
		//we use collection interface to sort our employee by age, name , and department
		//
		System.out.println("Question 7 Result: ");
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Gariel Beloton", "Software Engineer", 20));
		employees.add(new Employee("Arival Delt", "Apple Engineer", 30));
		employees.add(new Employee("Jacibo Albo", "Hard Engineer", 24));
		employees.add(new Employee("Bineo Soxbo", "Omni Engineer", 52));
		employees.add(new Employee("Pobe Bonh", "IT Engineer", 19));
		
		System.out.println("Sort employees by age: ");
		Collections.sort(employees, new CompareAge());
		for(Employee employee: employees)
			System.out.println(employee);
		
		System.out.println();
		System.out.println("Sort employees by name: ");
		Collections.sort(employees, new CompareName());
		for(Employee employee: employees)
			System.out.println(employee);
		
		
		System.out.println();
		System.out.println("Sort employees by department: ");
		Collections.sort(employees, new CompareDepartment());
		for(Employee employee: employees)
			System.out.println(employee);


		
		
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//8 Question 
		//we create Arraylist and assigned several string with palindromes and without.
		System.out.println("Question 8 Result: ");
		ArrayList<String>  list = new ArrayList<>();
		ArrayList<String> palindromes = new ArrayList<>();
		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refer");
		list.add("billy");
		list.add("did");
		
		for(String s: list)
		{
			if(Palindromes.isTrue(s))
			{
				palindromes.add(s);
			}
			
		}
		System.out.println("The palindromes in the new arraylist are: ");
		for(String s: palindromes)
		{
			System.out.print(s+" ");
		}

		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//9 Question 
		//We create arraylist to put 1, 2...100 and print out all number from 1 to 100 which is prime
		System.out.println("Question 9 Result: ");
		ArrayList<Integer> numbers = new ArrayList<>();
		System.out.println("The prime number from 1 to 100 is: ");
		for(int i=1; i<=100; i++)
		{
			numbers.add(i);
			if(Prime.isTrue(i))
				System.out.print(i+" ");
		}

		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//10 Question 
		//We assigned two values to compare the min.
		
		System.out.println("Question 10 Result: ");
		int first=4, second=7;
		
		System.out.print("The minimum number "+first+" and "+second+" is: ");
		System.out.println(CompareNumber.min(first, second));

		
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//11 Question 
		//In this question we use reflection to get variables from another package
		//we create a class to store file Animal
		//we have field array to store all of the declared fields in Animal class.
		//we do the enhanced for loop to display the modifier, type and the name of that field.
		System.out.println("Question 11 Result: ");
		try
		{
			Class<?> c1 = Class.forName("com.revature.file.Animal");
			Field[] fields = c1.getDeclaredFields();
			for(Field field: fields)
			{
				System.out.println(Modifier.toString(field.getModifiers())+" "+ field.getType()+" "+field.getName());
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//12 Question 
		//We create an array list named listOfNumber which stores integer from 1 to 100
		//we print out all of the number from 1 to 100 which is even
		System.out.println("Question 12 Result: ");
		ArrayList<Integer> listOfNumber = new ArrayList<>();
		for(int i=1;i<=100;i++)
		{
			listOfNumber.add(i);
		}
		for(int i: listOfNumber)
		{
			if(i%2==0)
				System.out.print(i+" ");
		}
		
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//13 Question 
		//we create two For loop to print out binary number in triangle shape.
		System.out.println("Question 13 Result: ");
		
		for(int i=1; i<=4;i++)
		{
			for(int j=1; j<=i; j++) 
			{
				if((i+j)%2==0)
					System.out.print("0 ");
				else System.out.print("1 ");
			}
			System.out.println();
		}
		
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//14 Question 
		//In this section we use switch case to find square root, date, and split string into string array
		System.out.println("Question 14 Result: ");
		
		int testCase = 2;
		String myList = "I am learning Core Java";
		String[] myListArray=null;
		double myNumber =9;
		
		switch(testCase)	
		{
			case 1: 
				{
					System.out.print("Your sqrt of "+myNumber+" is: ");
					System.out.println(Math.sqrt(myNumber));
				}
				break;
			case 2: 
				{
					System.out.print("Your local time is :");
					System.out.println(java.time.LocalDate.now());  
				}
				break;
			case 3: 
				{
					myListArray = myList.split(" ");
					System.out.println("This is the result after spitting arraylist: ");
					for(String s: myListArray)
					{
						System.out.println(s+"  ");
					}
				}
				break;
		}

		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//15 Question 
		//we use interface for our Operator class method implementations
		//all of the operator take two inputs
		//return the result in double type.
		System.out.println("Question 15 Result: ");
		double a=15.0, b=3.0;
		Operator operator = new Operator();
		
		System.out.println("The result of the arithmetic operator: ");
		System.out.println(a+" + "+b+" = "+operator.addition(a, b));
		System.out.println(a+" - "+b+" = "+operator.substraction(a, b));
		System.out.println(a+" / "+b+" = "+operator.division(a, b));
		System.out.println(a+" x "+b+" = "+operator.multiplication(a, b));
		
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//16 Question 
		//We use command line argument String[] args
		//we also have ArrayIndexOutOfBoundsException to in case we forget to assign value to args[]
		
		System.out.println("Question 16 Result: ");
		try
		{
			System.out.println("The string \""+args[0]+"\" has "+args[0].length()+" character(s)");
			
		}catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("The input argument has to be a string");
		}
		
		
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//17 Question 
		// We use scanner to ask for input value 
		// we calculate interest = principle*rate*years.
		//return in double type
		double principle, rate, years, interest;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Question 17 Result: ");
		
		System.out.println("Enter your Principle");
		principle = sc.nextDouble();
		System.out.println("Enter your Interest Rate");
		rate = sc.nextDouble();
		System.out.println("Enter your Time in year(s)");
		years = sc.nextDouble();
		interest = principle*rate*years;
		System.out.println(interest);
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//18 Question 
		//First we have isUpperCase() method which is to check any of the characters in the string has uppercase
		//Second we have toUpperCase() method which is to convert input string to uppercase string
		//Third we have toIntegerPlusTen() method which is to parse String value and convert to int.
		System.out.println("Question 18 Result: ");
		System.out.println();
		StringManipulation tool = new StringManipulation();
		String test0 = "Trudd";
		String test1 = "Hello";
		String test2 = "89";
		System.out.println("Is any of the characters in \""+ test0+"\" upper case: "+ tool.isUpperCase(test0));
		System.out.println("The result of \""+ test1+"\" to upper case: "+tool.toUpperCase(test1));
		System.out.println("The result of \""+test2 + "\" + 10: "+ tool.toIntegerPlusTen(test2));
		
		
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//19 Question 
		// We create an arraylist and store inter from 1 to 10
		// we sum all of the even number from the arraylist
		// we sum all of the odd number from the arraylist
		// we print out the number in the arraylist which are not prime
		System.out.println("Question 19 Result: "); 
		ArrayList<Integer> integers = new ArrayList<>();
		for(int i=1;i<=10;i++)
		{
			integers.add(i);
		}
		int result=0;

		for(int i: integers)
		{
			result += (i%2==0)? i : 0;
		}
		System.out.println("Sum of even numbers : "+result);
		
		result =0; 
		for(int i: integers)
		{
			result += (i%2==1)? i : 0;
		}
		System.out.println("Sum of odd numbers : "+result);
		System.out.println("The number those are not prime: ");
		for(int i : integers)
		{
			if(!Prime.isTrue(i))
				System.out.print(i+" ");
			
		}
		
		
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		//20 Question 
		//We use BufferedReader to read file line by line and split it by ":"
		//We add some titles before each item.
		System.out.println("Question 20 Result: ");
		BufferedReader br = null;
		String path = "src/com/revature/file/read_data.txt";
		try
		{
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			String[] s;
			while(line!=null)
			{

				s = line.split(":");
				System.out.println("Name: "+s[0]+" "+ s[1]);
				System.out.println("Age: "+s[2]+ " years");
				System.out.println("State: "+s[3] +" State");
				line=br.readLine();
				System.out.println();
			}

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
