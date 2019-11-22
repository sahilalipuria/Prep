/**
 * 
 */
package arbitrageDetection;

import java.util.List;

/**
 * @author salipuri
 *
 *	
 *	Table of exchange rates and it contains relative values
 *	The vertexes will be the currencies
 *	The edges will be the relationship between the currencies thats in the currency table
 *	First we have to take natural logarithmic of the currencies
 *	We have to multiply every edge with -1
 *	We end up with a directed negative weighted graph where we are looking for negative cycles
 *	Bellman ford can solve this problem
 */
public class BellmanFord {
	
	private List<Vertex> vertexList;
	private List<Edge> edgeList;
	private List<Vertex> cycleList;
	public BellmanFord(List<Vertex> vertexList, List<Edge> edgeList) {	
		this.vertexList = vertexList;
		this.edgeList = edgeList;
	}
	
	public void bellmanFordAlgo(Vertex sourceVertex) {
		
		sourceVertex.setDistance(0.0);
		
		for(int i=0;i<vertexList.size()-1;i++) {		//V-1 iteration
			for(Edge e: edgeList) {
				Vertex u = e.getSourceVertex();
				Vertex v = e.getDestinationVertex();
				
				if(u.getDistance()==Integer.MAX_VALUE)continue;
				
				Double newDistance = u.getDistance() + e.getDistance();
				
				if(newDistance< v.getDistance()) {
					v.setDistance(newDistance);
					v.setPredecessor(u);
				}
			}
		}
		
		for(Edge e: edgeList) {							//Vth Iteration
			if(e.getSourceVertex().getDistance() != Integer.MAX_VALUE) {
				if(hasCycle(e)) {	
					Vertex vertex = e.getSourceVertex();
					while(!vertex.equals(e.getDestinationVertex())) {
						this.cycleList.add(vertex);
						vertex = vertex.getPredecessor();
					}
					
					this.cycleList.add(e.getDestinationVertex());
					return;
				}
			}
		}
	}
	
	public boolean hasCycle(Edge e) {
		return e.getDestinationVertex().getDistance()>e.getSourceVertex().getDistance()+e.getDistance();
	}
	
	public void printCycle() {
		if(this.cycleList != null) {
			System.out.println("Arbitrage opportunity detected!!!");
			for(Vertex v: this.cycleList) {
				System.out.println(v);
			}
		}
		else {
			System.out.println("No arbitrage opportunity........");
		}
		
	}
	
	

}
