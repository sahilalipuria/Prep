package cycleDetection;

import java.util.List;

public class CycleDetection {

	public void detectCycle(List<Vertex> vertexList) {
		
		for(Vertex vertex: vertexList) {
			if(!vertex.isVisited())
				dfs(vertex);
		}
	}
	
	public void dfs(Vertex vertex) {
		
		System.out.println("DFS on vertex: " + vertex);
		
		vertex.setBeingVisited(true);
		vertex.setVisited(false);
		
		for(Vertex v: vertex.getNeighbourList()) {
			System.out.println("Visting vertex : " + v);
			if(v.isBeingVisited()){
				System.out.println("Backward edge.......so cycle found");
				return;
			}
			if(!v.isVisited()) {
				v.setVisited(true);
				dfs(v);
			}
		}
		System.out.println("DFS on vertex: " + vertex);
		vertex.setVisited(true);
		vertex.setBeingVisited(false);
	}
}
