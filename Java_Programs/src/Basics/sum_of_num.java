package Basics;

public class sum_of_num {

	public static void main(String[] args) 
	{
		
		int num = 123;
		int a = num;
		int t =0;
		while(num > 0) {
		int m = num%10;
		t = t + m;
		num = num/10;
		}
	System.out.println("sum of the interger "+t);
	
}
}
