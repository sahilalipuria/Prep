package kruskalForMST;

import java.util.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(new Vertex("A"));
		vertexList.add(new Vertex("B"));
		vertexList.add(new Vertex("C"));
		vertexList.add(new Vertex("D"));
		vertexList.add(new Vertex("E"));
		vertexList.add(new Vertex("F"));
		vertexList.add(new Vertex("G"));
		vertexList.add(new Vertex("H"));
		
		List<Edge> edgeList = new ArrayList<>();
		edgeList.add(new Edge(3.0, vertexList.get(0), vertexList.get(1)));
		edgeList.add(new Edge(2.0, vertexList.get(0), vertexList.get(2)));
		edgeList.add(new Edge(5.0, vertexList.get(0), vertexList.get(3)));
		edgeList.add(new Edge(13.0, vertexList.get(1), vertexList.get(5)));
		edgeList.add(new Edge(2.0, vertexList.get(1), vertexList.get(3)));
		edgeList.add(new Edge(5.0, vertexList.get(2), vertexList.get(4)));
		edgeList.add(new Edge(2.0, vertexList.get(2), vertexList.get(3)));
		edgeList.add(new Edge(4.0, vertexList.get(3), vertexList.get(4)));
		edgeList.add(new Edge(6.0, vertexList.get(3), vertexList.get(5)));
		edgeList.add(new Edge(3.0, vertexList.get(3), vertexList.get(6)));
		edgeList.add(new Edge(6.0, vertexList.get(4), vertexList.get(6)));
		edgeList.add(new Edge(2.0, vertexList.get(5), vertexList.get(6)));
		edgeList.add(new Edge(3.0, vertexList.get(5), vertexList.get(7)));
		edgeList.add(new Edge(6.0, vertexList.get(6), vertexList.get(7)));
		
		KruskalAlgo kruskalAlgo = new KruskalAlgo();
		kruskalAlgo.spanningTree(vertexList, edgeList);

	}

}
