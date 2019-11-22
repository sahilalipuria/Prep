package recursion;

public class EuclideanAlgoForGCD {
	
	public static int gcdIterative(int num1,int num2) {
		while(num2!=0) {
			int temp = num2;
			num2 = num1%num2;
			num1 = temp;
		}
		return num1;
	}
	
	public static int gcdRecursive(int num1,int num2) {
		if(num2==0)
			return num1;
		else
			return gcdRecursive(num2, num1%num2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			System.out.println("Iterative: "+gcdIterative(30,100));
			System.out.println("Recursive: "+gcdRecursive(7, 9));
	}

}
