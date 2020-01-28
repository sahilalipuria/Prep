/**
 * 
 */
package bellmanFordAlgo;

import java.util.List;

/**
 * @author salipuri
 *
 *	It is slower than Dijikstra but its more robust as it handle +ve -ve weights too
 *	Dijikstra chooses edges greedily whereas here we relax all edges at same time for V-1 iteration
 *	Running Time : O(V*E)
 *	Does (V-1)+1 iterations to detect cycles
 *	If cost decreases in (V-1)+1th iteration then there is negative cycle
 *	as all the paths are travered and already shortened in V-1 iterations
 *
 *	YEN OPTIMIZATION (1970):
 *		it is Bellman Ford algo with some optimization
 *		We can terminate the algo if there is no change in the distances between 2 iterations
 *		We use same technique in bubble sort
 *
 *	Cycle detection application can prove to be very important
 *	Negative cycles too - we have to run the Bellman Ford algo that can handle negative edge weights by default
 *	On Forex market it can detect arbitrage situations
 *
 */
public class BellmanFordAlgo {
	
	private List<Vertex> vertexList;
	private List<Edge> edgeList;
	
	public BellmanFordAlgo(List<Edge> edgeList,List<Vertex> vertexList) {
		this.vertexList = vertexList;
		this.edgeList = edgeList;
	}
	
	public void bellmanFord(Vertex sourceVertex) {
		sourceVertex.setDistance(0);
		
		for(int i=0;i<vertexList.size()-1;i++) {			//V-1 iterations and we relax all the edges.	
			for(Edge e : edgeList) {
				Vertex u = e.getSourceVertex();
				Vertex v = e.getTargetVertex();
				
				if(u.getDistance()==Double.MAX_VALUE)
					continue;
				
				int newDistance = u.getDistance()+e.getWeight();
				if(newDistance<v.getDistance()) {
					v.setDistance(newDistance);
					v.setPredecessor(u);
					System.out.println(v.getName() +"'s new distance is: "+ newDistance);
				}
			}
		}
		
		//Vth iteration to check for cycle
		for(Edge e: edgeList) {
			Vertex u = e.getSourceVertex();
			Vertex v = e.getTargetVertex();
			if(e.getSourceVertex().getDistance()!=Double.MAX_VALUE) {
				if((u.getDistance()+e.getWeight())<v.getDistance()) {
					System.out.println("CYCLE DETECTED");
					return;
				}
			}
		}
	}
	
	public void shortestPathToVertex(Vertex vertex) {
		if(vertex.getDistance()!=Integer.MAX_VALUE) {
			System.out.println("THERE IS PATH FROM SOURCE TO TARGET with cost: " + vertex.getDistance());
		
			Vertex actualVertex = vertex;
			System.out.print(actualVertex.getName() + " - ");
			while(actualVertex.getPredecessor()!=null) {
				actualVertex = actualVertex.getPredecessor();
				System.out.print(actualVertex.getName() + " - ");
			}
		}
		else {
			System.out.println("There is no path from source to vertex");
		}
	}
	

}
