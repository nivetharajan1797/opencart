package pro2;

public class find_min {

	public static void main(String[] args)
	{
		int a[][] = {{22,4,5},{3,4,7},{11,12,9}};
		
		int min = a[0][0] ;
		for (int i=0; i<3;i++)
		{
			for(int j=0; j<3; j++)
			{
				
				
				if(min<a[i][j])
				{
					
				}
				else {
					min = a[i][j];
				}
			}
			
			
		}
		System.out.print(min);
	}
	
	
}

