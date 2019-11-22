package random;

public class IntegerRevers {
	
	public int reverseInteger(int n) {
		int reversedInt=0;
		int remainder;
		while(n>0) {
			remainder = n%10;
			n=n/10;
			reversedInt = reversedInt*10+remainder;
		}
		return reversedInt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IntegerRevers integerRevers = new IntegerRevers();
		System.out.println(integerRevers.reverseInteger(45687));
	}

}
