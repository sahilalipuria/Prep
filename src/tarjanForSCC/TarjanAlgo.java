/**
 * 
 */
package tarjanForSCC;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author salipuri
 * 
 * A directed graph is strongly connected if there is a path between all pairs of vertices. 
 * A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph
 * 
 * Tarjan Algorithm is based on following facts:
1. DFS search produces a DFS tree/forest
2. Strongly Connected Components form subtrees of the DFS tree.
3. If we can find the head of such subtrees, we can print/store all the nodes in that subtree (including head) and that will be one SCC.
4. There is no back edge from one SCC to another (There can be cross edges, but cross edges will not be used while processing the graph).

To find head of a SCC, we calculate disc and low array (as done for articulation point, bridge, biconnected component). 
As discussed in the previous posts, low[u] indicates earliest visited vertex (the vertex with minimum discovery time) that can be reached from subtree rooted with u. 
A node u is head if disc[u] = low[u].
 * 
 * 	We will consider forward,backward and cross edges
 * 	It runs in linear time
 * 	Stack invariant:
 * 		-When DFS recursively visits a node v and its descendants-> those nodes are not necessarily popped 
 * 		from stack when recursive calls return
 * 		-A node remains on stack after it has been visited -> if there exists a path in the graph from
 * 		this node to some other node earlier on the stack
 * 		- So at the end of the call that visits V:
 * 			- we know either V itself has a path to any node earlier on the stack
 * 				YES: v has a path to any node earlier on the stack. 
 * 					The call returns -> V stays on the stack!!!!
 * 				NO: V doesn't have path to any node earlier on stack and it must be the root of its SCC!!!
 * 
 * 
 * 		Every node has two properties : index + lowlink
 * 			INDEX: we assign an integer to the nodes consecutively in the order they are visited by DFS.
 * 			LOWLINK: the smallest index of any node known to be reachable from node v
 * 
 * 			v.lowlink=v.index
 * 			There is no backward edge to any other node . The current node is the root of SCC
 * 			
 * 			v.lowlink<v.index
 * 			We have found a backward edge
 *
 */
public class TarjanAlgo {
	
	private Stack<Vertex> stack;
	private List<Vertex> vertexList;
	private List<List<Vertex>> connectedComponentList;
	private int time = 0;
	private int count;
	public TarjanAlgo(List<Vertex> vertexList) {
		super();
		this.vertexList = vertexList;
		this.stack = new Stack<>();
		this.connectedComponentList = new ArrayList<>();
	}
	
	public void runAlgo() {
		for(Vertex vertex: vertexList) {
			if(!vertex.isVisited()) {
				dfs(vertex);
			}
		}
	}

	public void dfs(Vertex vertex) {
		vertex.setVisited(true);
		vertex.setLowLink(time++);
		System.out.println("Visiting vertex: "+ vertex.getName()+" with lowlink: "+vertex.getLowLink());
		this.stack.add(vertex);
		boolean isComponentRoot = true;
		
		for(Vertex v: vertex.getNeighbourList()) {
			
			if(!v.isVisited()) {
				System.out.println("Recursively visit: "+v.getName());
				dfs(v);
			}
			
			if(vertex.getLowLink()>v.getLowLink()) {
				System.out.println("Coz vertex "+vertex.getName()+" lowlink(value: "+vertex.getLowLink()+")>vertex "+v.getName() +" lowlink(value: "+v.getLowLink()+")");
				vertex.setLowLink(v.getLowLink());
				System.out.println("So vertex "+vertex.getName()+" is not the root of a SCC");
				isComponentRoot = false;
			}
			if(isComponentRoot) {
				count++;
				System.out.println("Vertex "+vertex.getName()+" is the root of a SCC");
				List<Vertex> component = new ArrayList<>();
				while(true) {
					Vertex actualVertex = this.stack.pop();
					System.out.println("So vertex "+actualVertex.getName()+" is in count: "+count);
					component.add(actualVertex);
					actualVertex.setLowLink(Integer.MAX_VALUE);
					if(actualVertex.getName().equals(vertex.getName())) {
						break;
					}
				}
				connectedComponentList.add(component);
			}
		}
		
	}
	
	public void printComponents() {
		System.out.println(connectedComponentList);
	}
	

}
