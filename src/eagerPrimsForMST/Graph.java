package eagerPrimsForMST;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	public List<Vertex> vertexList;
	public List<Edge> edgeList;
	public Graph() {
		this.vertexList = new ArrayList<>();
		this.edgeList = new ArrayList<>();
	}
	public List<Vertex> getVertexList() {
		return vertexList;
	}
	public void setVertexList(List<Vertex> vertexList) {
		this.vertexList = vertexList;
	}
	public List<Edge> getEdgeList() {
		return edgeList;
	}
	public void setEdgeList(List<Edge> edgeList) {
		this.edgeList = edgeList;
	}
	public void addVertex(Vertex v) {
		this.vertexList.add(v);
	}
	public void addEdge(Edge e) {
		Vertex u = e.getSourceVertex();
		Vertex v = e.getTargetVertex();
		
		this.vertexList.get(vertexList.indexOf(u)).addEdge(new Edge(e.getWeight(), u, v));
		this.vertexList.get(vertexList.indexOf(v)).addEdge(new Edge(e.getWeight(), v, u));
	}

}
