package pro2;

public class find_min_row_max {
	public static void main(String[] args)
	{
		int a[][] = {{2,4,5},{3,4,14},{10,12,9}};
		
		int min = a[0][0] ;
		int max = 0;
		for (int i=0; i<3;i++)
		{
			for(int j=0; j<3; j++)
			{
				
				
				if(min<a[i][j])
				{
					
				}
				else {
					min = a[i][j];
					
					
					for(int n =0;n<3;n++)
					{
						if (a[n][j]>min) {
							max = a[n][j];
						}
						else {}
						
					}
					
					
				}
			}
			
			
		}
		System.out.println("minimum number in the matrix "+min);
		
		System.out.println("maximun number in the min no column "+ max);
			
			
			
		}
		
		
		
	}

