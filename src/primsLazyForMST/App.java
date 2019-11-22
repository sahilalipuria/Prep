package primsLazyForMST;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Vertex> vertexList = new ArrayList<>();
		
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);
		
		v1.addEdge(new Edge(1.0, v1, v2));
		v1.addEdge(new Edge(1.0, v1, v3));
		v1.addEdge(new Edge(10.0, v2, v3));
		
		v2.addEdge(new Edge(1.0, v2, v1));
		v3.addEdge(new Edge(1.0, v3, v1));
		v3.addEdge(new Edge(10.0, v3, v2));
		
		PrimsAlgo primsAlgo = new PrimsAlgo(vertexList);
		primsAlgo.PrimsAlgo(v3);
		primsAlgo.showMST();

	}

}
