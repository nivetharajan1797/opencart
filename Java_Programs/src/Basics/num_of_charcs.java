package Basics;

public class num_of_charcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "I love  sdbiriyaniiii";
		int count = 0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i) != ' ')
			{
				count ++;
			}
			
		}
		
		System.out.println(count); 
	}

}
