package cycleDetection;

import java.util.ArrayList;
import java.util.List;

public class Vertex{

	private String name;
	private boolean visited;
	private boolean beingVisited;
	private List<Vertex> neighbourList;
	
	public Vertex(String name) {
		this.name = name;
		this.neighbourList = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public boolean isBeingVisited() {
		return beingVisited;
	}
	public void setBeingVisited(boolean beingVisited) {
		this.beingVisited = beingVisited;
	}
	public List<Vertex> getNeighbourList() {
		return neighbourList;
	}
	public void setNeighbourList(List<Vertex> neighbourList) {
		this.neighbourList = neighbourList;
	}
	public void addNeighbour(Vertex v) {
		this.neighbourList.add(v);
	}
	@Override
	public String toString() {
		return this.name;
	}
	
	
}
