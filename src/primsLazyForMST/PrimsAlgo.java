/**
 * 
 */
package primsLazyForMST;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author salipuri
 * 
 * 	In Kruskal Algo,we build the spanning tree separately adding the smallest edge to spanning tree if there is no cycle
 * 	In Prims Algo, we build the spanning tree from a given vertex,adding the smallest edge to MST
 * 	Kruskal -> edge based  & Prims -> Vertex based
 * 	There are two implementations : lazy and eager
 * 	Lazy implementation: add the new neighbour edges to heap without deleting its content
 * 	Eager implementation : we keep updating heap  if the distance from a vertex to the MST changes
 * 	Average running time: O(ElogE) but we need additional memory : O(E)
 * 	Worst Case : O(ElogV)
 * 
 * 	Prims algo is significantly faster in the limit when we have a really dense graph with more edges than vertices
 * 	Kruskal performs better in typical situations(sparse graphs) because it uses simple data structure.
 * 	Kruskal can have better performance(s)if the edges can be sorted in linear time or the edges are already sorted.
 * 	Prim's is better if the ratio of edges to vertices is high(dense graphs) as we use heap data structures in Prims.
 * 
 * Applications of Spanning tree:
 * 		- We have N cities
 * 		- We want to make sure that every city can be reached of roads
 * 		- Naive approach : to connect every city with other and its not optimal
 * 		- We have to find MST in order to connect all of the cities with lowest cost possible
 * 		- Same problem with variation of laying internet to a region or electricity or building motor ways
 *
 */
public class PrimsAlgo {

	private List<Vertex> unvisitedVertexes;
	private List<Edge> spanningTree;
	private double fullCost;
	private PriorityQueue<Edge> edgeHeap;
	public PrimsAlgo(List<Vertex> unvisitedVertexes) {
		super();
		this.unvisitedVertexes = unvisitedVertexes;
		this.spanningTree = new ArrayList<>();
		this.edgeHeap = new PriorityQueue<>();
	}
	
	public void PrimsAlgo(Vertex vertex) {
		
		/*
		 * 	Step 1: Select a starting vertex
		   	Step 2: Repeat Steps 3 and 4 until there are fringe vertices
			Step 3: Select an edge e connecting the tree vertex and fringe vertex that has minimum weight
			Step 4: Add the selected edge and the vertex to the minimum spanning tree T[END OF LOOP]
			Step 5: EXIT
		 */
		
		this.unvisitedVertexes.remove(vertex);
		
		while(!unvisitedVertexes.isEmpty()) {
			
			for(Edge e:vertex.getAdjacencies()) {
				if(this.unvisitedVertexes.contains(e.getDestinationVertex())) {
					this.edgeHeap.add(e);
				}
			}
			
			Edge minEdge = this.edgeHeap.remove();
			
			this.spanningTree.add(minEdge);
			this.fullCost += minEdge.getWeight();
			
			vertex = minEdge.getDestinationVertex();
			this.unvisitedVertexes.remove(vertex);
		}
	}
	
	public void showMST() {
		for(Edge e:spanningTree) {
			System.out.println(e.getSourceVertex()+ " - "+ e.getDestinationVertex());
		}
		System.out.println("FullCost : " + this.fullCost);
	}
}
