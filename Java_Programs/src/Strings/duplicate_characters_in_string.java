package Strings;

public class duplicate_characters_in_string {

	public static void main(String[] args) {

		String name="elssmnnnnnn";
		char ch = 0,ch1;
		Boolean duplicate=false;
		for(int i=0;i<name.length();i++)
		{
			ch = name.charAt(i);
			duplicate = false;
//			System.out.println(ch);
			
			for(int j=i+1;j<name.length();j++)
			{
				ch1 = name.charAt(j);
				
//				System.out.println(ch1);
				if(ch==ch1) 
				{
					duplicate=true;
					break;
				}
				
				
			}
			if(duplicate)
			{
				System.out.println(ch);
				
			}
			
			
			
		}
		
		
		
	}

}
