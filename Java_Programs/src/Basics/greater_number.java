package Basics;

public class greater_number {

	public static void main(String[] args)
	{
		
		int a[]= {1,2,3,41,511,6,9};
		int n = a.length;
		int temp = 0;
		for(int i=0;i<n;i++)
		{
			if(a[i]>temp)
			{
				temp=a[i];
			}
			
			
		}
		
		System.out.println(temp);
	}
	
	
	
}
