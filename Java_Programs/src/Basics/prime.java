package Basics;

public class prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 157;
		int np = 0;
		
			for(int i=2;i<n1 ; i++)
			{
				if(n1%i==0)
				   {
					 np =1;
					 System.out.println("Is not a prime number");
					 break;

				}
				
				
			}
			if(np != 1 )
			{
			System.out.println("Is a prime number");
			}
		}
		

	

}
