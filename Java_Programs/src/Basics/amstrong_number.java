package Basics;

public class amstrong_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 153;
		int m = a%10;
		int b = a;
		double r = 0;
		
		while(a != 0)
		{
			int n = a%10;
			r = r + Math.pow(n, 3);
			a = a/10;
		}
		if(r == b)
		{
			System.out.println(b +"  is amstrong number");
		}
		else
		{
			System.out.println(b +"  is not an  amstrong number");

		}

	}

}
