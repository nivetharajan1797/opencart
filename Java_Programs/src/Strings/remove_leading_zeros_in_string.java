package Strings;

public class remove_leading_zeros_in_string {

	public static void main(String[] args) {

		String le="00123";
		int count=0;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<le.length();i++)
		{
			char c=le.charAt(i);
			//System.out.println(c);

			if(c=='0')
			{
				sb.append("");
				count++;
				
			}
			else
				
			{
				for(int j=i;j<le.length();j++)
				{
					sb.append(le.charAt(j));
				}
				
			}
			
				
		
			
		}
		
		System.out.println(sb);
	}

}