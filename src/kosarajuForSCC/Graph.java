package kosarajuForSCC;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private List<Vertex> vertexList;
	private List<Edge> edgeList;
	public Graph(List<Vertex> vertexList, List<Edge> edgeList) {
		super();
		this.vertexList = vertexList;
		this.edgeList = edgeList;
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
	
	public Graph getTransposedGraph() {
		List<Vertex> transposedVertexList = new ArrayList<>();
		for(Vertex v: this.vertexList) {
			transposedVertexList.add(v);
		}
		for(Edge e: this.edgeList) {
			transposedVertexList.get(transposedVertexList.indexOf(e.getTargetVertex())).addNeighbour(e.getSourceVertex());
		}
		Graph transposedGraph = new Graph(transposedVertexList, edgeList);
		//transposedGraph.setVertexList(transposedVertexList);
		
		return transposedGraph;
	}

}
