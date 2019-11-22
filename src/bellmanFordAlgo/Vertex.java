package bellmanFordAlgo;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private String name;
	private int distance = Integer.MAX_VALUE;
	private boolean visited;
	private List<Edge> adjacencies;
	private Vertex predecessor;
	public Vertex(String name) {
		this.name = name;
		this.adjacencies = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
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
}
