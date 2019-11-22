/**
 * 
 */
package floodFill;

/**
 * @author salipuri
 *
 */

import java.util.Arrays;

public class FloodFillThroughDFS
{
	// Below arrays details all 8 possible movements
	private static final int[] row = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static final int[] col = { -1, 0, 1, -1, 1, -1, 0, 1 };

	// check if it is possible to go to pixel (x, y) from
	// current pixel. The function returns false if the pixel
	// has different color or it is not a valid pixel
	public static boolean isSafe(char[][] M, int x, int y, char target) {
		return x >= 0 && x < M.length && y >= 0 && y < M[0].length
				&& M[x][y] == target;
	}

	// Flood fill using DFS
	public static void floodfill(char[][] M, int x, int y, char replacement)
	{
		// get target color
		char target = M[x][y];

		// replace current pixel color with that of replacement
		M[x][y] = replacement;

		// process all 8 adjacent pixels of current pixel and
		// recur for each valid pixel
		for (int k = 0; k < row.length; k++)
		{
			// if the adjacent pixel at position (x + row[k], y + col[k]) is
			// a valid pixel and have same color as that of the current pixel
			if (isSafe(M, x + row[k], y + col[k], target))
				floodfill(M, x + row[k], y + col[k], replacement);
		}
	}

	public static void main(String[] args) {
		// matrix showing portion of the screen having different colors
		char[][] M = {
				"YYYGGGGGGG".toCharArray(),
				"YYYYYYGXXX".toCharArray(),
				"GGGGGGGXXX".toCharArray(),
				"WWWWWGGGGX".toCharArray(),
				"WRRRRRGXXX".toCharArray(),
				"WWWRRGGXXX".toCharArray(),
				"WBWRRRRRRX".toCharArray(),
				"WBBBBRRXXX".toCharArray(),
				"WBBXBBBBXX".toCharArray(),
				"WBBXXXXXXX".toCharArray()
		};

		// start node
		int x = 3, y = 9;	// having target color = "X"

		// replacement color
		char replacement = 'C';

		// replace target color with replacement color using DFS
		floodfill(M, x, y, replacement);

		// print the colors after replacement
		for (int i = 0; i < M.length; i++) {
			System.out.println(Arrays.toString(M[i]));
		}
	}
}