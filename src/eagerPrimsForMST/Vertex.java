package eagerPrimsForMST;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
	
	private String name;
	private Vertex predecessor;
	private List<Edge> adjacencies;
	private double distance = Double.POSITIVE_INFINITY;		//to check whether heap needs to be updated or not
	private Edge minEdge;							//shortest edge to actual MST from a non-MST vertex
	private boolean visited;
	public Vertex(String name) {
		super();
		this.name = name;
		this.adjacencies = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vertex getPredecessor() {
		return predecessor;
	}
	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}
	public List<Edge> getAdjacencies() {
		return adjacencies;
	}
	public void setAdjacencies(List<Edge> adjacencies) {
		this.adjacencies = adjacencies;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public Edge getMinEdge() {
		return minEdge;
	}
	public void setMinEdge(Edge minEdge) {
		this.minEdge = minEdge;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public void addEdge(Edge e) {
		this.adjacencies.add(e);
	}
	@Override
	public int compareTo(Vertex v) {
		return Double.compare(this.distance, v.getDistance());
	}
}
