package Basics;

public class output {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="a2b3c4";
		for(int i=0;i<s.length();i++)
		{
		 
		if(Character.isAlphabetic(s.charAt(i)))
		{
			
			
		}
		else {
			int a = Character.getNumericValue(s.charAt(i));
			for(int j=0;j<a;j++) {
				
				System.out.print(s.charAt(i-1));
			}
		}
		
		
		
		
		
		}
		
	}

}
