package Numbers;

public class amstrong {

	public static void main(String[] args) {

		int am = 153;
		int d;
		int bm = am;
		double rev =0;
		while(am>0)
		{
			d = am%10;
			rev = rev + Math.pow(d, 3);
			am = am/10;
		}
		if(rev == bm)
		{
			System.out.println("Amstrong number");
		}
		else {
			
			System.out.println("Not a Amstrong number");
		}
	}

}
