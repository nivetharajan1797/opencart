package Strings;

import javax.net.ssl.SSLContext;

public class replace_character_in_string {

	public static void main(String[] args)
	{
		String s = "Hello";
		char c = 'e';
		char r = 'w';
		for(int i=0;i<s.length();i++)
		{
			char ch = s.charAt(i);
			if(ch == c)
			{	
				s = s.substring(0, i) + ch + s.substring(i+1);
				//s=s.replace(ch, r);
				//s=s.substring(0,i);
				System.out.println(s);
			}
		
		}
		
	}
	
}