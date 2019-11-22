package dagShortestPathAlgo;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	private Vertex predecessor;
	private Double distance = Double.MAX_VALUE;
	private List<Edge> adjacencies;
	private boolean visited;
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

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

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public List<Edge> getAdjacencies() {
		return adjacencies;
	}

	public void setAdjacencies(List<Edge> adjacencies) {
		this.adjacencies = adjacencies;
	}
	public void addNeighbour(Edge e) {
		this.adjacencies.add(e);
	}
	@Override
	public String toString() {
		return this.name;
	}
}
