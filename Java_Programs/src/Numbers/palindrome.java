package Numbers;

public class palindrome {

	public static void main(String[] args) {

		int p = 1301;
		int r = 0;
		int p1 = p;
		while(p>0)
		{
			int d = p%10;
			r = r * 10 + d;
			p = p/10;
		}
		if(r == p1)
		{
			System.out.println("palindrome");
		}
		else {
			System.out.println("not a palindrome");
		}
	}

}
