package Basics;

public class reverse_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,6,5,9,8};
		int n = a.length;
		int j = n;
		int[] b = new int[n];
		for(int i=0;i<n;i++)
		{
			
			
			b[j-1] = a[i];
			j=j-1;
			
		}
		for(int k=0;k<a.length;k++)
		{
			System.out.print(b[k]);
		}
		
		
	}

}
