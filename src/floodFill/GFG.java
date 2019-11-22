package floodFill;

/*
 * 
 * In MS-Paint, when we take the brush to a pixel and click, the color of the region of that pixel is replaced with a new selected color. Following is the problem statement to do this task.
Given a 2D screen, location of a pixel in the screen and a color, replace color of the given pixel and all adjacent same colored pixels with the given color.

Example:

Input:
       screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1, 0, 0},
                      {1, 0, 0, 1, 1, 0, 1, 1},
                      {1, 2, 2, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 2, 2, 0},
                      {1, 1, 1, 1, 1, 2, 1, 1},
                      {1, 1, 1, 1, 1, 2, 2, 1},
                      };
    x = 4, y = 4, newColor = 3
The values in the given 2D screen indicate colors of the pixels.
x and y are coordinates of the brush, newColor is the color that
should replace the previous color on screen[x][y] and all surrounding
pixels with same color.

Output:
Screen should be changed to following.
       screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1, 0, 0},
                      {1, 0, 0, 1, 1, 0, 1, 1},
                      {1, 3, 3, 3, 3, 0, 1, 0},
                      {1, 1, 1, 3, 3, 0, 1, 0},
                      {1, 1, 1, 3, 3, 3, 3, 0},
                      {1, 1, 1, 1, 1, 3, 1, 1},
                      {1, 1, 1, 1, 1, 3, 3, 1},
                      };
Flood Fill Algorithm:
The idea is simple, we first replace the color of current pixel, then recur for 4 surrounding points. The following is detailed algorithm.



// A recursive function to replace previous color 'prevC' at  '(x, y)' 
// and all surrounding pixels of (x, y) with new color 'newC' and
floodFil(screen[M][N], x, y, prevC, newC)
1) If x or y is outside the screen, then return.
2) If color of screen[x][y] is not same as prevC, then return
3) Recur for north, south, east and west.
    floodFillUtil(screen, x+1, y, prevC, newC);
    floodFillUtil(screen, x-1, y, prevC, newC);
    floodFillUtil(screen, x, y+1, prevC, newC);
    floodFillUtil(screen, x, y-1, prevC, newC); 
 */

//Java program to implement flood fill algorithm 
class GFG {

//Dimentions of paint screen 
	static int M = 8;
	static int N = 8;

//A recursive function to replace previous color 'prevC' at '(x, y)' 
//and all surrounding pixels of (x, y) with new color 'newC' and 
	static void floodFillUtil(int screen[][], int x, int y, int prevC, int newC) {
		// Base cases
		if (x < 0 || x >= M || y < 0 || y >= N)
			return;
		if (screen[x][y] != prevC)
			return;

		// Replace the color at (x, y)
		screen[x][y] = newC;

		// Recur for north, east, south and west
		floodFillUtil(screen, x + 1, y, prevC, newC);
		floodFillUtil(screen, x - 1, y, prevC, newC);
		floodFillUtil(screen, x, y + 1, prevC, newC);
		floodFillUtil(screen, x, y - 1, prevC, newC);
	}

//It mainly finds the previous color on (x, y) and 
//calls floodFillUtil() 
	static void floodFill(int screen[][], int x, int y, int newC) {
		int prevC = screen[x][y];
		floodFillUtil(screen, x, y, prevC, newC);
	}

//Driver code 
	public static void main(String[] args) {
		int screen[][] = { 
				{ 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1, 1, 0, 0 }, 
				{ 1, 0, 0, 1, 1, 0, 1, 1 },
				{ 1, 2, 2, 2, 2, 0, 1, 0 }, 
				{ 1, 1, 1, 2, 2, 0, 1, 0 }, 
				{ 1, 1, 1, 2, 2, 2, 2, 0 },
				{ 1, 1, 1, 1, 1, 2, 1, 1 }, 
				{ 1, 1, 1, 1, 1, 2, 2, 1 }, };
		int x = 4, y = 4, newC = 3;
		floodFill(screen, x, y, newC);

		System.out.println("Updated screen after call to floodFill: ");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(screen[i][j] + " ");
			System.out.println();
		}
	}
}

//This code has been contributed by 29AjayKumar 
