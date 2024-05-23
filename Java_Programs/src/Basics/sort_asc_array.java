package Basics;

public class sort_asc_array {

	public static void main(String[] args) 
	{
		
		int a[] = {13,6,5,48,9,33};
		int b[] = {};
		for(int i=0;i<6;i++)
		{
			if(a[i]>a[i+1])
			{
				b[i]= a[i];
				
				
					}
			else {
				
				b[i] =a[i+1];
			}
			
		}
		
		for(int j=0;j<a.length;j++) {
			System.out.println(b[j]);
		}
		
	}
	
	
}
