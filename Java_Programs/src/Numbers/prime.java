package Numbers;

public class prime {

	public static void main(String[] args)
	{
		
		int a = 1,count=0;
	
		if(a>1)
		{
			for(int i=2;i<a;i++)
			{
				int d = a%i;
				if(d == 0)
				{
				count++;
				}
			}
			
			if(count != 0)
			{
				System.out.println("prime number");
			}
			else
			{
				System.out.println("not a prime number");
			}
		}
		else {
			
			System.out.println("Number is one or less than 1");
		}
	}
}