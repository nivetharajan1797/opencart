package pro1;

public class test1 {

	
	public void getData()
	{
		int k = 1;
//		System.out.println("hey");
		for (int i = 0; i<4 ; i++)
		{
		 for (int j=1; j<=4-i; j++)
		 {
			 System.out.print(k);
			 
		 }
		 System.out.print("\n");
		}
	}
	
	
	
	public static void main(String[] args)
	{
		test1 t1=new test1();
		t1.getData();
//		System.out.print("Hello!");
	}
}
