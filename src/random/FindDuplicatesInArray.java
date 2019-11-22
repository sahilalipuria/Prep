package random;

public class FindDuplicatesInArray {
	
	public void solve(int[] array) {
		for(int i=0;i<array.length;i++) {
			if(array[Math.abs(array[i])]>0) {
				array[Math.abs(array[i])] = -array[Math.abs(array[i])];
			}else {
				System.out.println(Math.abs(array[i])+" is a repitition!!!!");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {2,3,1,2,4,3};
		
		FindDuplicatesInArray findDuplicatesInArray = new FindDuplicatesInArray();
		findDuplicatesInArray.solve(array);
	}

}
