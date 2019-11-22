package dagShortestPathAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author salipuri
 *
 *	If graph is DAG then it is easier to find shortest path as there are no directed cycles
 * 	We sort the vertices in topological ordering
 * 	We iterate through topological ordering relaxing all edges from actual vertex
 * 	Topological sort ordering finds shortest path tree in any edge weighted(can be negative)
 * 	Time Complexity: O(E+V)
 * 	It is much faster than Dijikstra or Bellman ford
 * 	Applications: solving Knapsack problem
 * 	can handle both +ve -ve weights
 * 	GPS,vehicle routing,navigation
 * 	Detecting arbitrage situations in FOREX
 * 	RIP : Routing Information Protocol 
 *  We can construct a football team with max profits max probability best players using DAG.
 * 	It's a distributed algo: 
 * 		-Each node calculates the distance between itself and all other nodes and stores it as a table
 * 		-Each node sends its table to all the adjacent nodes
 * 		-When the node recieves the distance table from its neighbors,it calculates the shortest 
 * 		route to all other nodes and updates its own table to reflect any changes.
 */

public class DagShortesPathAlgo {
	
	public void shortestPath(List<Vertex> vertexList,Vertex sourceVertex,Vertex targetVertex) {
		
		sourceVertex.setDistance(0.0);
		TopologicalSorting topologicalSort = new TopologicalSorting();
		topologicalSort.makeTopologicalOrder(vertexList);
		
		Stack<Vertex> stack = topologicalSort.getStack();
		
		for(Vertex actualVertex: stack) {
			for(Edge e: actualVertex.getAdjacencies()) {
				Vertex u = e.getSourceVertex();
				Vertex v = e.getDestinationVertex();
				if(u.getDistance()+e.getDistance()<v.getDistance()) {
					v.setDistance(u.getDistance()+e.getDistance());
					v.setPredecessor(u);
				}
			}
		}
		
		if(targetVertex.getDistance()==Double.MAX_VALUE) {
			System.out.println("NO SHORTEST PATH FOUND!!!!!!");
		}
		else {
			System.out.println("Shortest distance found between source and vertex is: " + targetVertex.getDistance());
		}
	}
	
	public void showShortestPath(Vertex targetVertex) {
		if(targetVertex.getDistance()==Double.MAX_VALUE) {
			System.out.print("NO SHORTEST DISTANCE FOUND......");
		}
		else {
			List<Vertex> shortestPathArray = new ArrayList<>();
			
			shortestPathArray.add(targetVertex);
			Vertex actualVertex = targetVertex;
			while(actualVertex.getPredecessor()!=null) {
				actualVertex = actualVertex.getPredecessor();
				shortestPathArray.add(actualVertex);
			}
			Collections.reverse(shortestPathArray);
			System.out.println(shortestPathArray);
		}
	}

}
