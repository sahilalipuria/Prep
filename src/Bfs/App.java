package Bfs;

public class App {

	public static void main(String[] args) {
		BFS g = new BFS();

	    Vertex v1 = new Vertex(1);
	    Vertex v2 = new Vertex(2);
	    Vertex v3 = new Vertex(3);
	    Vertex v4 = new Vertex(4);
	    Vertex v5 = new Vertex(5);
	    Vertex v6 = new Vertex(6);
	    
	    v1.addNeighbour(v2);
	    v1.addNeighbour(v4);
	    v4.addNeighbour(v5);
	    v2.addNeighbour(v3);
	    v3.addNeighbour(v6);
	    

	     g.bfs(v1);

	}

}