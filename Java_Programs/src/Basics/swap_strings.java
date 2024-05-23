package Basics;

public class swap_strings {

	public static void main(String[] args) {
		 String a = "Nivetha";
	        String b = "Rajan";
//	        String c = " ";
//	        
//	        c = a;
//	        a = b;
//	        b = c;
//	        
//	        
//	        System.out.println("String a  "+a);
//	        System.out.println("String a  "+b);
//	        
	       a = a+b;
	       
	       b = a.substring(0,a.length()-b.length());
	       a = a.substring(b.length());
	        System.out.println("Strings after swap: a = " +  
                    a + " and b = " + b);         

	        
	}

}
