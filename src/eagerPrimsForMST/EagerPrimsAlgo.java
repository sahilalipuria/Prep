/**
 * 
 */
package eagerPrimsForMST;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author salipuri
 * 
 * 	Aim is we want to construct a minimum spanning tree
 * 	Lazy version -> use a priority queue to get the minimum edge weights: 
 * 					insert all edges to heap without modifying the heap content
 * 	Eager version -> update heap if necessary
 * 					On every iteration we check if there is already a shorter path to spanning tree
 * 
 * 	Applications of Spanning tree:
 * 		- We have N cities
 * 		- We want to make sure that every city can be reached of roads
 * 		- Naive approach : to connect every city with other and its not optimal
 * 		- We have to find MST in order to connect all of the cities with lowest cost possible
 * 		- Same problem with variation of laying internet to a region or electricity or building motor ways
 * 
 * 	K-means clustering:
 * 		- we want to classify similar items
 * 		- For example dots in 2 dimensional planes
 * 		- The dots that are closer to each other than to any other dots will be in same cluster
 * 		- We construct a MST and remove the N-1 most expensive edges if we want to make N clusters
 * 		- It is important in unsupervised data analysis-> we want to find distinct segments in market . //cluster analysis
 * 
 * 	Routing in LAN:
 * 		- Spanning Tree Protocol(STP) ensures a loop free topology for any bridged Ethernet LAN
 * 		- Each switch will infinitely duplicate the first broadcast-> because there is nothing to prevent loops.
 * 		- Idea behind spanning tree topology is that bridges can discover a subset of topology that is loop free.
 * 		- STP also makes sure there is enough connectivity to reach portion of network by spanning the entire LAN
 *
 */
public class EagerPrimsAlgo {
	
	private List<Vertex> vertexList;
	private PriorityQueue<Vertex> vertexHeap;
	
	public EagerPrimsAlgo(Graph graph) {
		this.vertexList = graph.getVertexList();
		this.vertexHeap = new PriorityQueue<>();
	}
	
	public void spanningTree() {
		for(Vertex v:this.vertexList) {
			if(!v.isVisited()) {
				greedyPrims(v);
			}
		}
		show();
	}
	
	public void greedyPrims(Vertex vertex) {
		vertex.setDistance(0);
		vertexHeap.add(vertex);
		
		while(!vertexHeap.isEmpty()) {
			Vertex v = vertexHeap.remove();
			scanVertex(v);
		}
	}

	private void scanVertex(Vertex v) {
		v.setVisited(true);
		for(Edge e : v.getAdjacencies()) {
			Vertex w = e.getTargetVertex();
			if(w.isVisited())continue;
			if(e.getWeight()<w.getDistance()) {
				w.setDistance(e.getWeight());
				w.setMinEdge(e);
				
				if(this.vertexHeap.contains(w)) {
					this.vertexHeap.remove(w);
				}
				this.vertexHeap.add(w);
				
			}	
		}
	}
	
	private void show() {
		for(Vertex vertex : this.vertexList) {
			if(vertex.getMinEdge()!=null) {
				Edge e = vertex.getMinEdge();
				System.out.println(e.getSourceVertex().getName() + " - " + e.getTargetVertex().getName());
			}
		}
		
	}

}
