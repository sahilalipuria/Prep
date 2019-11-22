/**
 * 
 */
package dijikstraAlgo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author salipuri
 *
 *	It can handle only positive weights
 *	Variants : shortest path in the graph, between nodes.
 *	It is asymptotically the fastest known single source shortest path algo
 *	Time Complexity: O(VlogV +E)
 *	It is greedy one as it tries to find global optimum with local minimum
 *	On every iteration we try to find the minimum distance to next possible vertex
 *	So possible data structures: Heaps(binary or fibonacci) or Priority Queues
 *
 *	Steps:
 *	1.) Initialize source with distance 0 and others with infinity from source.
 *	2.) Then decide from source after comparing the current and from source.
 *	3.) If minimum then update distance and predecessor and add in queue like BFS.
 *
 */
public class DijikstraAlgo {

	public void computePath(Vertex sourceVertex) {                                                                                                                                      
		
		sourceVertex.setDistance(0.0);
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(sourceVertex);
		
		while(!priorityQueue.isEmpty()) {
			Vertex actualVertex = priorityQueue.poll();
			
			for(Edge edge : actualVertex.getAdjacenciesList()) {
				Vertex v = edge.getDestinationVertex();
				if(v.getDistance()>(actualVertex.getDistance()+edge.getWeight())) {
					priorityQueue.remove(v);
					v.setDistance(actualVertex.getDistance()+edge.getWeight());
					v.setPredecessor(actualVertex);
					priorityQueue.add(v);
				}
			}
			
		}
	}
	
	public List<Vertex> getShortestPath(Vertex targetVertex){
		List <Vertex> shortestPathToTarget = new ArrayList<>();
		for(Vertex vertex=targetVertex;vertex!=null;vertex=vertex.getPredecessor()) {
			shortestPathToTarget.add(vertex);
		}
		Collections.reverse(shortestPathToTarget);
		return shortestPathToTarget;
	}
}
