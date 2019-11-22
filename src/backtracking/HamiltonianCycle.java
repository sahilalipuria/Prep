/**
 * 
 */
package backtracking;

/**
 * @author salipuri
 * 
 * A hamiltonian path in an undirected graph is a path that visits every node exactly once.
 * Hamiltonian Cycle: the first node and the last node of the path are the same vertices
 * There may be several hamiltonian paths in a graph
 * Determining whether such paths and cycles exists in graphs is the Hamiltonian path problem.
 * It is NP complete problem
 * DIRAC PRINCIPLE: A simple graph with N vertices is hamiltonian if every vertex has N/2 or greater degree
 * Important Fact: Finding hamiltonian path is NP complete but we can decide whether such path exists in linear time
 * 					complexity with topological ordering
 * 
 * Solutions:
 * 1.) Naive approach: Generate all possible configurations of the vertices and print the configuration that satisfies constraints.
 * Problem- For a given graph with N vertices there are N! configurations so solution space is enormous.
 * Very very inefficient
 * 2.)Constructing a tree
 * 3.)Backtracking:
 * 	- We use recursion to solve the problem
 * 	- Create an empty path array & add vertex 0 to it as starting vertex
 * 	- Add other vertices,starting from vertex 1
 * 	- Before adding a vertex,check whether it is adjacent to previously added vertex & not added previously
 * 	- If we find such vertex then add it to solution else return false
 *
 */
public class HamiltonianCycle {

	private static int numOfVertexes;
	private static int[] hamiltonianPath;
	private static int[][] adjacencyMatrix;
	
	public HamiltonianCycle(int[][] adjacencyMatrix) {
		this.numOfVertexes = adjacencyMatrix.length;
		this.adjacencyMatrix = adjacencyMatrix;
		this.hamiltonianPath = new int[adjacencyMatrix.length];
		this.hamiltonianPath[0] = 0;
		
		if(feasibleSolution(1)) {
			printHamiltonianCycle();
		}
		else {
			System.out.println("NO HAMILTONIAN CYCLE FOUND");
		}
	}
	
	public static void printHamiltonianCycle() {
		System.out.println("HAMILTONIAN CYCLE");
		for(int vertexIndex=0;vertexIndex<hamiltonianPath.length;vertexIndex++) {
			System.out.println(hamiltonianPath[vertexIndex]);
		}
		System.out.println(hamiltonianPath[0]);
		
	}

	public boolean feasibleSolution(int position) {
		//Check if last vertex is same as first one for cycle.
		if(position ==numOfVertexes) {
			if(adjacencyMatrix[hamiltonianPath[position-1]][hamiltonianPath[0]]==1)
				return true;
			else 
				return false;
		}
		
		for(int vertexIndex=1;vertexIndex<numOfVertexes;++vertexIndex) {
			if(isFeasible(vertexIndex,position)) {
				hamiltonianPath[position] = vertexIndex;
				if(feasibleSolution(position+1))
					return true;
			}
			//BACKTRACK
		}
		
		return false;
	}

	public static boolean isFeasible(int vertexIndex, int actualPosition) {
		// check if it is neighbour to previous vertex or not
		if(adjacencyMatrix[hamiltonianPath[actualPosition-1]][vertexIndex]==0) {
			return false;
		}
		//check if it is already in array or not
		for(int i=0;i<actualPosition;i++) {
			if(hamiltonianPath[i]==vertexIndex) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		int matrix[][] = {
				{0,1,1,1,0,0},
				{1,0,1,0,1,0},
				{1,1,1,1,0,1},
				{1,0,1,0,0,1},
				{0,1,0,0,0,1},
				{0,1,1,1,1,1}
				
		};
		HamiltonianCycle hamiltonianCycle = new HamiltonianCycle(matrix);

	}

}
