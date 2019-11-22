package arbitrageDetection;

import java.util.ArrayList;
import java.util.List;


public class Vertex {
	
	private String id;
	private Double distance = Double.MAX_VALUE;
	private boolean visited;
	private List<Edge> adjacencies;
	private Vertex predecessor;
	public Vertex(String id) {
		this.id = id;
		this.adjacencies = new ArrayList<>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public List<Edge> getAdjacencies() {
		return adjacencies;
	}
	public void setAdjacencies(List<Edge> adjacencies) {
		this.adjacencies = adjacencies;
	}
	public Vertex getPredecessor() {
		return predecessor;
	}
	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}
	public void addNeighbour(Edge e) {
		this.adjacencies.add(e);
	}
	@Override
	public String toString() {
		return ""+this.id;
	}
}
