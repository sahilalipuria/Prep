/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
Example 1:
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true


Example 2:
Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
 *
 */
public class CheckIfStraightLine {

	/**
	 * @param args
	 */
	public static boolean checkStraightLine(int[][] coordinates) {
        
        for(int i=2;i<coordinates.length;i++){
            if((coordinates[1][1]-coordinates[0][1])*(coordinates[i][0]-coordinates[0][0])!=
               (coordinates[1][0]-coordinates[0][0])*(coordinates[i][1]-coordinates[0][1]))
                return false;
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(checkStraightLine(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
		System.out.println(checkStraightLine(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}));
		System.out.println(checkStraightLine(new int[][]{{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}}));
		System.out.println(checkStraightLine(new int[][]{{0,1},{1,3},{-4,-7},{5,11}}));
	}

}
