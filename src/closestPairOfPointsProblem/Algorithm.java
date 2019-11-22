/**
 * 
 */
package closestPairOfPointsProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author salipuri
 * 
 * Algorithm:
 * -Sort all the points according to x coordinates
 * -Divide all points into two subsets with the help of middleIndex
 * -Find the minimum distance recursively in two subsets 	// d1 & d2
 * -Calculate the minimum of these smallest distances		//d=min(d1,d2)
 * -Check the neighborhood of the middle line(strip) there may be points that are closer to each other than min(d1,d2).So we get a strip minimum
 * -Find the smallest distance in the strip
 * -Finally return min(d,stripMinimum)
 *
 */
public class Algorithm {
	
	private List<Point> points;

	public Algorithm(List<Point> points) {
		super();
		this.points = points;
	}
	
	public double solveProblem() {
		List<Point> sortedXPoints = new ArrayList<>();
		List<Point> yPoints = new ArrayList<>();
		
		for(Point point:points) {
			sortedXPoints.add(point);
			yPoints.add(point);
		}
		
		sortByX(sortedXPoints);
		
		return findClosestPoints(sortedXPoints,yPoints,sortedXPoints.size());
	}
	
	private void sortByX(List<Point> sortedXPoints) {
		Collections.sort(points, new XSorter());
		
	}

	public double bruteForceApproach(List<Point> points){
		  
		double minDistance = Double.MAX_VALUE;
		for(int i=0;i<points.size();i++){
			for(int j = i+1;j<points.size();j++){
				if(distance(points.get(i),points.get(j))< minDistance){
		  			minDistance = distance(points.get(i),points.get(j));
		  		}
		  	}
		 }
		 return minDistance;
	 }

	public double findClosestPoints(List<Point> sortedXPoints, List<Point> yPoints, int numOfPoints) {
		
		if(numOfPoints <= 3)
			return bruteForceApproach(sortedXPoints);
		
		int middleIndex = numOfPoints/2;
		
		Point middlePoint = sortedXPoints.get(middleIndex);
		List<Point> leftSubPointsY = new ArrayList<>();
		List<Point> leftSubPointsSortedX = new ArrayList<>();
		List<Point> rightSubPointsY = new ArrayList<>();
		List<Point> rightSubPointsSortedX = new ArrayList<>();
		
		//divide points to left and right subarrays
		
		for(int index=0;index<numOfPoints;index++) {
			if(yPoints.get(index).getX()<= middlePoint.getX()) {
				leftSubPointsY.add(yPoints.get(index));
				leftSubPointsSortedX.add(sortedXPoints.get(index));
			}else {
				rightSubPointsY.add(yPoints.get(index));
				rightSubPointsSortedX.add(sortedXPoints.get(index));
			}
		}
		
		double sigmaLeft = findClosestPoints(leftSubPointsSortedX, leftSubPointsY, middleIndex);
		double sigmaRight = findClosestPoints(rightSubPointsSortedX, rightSubPointsY, numOfPoints - middleIndex);
		
		double sigma = Math.min(sigmaLeft, sigmaRight);
		
		List<Point> pointsInStrip = new ArrayList<>();
		
		for(int index=0;index<numOfPoints;index++) {
			if(Math.abs(yPoints.get(index).getX()-middlePoint.getX())<sigma) {
				pointsInStrip.add(yPoints.get(index));
			}
		}
		
		double minDistanceStrip = findMinimumDistanceInStrip(pointsInStrip,sigma);
		
		return Math.min(sigma, minDistanceStrip);
	}

	public double findMinimumDistanceInStrip(List<Point> pointsInStrip, double sigma) {
		
		double minDistance = sigma;
		for(int i=0;i<pointsInStrip.size();i++) {
			for(int j=i+1;j<pointsInStrip.size() && (pointsInStrip.get(j).getY()-pointsInStrip.get(i).getY())<minDistance;j++) {
				if(distance(pointsInStrip.get(i),pointsInStrip.get(j))<minDistance) {
					minDistance = distance(pointsInStrip.get(i),pointsInStrip.get(j));
				}
			}
		}
		return minDistance;
	}
	
	public double distance(Point point1,Point point2) {
		double xDistance = Math.abs(point1.getX() - point2.getX());
		double yDistance = Math.abs(point1.getY() - point2.getY());
		
		return Math.sqrt(xDistance*xDistance+yDistance*yDistance);
	}

}
