package Basics;

public class search_element_in_array {

	public int search(int a[],int n)
	{
		int l = a.length;
		for(int i=0;i<l;i++)
		{
			if(a[i]==n) 
			{
				
				return i;
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		int a[]= {2,3,4,6,7,8};
		int n = 4;
		search_element_in_array sr = new search_element_in_array();
		int p = sr.search(a,n);
		if(p== -1) {
			System.out.println("Element not found");
			
		}
		else {
			System.out.println("Indext of the element is "+p);
		}
	}
	
}
