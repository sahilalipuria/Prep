/**
 * 
 */
package closestPairOfPointsProblem;

import java.util.Arrays;
import java.util.List;

/**
 * @author salipuri
 * 
 * We are given an array of N points in 2D plane & problem is to find the closest pair of points in the array.
 * Applications:  air-traffic control. We may want to monitor planes that come close together and may collide.
 * Brute force Approach: O(N^2) very slow,we may need something faster.
 * Divide and conquer approach might help to achieve O(NlogN) time complexity.
 * 
 * public double bruteForceApproach(List<Point> points){
 * 
 * 	double minDistance = Double.MAX_VALUE;
 * 	for(int i=0;i<points.size();i++){
 * 		for(int j = i+1;j<points.size();j++){
 * 			if(distance(points.get(i),points.get(j))< minDistance){
 * 				minDistance = distance(points.get(i),points.get(j))
 * 			}
 * 		}
 * 	}
 * 	return minDistance;
 * }
 * 
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Point> points = Arrays.asList(new Point(1,1), new Point(1,2), new Point(2,1), new Point(2,2), new Point(2,3), new Point(3,3));
		
		Algorithm algo = new Algorithm(points);
		System.out.println(algo.solveProblem());

	}

}
