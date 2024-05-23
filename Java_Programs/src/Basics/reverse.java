package Basics;

public class reverse {
	
	public void reverse_string(String s)
	{
	   int l = s.length();
	   String s1="";
	   char ch;
	   for(int i=0;i<l;i++)
	   {
		   ch= s.charAt(i); //extracts each character
	        s1= ch+s1; //adds each character in front of the existing string
	      
	       
	   }
	   System.out.println("Reversed word: "+ s1);
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello";
		reverse r = new reverse();
		r.reverse_string(s);
		
	}

}
