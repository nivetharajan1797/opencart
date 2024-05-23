package Basics;

public class palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int r, sum=0, temp;
		int num = 341103;
		temp = num;
		while (num>0)
		{
			
			r = num%10;
			sum = (sum*10)+r;
			num = num/10;
			
		}
		if(temp == sum) 
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not a Palindrome");
		}

	}

}
