package Basics;

import java.util.Scanner;

public class read_input {

	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter String:");
		String s = in.nextLine();
		
		System.out.println("Enter number:");
		int a = in.nextInt();
		
		System.out.println("Enter float no:");
		float b = in.nextFloat();
		
		
		System.out.println(s + a + b);
		
	
	}

}
