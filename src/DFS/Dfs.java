package DFS;

import java.util.List;
import java.util.Stack;

public class Dfs {

	private Stack<Vertex> stack;
	
	public Dfs() {
		this.stack = new Stack<>();
	}

	public void dfsWithRecursion(Vertex vertex) {
		
		System.out.println(vertex);
		for(Vertex v : vertex.getNeighbourList()) {
			if(!v.isVisited()) {
				v.setVisited(true);
				dfsWithRecursion(v);
			}
		}
	}
	
	public void dfsWithStack(Vertex vertex) {
		
		this.stack.add(vertex);
		vertex.setVisited(true);
		
		while(!this.stack.isEmpty()) {
			Vertex actualVertex = this.stack.pop();
			System.out.println(actualVertex);
			for(Vertex v: actualVertex.getNeighbourList()) {
				if(!v.isVisited()) {
					v.setVisited(true);
					this.stack.push(v);
				}
			}
		}
	}
	
	public void dfs(List<Vertex> vertexList) {
		
		//Memory complexity is O(logN) as we have to store only branches one by one
		
		for(Vertex v : vertexList) {
			if(!v.isVisited()) {
				dfsWithStack(v);
			}
		}
		for(Vertex v : vertexList) {
			v.setVisited(false);
		}
		for(Vertex v : vertexList) {
			if(!v.isVisited()) {
				v.setVisited(true);
				System.out.println("NOW WITH RECUSION:");
				dfsWithRecursion(v);
			}
		}
	}
}
