package Basics;

public class reverse_string {

	public static void main(String[] args)
	{
		String s = "Go";
		String temp ="";
		char ch;
		for(int i=0;i<s.length();i++) {
			
			ch= s.charAt(i);
			temp = ch+temp;
			
		}
		System.out.println("Reversed word: "+ temp);
		
	}
}