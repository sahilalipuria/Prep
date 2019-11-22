/**
 * 
 */
package kosarajuForSCC;

/**
 * @author salipuri
 * 
 * 	Connected graph => a graph is connected if all of its vertices are connected.
 * 	A graph is strongly connected if we can get from one vertex to the other(undirected graphs are SCC by defination)
 * 	In directed graph there are vertices which cant be reached from everywhere
 * 	These clusters can be discovered by DFS
 * 	Running time: O(V)
 * 	If we shrink each component to a vertex these vertices form a DAG, it is known as "condensation" of a graph
 * 	So a directed graph is DAG only if there is no subgraph
 * 	A directed graph is strongly connected
 * 	Every non trivial SCC contains at least one directed cycle
 * 	Tarjan algo uses only one DFS so it is more popular.
 * 
 * 	APPLICATIONS:
 * 		-Ecology: to determine the hierarchy of food need
 * 		-Software Engineering: if we have huge s/w & we want to create packages to each connected classes
 * 								we can classify them according to SCC. Like maven: grouping SCC in one package.
 * 		-Astrophysics: if we have an image of faint stars & want to detect each one of them....good way to find clusters
 * 		-Recommender system: for eg: youtube , facebook. We recommend another item of SCC.
 * 
 * 	Kosaraju algo does 2 DFS: one to get topological ordering & then on transposed graph to discover SCC.
 * 	We have to use stack for DFS traversal because we have to track the finishing times
 * 	We need to track whether we have already visited a given node or not
 * 	STEPS:
 * 	Do a DFS on the original graph and keep pushing the nodes to stack
 * 	Transpose the graph and reverse the edges
 * 	keep popping the nodes from stack,keep constructing the strongly connected components.
 *
 */
public class KosarajuAlgo {
	
	private int[] id;		//id[v] = id of SCC containing v
	private boolean[] marked;
	private int count;
	
	public KosarajuAlgo(Graph graph) {
		
		DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph.getTransposedGraph());		//Topological Ordering of Transposed Graph
		
		marked = new boolean[graph.getVertexList().size()];
		id = new int[graph.getVertexList().size()];
		
		for(Vertex vertex : depthFirstOrder.getReversePost()) {				//Do dfs on stack containing the Topological Ordering of Transposed Graph
			if(!marked[vertex.getId()]) {
				dfs(vertex);
				count++;
			}
		}
	}

	public void dfs(Vertex vertex) {
		marked[vertex.getId()] = true;
		id[vertex.getId()] = count;
		vertex.setComponentId(count);
		for(Vertex v: vertex.getAdjacencies()) {
			if(!marked[v.getId()]) {
				dfs(v);
			}
		}
	}

	public int getCount() {
		return count;
	}

}
