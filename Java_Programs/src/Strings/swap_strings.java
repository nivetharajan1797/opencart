package Strings;

public class swap_strings {

	public static void main(String[] args)
	{
		String a = "Nivetha";
		String b = "Rajanjkdjiwnod";
		a = a + b;
		b = a.substring(0, a.length()-b.length());
		
		a = a.substring(8);
		System.out.println(a);
		System.out.println(b);
		
	}
}