package TopologicalSorting;

import java.util.Stack;

public class TopologicalSorting {

	private Stack<Vertex> stack;
	
	public TopologicalSorting() {
		this.stack = new Stack<>();
	}
	
	public void dfs(Vertex vertex) {
		
		vertex.setVisited(true);

		for(Vertex v: vertex.getNeighbourList()) {
			if(!v.isVisited()) {
				dfs(v);
			}
		}
		
		stack.push(vertex);
	}
	
	public Stack<Vertex> getStack(){
		return this.stack;
	}
}
