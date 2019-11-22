/**
 * 
 */
package backtracking;

/**
 * @author salipuri
 * 
 * NP complete problem with exponential running time
 * Problem : coloring the vertices of a graph such that no two adjacent vertices share same color-Vertex Coloring.
 * Reached popularity with general public in the form of popular number puzzle called Sudoku
 * The smallest number of colors needed to color a graph G is called its chromatic number
 * There may be more than one solution for eg we can color 4 vertices in 12 ways with 3 colors!!!
 * 
 * APPLICATIONS:
 * -BIPARTITE GRAPH:
 * 	Determining if a graph can be colored with 2 colors is equivalent to determining whether or not graph is bipartite
 * 		and thus computable in linear time using BFS.
 * 	Bipartite graph: a graph whose vertices can be divided into two disjoint sets U&V such that every vertex in U connects 1 in V.
 * 
 * -MAKING SCHEDULES:
 * 	We want to make an exam schedule for a university. We have different subjects & different students enrolled on every subject.
 * 	Many subjects would have common students.
 * 	How do we schedule the exam so that no two exams with a common student are scheduled at same time? How many minimum time slots
 * 	are needed to schedule all exams?
 * Solution: This problem can be represented as a graph where every vertex is a subject & an edge b/w two vertices means there is a common student.
 * 			So this is a graph coloring problem where minimum number of time slots is equal to chromatic number of the graph.
 * 
 * -RADIO FREQUENCY ASSIGNMENT:
 * 	When frequencies are assigned to towers,frequencies assigned to all towers at the same location must be different coz of interference!!
 * 	How to assign frequencies with this constraint? What is the minimum number of frequencies needed?
 * 	SOLUTION: This problem is also an instance of graph coloring problem where every tower represents a vertex and an edge between
 * 			  two towers represents they are in range of each other
 * 
 * -REGISTER ALLOCATION:
 * 	In compiler optimization-> register allocation is the process of assigning a large number of target program variables onto a small 
 * 	number of CPU registers.
 * 
 * -MAP COLORING:
 * 	We want to construct a map of countries or state where adjacent or states cant be assigned same color.
 * 	It is typical coloring problem. Four color are sufficient to color any map- FOUR COLOR THEOREM.
 * 
 * SOLUTIONS:
 * 	-GREEDY APPROACH: Find the solution but not the most optimal one. It may use more colors then necessary.
 * 	-POWELL-WELSH ALGORITHM: relies on sorting the nodes according to the degrees + we start assigning colors to nodes with most neighbors.
 * 	-BACKTRACKING:
 * 		-We assign color one by one to different vertices starting from the first vertex(optional)
 * 		-Before assigning color we check for safety by checking colors of the neighbors.
 * 		-If we find color assignment which is feasible we mark color assignment as part of solution else we backtrack.
 * 
 * 
 * 
 * 
 *
 */
public class ColoringProblem {

	/**
	 * @param args
	 */
	
	private static int numOfVertexes;
	private static int[] colors;
	private static int[][] adjacencyMatrix;
	private static int numOfColors;
	
	public ColoringProblem(int numOfColors,int[][] adjacencyMatrix) {
		this .numOfColors = numOfColors;
		this.adjacencyMatrix = adjacencyMatrix;
		this.colors = new int[adjacencyMatrix.length];
		this.numOfVertexes = adjacencyMatrix.length;
	}
	
	public static void solve() {
		if(setColor(0)) {
			showResults();
		}
		else {
			System.out.println("NO SOLUTION FOUND!!!!");
		}
	}
	
	public static void showResults() {
		for(int i=0;i<numOfVertexes;i++) {
			System.out.println("Node: "+(i+1)+" has color: "+colors[i]);
		}
		
	}

	private static boolean setColor(int vertexIndex) {
		if(vertexIndex == numOfVertexes) {
			return true;
		}
		
		for(int colorIndex=1;colorIndex<=numOfColors;colorIndex++) {
			if(isColorValid(vertexIndex,colorIndex)) {
				colors[vertexIndex]=colorIndex;
				if(setColor(vertexIndex+1)) {
					return true;
				}
				//BACKTRACK
			}
		}
		return false;
	}

	public static boolean isColorValid(int vertexIndex, int colorIndex) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<numOfVertexes;i++) {
			if(adjacencyMatrix[vertexIndex][i]==1 && colorIndex == colors[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] graphMatrix = new int[][] {
			{0,1,0,1,0},
			{1,0,1,1,0},
			{0,1,0,1,0},
			{1,1,1,0,1},
			{0,0,0,1,0},
		};
		
		int numOfColors = 3;
		ColoringProblem coloringProblem = new ColoringProblem(numOfColors, graphMatrix);
		coloringProblem.solve();
	}

}
