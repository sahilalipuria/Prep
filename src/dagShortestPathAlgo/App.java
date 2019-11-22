package dagShortestPathAlgo;

import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String[] args) {
		
		List<Vertex> vertexList = new ArrayList<>();
		
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);
		
		v1.addNeighbour(new Edge(1.0, v1, v2));
		v1.addNeighbour(new Edge(1.0, v1, v3));
		v2.addNeighbour(new Edge(1.0, v2, v3));
		
		DagShortesPathAlgo dagShortestPath = new DagShortesPathAlgo();
		dagShortestPath.shortestPath(vertexList, v1, v3);
		dagShortestPath.showShortestPath(v3);
	}

}
