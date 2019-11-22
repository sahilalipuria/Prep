/**
 * 
 */
package recursion;

/**
 * @author salipuri
 *
 *	Minimum number of moves required to solve this problem is (2^n)-1. 
 *	Running time: O(2^n)
 */
public class TowerOfHanoi {

	
	public static void solveHanoi(int n,char rodFrom,char middleRod,char rodTo) {
		if(n==1) {
			System.out.println("Plate 1 moved from "+ rodFrom + " to "+ rodTo );
		}
		else {
			solveHanoi(n-1, rodFrom, rodTo, middleRod);
			System.out.println("Plate "+n+" from "+ rodFrom+ " to "+ rodTo);
			solveHanoi(n-1,middleRod,rodFrom,rodTo);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		solveHanoi(8, 'A', 'B', 'C');

	}

}
