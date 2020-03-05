/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author salipuri
 * 
 * A boomerang is a set of 3 points that are all distinct and not in a straight line.

Given a list of three points in the plane, return whether these points are a boomerang.

 

Example 1:

Input: [[1,1],[2,3],[3,2]]
Output: true
Example 2:

Input: [[1,1],[2,2],[3,3]]
Output: false
 

Note:

points.length == 3
points[i].length == 2
0 <= points[i][j] <= 100
 *
 */
public class ValidBoomerang {

	/**
	 * @param args
	 */
	
	public static boolean isBoomerang(int[][] points) {
		
		if(points == null || points.length == 0)
			return false;
		
		HashMap<Integer,Integer> diffSet = new HashMap<>();
		HashMap<Integer,Integer> xySet = new HashMap<>();
        int diff =0;
		
		for(int i=0;i<points.length;i++) {
			
			/*if(xSet.contains(points[i][0]))
				return false;
			else
				xSet.add(points[i][0]);
			
			if(ySet.contains(points[i][1]))
				return false;
			else
				ySet.add(points[i][1]);*/
			System.out.println(points[i][0]+","+points[i][1]);
			if(xySet.containsKey(points[i][0])) {
				{
					if(xySet.get(points[i][0])== points[i][1])
						return false;
				}
			}else
				xySet.put(points[i][0], points[i][1]);
			
			diff = points[i][0] - points[i][1];
            if(diffSet.containsKey(diff)){
                if(diffSet.get(diff)>=2)
                    return false;
                else
                   diffSet.put(diff,2); 
            }else
                diffSet.put(diff,1);
		}
		
		return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] points = new int[][] {{0,0},{2,1},{2,1}};
		System.out.println(isBoomerang(points));
	}

}
