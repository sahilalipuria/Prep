/**
 * 
 */
package fordFulkersonForMaxFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author salipuri
 *
 */
public class FlowNetwork {
	
	private int numberOfVertices;
	private int numberOfEdges;
	private List<List<Edge>> adjacencieList;
	public FlowNetwork(int numberOfVertices) {
		super();
		this.numberOfVertices = numberOfVertices;
		this.numberOfEdges = 0;
		this.adjacencieList = new ArrayList<>();
		
		for(int i=0;i<numberOfVertices;i++) {
			List<Edge> edgeList = new ArrayList<>();
			adjacencieList.add(edgeList);
		}
	}
	public int getNumberOfVertices() {
		return numberOfVertices;
	}
	public void setNumberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}
	public int getNumberOfEdges() {
		return numberOfEdges;
	}
	public void setNumberOfEdges(int numberOfEdges) {
		this.numberOfEdges = numberOfEdges;
	}
	public List<Edge> getAdjacencieList(Vertex v) {
		return adjacencieList.get(v.getId());
	}
	public void setAdjacencieList(List<List<Edge>> adjacencieList) {
		this.adjacencieList = adjacencieList;
	}
	public void addEdge(Edge e) {
		Vertex v = e.getFromVertex();
		Vertex w = e.getTargetVertex();
		
		adjacencieList.get(v.getId()).add(e);
		adjacencieList.get(w.getId()).add(e);
		this.numberOfEdges++;
	}
	

}
