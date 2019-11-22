/**
 * 
 */
package kruskalForMST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author salipuri
 * 
 * 	A spanning tree of an undirected graph is a subgraph which includes all the vertices of G
 * 	In general, a tree may have many spanning trees
 * 	A minimum spanning tree is then a spanning tree with weight less than or equal to every other spanning tree
 * 	Applications : in big data analysis,clustering algos,finding min cost for telcom company laying cable to new neighbourhood
 * 
 * 	KRUSKAL's ALGO:
 * 		- sort edges according to their weights
 * 		- it can be done in O(NlogN) with merge-sort or quick-sort
 * 		- union-find data structure ->disjoint sets
 * 		STEPS:
 * 		- We start adding edges to MST & in parallel making sure that we don't form cycles in spanning tree
 * 		- Can be done in O(log V) with the help of union-find data structure
 * 		- Can be done using heap instead of sorting the edges but runtime will be the same
 * 		- so sometimes its implemented with priority queues
 * 		- Worst case runtime : O(ElogE) so we can use huge graphs too
 * 		- If edges are sorted then algorithm is quasi-linear
 *
 */
public class KruskalAlgo {
	
	public void spanningTree(List<Vertex> vertexList,List<Edge> edgeList) {
		
		DisjointSet disjointSet = new DisjointSet(vertexList);
		List<Edge> mst = new ArrayList<>();
		Collections.sort(edgeList);
		for(Edge edge:edgeList) {
			Vertex u = edge.getSourceVertex();
			Vertex v = edge.getTargetVertex();
			
			if(disjointSet.find(u.getNode())!=disjointSet.find(v.getNode())) {
				mst.add(edge);
				disjointSet.union(u.getNode(), v.getNode());
			}
		}
		
		for(Edge e:mst) {
			System.out.print(e.getSourceVertex().getName()+ "-->" + e.getTargetVertex().getName()+",");
		}
	}

}
