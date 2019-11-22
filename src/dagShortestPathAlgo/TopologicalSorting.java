package dagShortestPathAlgo;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TopologicalSorting {

	private Stack<Vertex> stack;

	public TopologicalSorting() {
		this.stack = new Stack<>();
	}

	public Stack<Vertex> getStack() {
		return stack;
	}

	public void setStack(Stack<Vertex> stack) {
		Collections.reverse(stack);
		this.stack = stack;
	}
	
	public void makeTopologicalOrder(List<Vertex> vertexList) {
		for(Vertex vertex : vertexList) {
			if(!vertex.isVisited())
				dfs(vertex);
		}
	}
	
	public void dfs(Vertex vertex) {
		
		for(Edge e: vertex.getAdjacencies()) {
			if(!e.getDestinationVertex().isVisited()) {
				e.getDestinationVertex().setVisited(true);
				dfs(e.getDestinationVertex());
			}
		}
		this.stack.push(vertex);
	}
	
	
	
	
}
