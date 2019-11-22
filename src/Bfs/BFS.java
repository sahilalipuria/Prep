package Bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	public void bfs(Vertex root) {
		
		//Memory complexity is O(n) as we have to store all nodes one by one
		
		Queue<Vertex> queue = new LinkedList<>();
		root.setVisited(true);
		queue.add(root);
		
		System.out.println("BFS:");
		while(!queue.isEmpty()) {
			Vertex actualVertex = queue.remove();
			System.out.println(actualVertex.getData());
			
			for(Vertex v: actualVertex.getNeighbourList()) {
				if(!v.isVisited()) {
					v.setVisited(true);
					queue.add(v);
				}
			}
		}
	}
}
