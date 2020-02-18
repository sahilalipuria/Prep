/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 *
 */
public class TrappingRainWater {

	/**
	 * @param args
	 */
	
	public static int trap(int[] height) {
        
		int totalWater = 0;
		
		if(height == null || height.length == 0)
			return totalWater;
		
		int[] leftMax = new int[height.length];
		leftMax[0] = 0;
		int rightMax = 0;
		
		for(int i=1;i<height.length;i++) {
			leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
		}
		
		for(int i = height.length-1;i>=0;i--) {
			rightMax = Math.max(rightMax, height[i]);
			totalWater += Math.min(leftMax[i], rightMax) - height[i] >0 ? Math.min(leftMax[i], rightMax) - height[i]: 0;
			
		}
		
		return totalWater;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));

	}

}
