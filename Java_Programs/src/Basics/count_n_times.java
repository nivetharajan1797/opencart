package Basics;

import java.util.Scanner;

public class count_n_times {

	public static void main(String[] args)
	{
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the N number: ");
		long N = in.nextLong();
		System.out.println("Enter the D number: ");
		int D = in.nextInt();
		int count = 0;
		long M = 0;
		
		while(N>0)
		{
		M = N%10;
		N = N/10;
		if(M == D)
		{
			count ++;
		}
		
		
		}
		System.out.println("Number of time D appeared: "+ count );
	}
	
	
}
