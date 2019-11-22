package eagerPrimsForMST;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph graph = new Graph();
		
		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		Vertex vertexD = new Vertex("D");
		Vertex vertexE = new Vertex("E");
		Vertex vertexF = new Vertex("F");
		Vertex vertexG = new Vertex("G");
		
		graph.addVertex(vertexA);
		graph.addVertex(vertexB);
		graph.addVertex(vertexC);
		graph.addVertex(vertexD);
		graph.addVertex(vertexE);
		graph.addVertex(vertexF);
		graph.addVertex(vertexG);
		
		graph.addEdge(new Edge(7.0, vertexA, vertexB));
		graph.addEdge(new Edge(5.0, vertexA, vertexD));
		graph.addEdge(new Edge(9.0, vertexD, vertexB));
		graph.addEdge(new Edge(15.0, vertexD, vertexE));
		graph.addEdge(new Edge(6.0, vertexD, vertexF));
		graph.addEdge(new Edge(7.0, vertexB, vertexE));
		graph.addEdge(new Edge(8.0, vertexB, vertexC));
		graph.addEdge(new Edge(5.0, vertexC, vertexE));
		graph.addEdge(new Edge(8.0, vertexF, vertexE));
		graph.addEdge(new Edge(11.0, vertexF, vertexG));
		graph.addEdge(new Edge(9.0, vertexE, vertexG));
		
		EagerPrimsAlgo eagerPrimsAlgo = new EagerPrimsAlgo(graph);
		eagerPrimsAlgo.spanningTree();

	}

}
