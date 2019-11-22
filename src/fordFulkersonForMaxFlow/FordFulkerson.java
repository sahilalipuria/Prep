/**
 * 
 */
package fordFulkersonForMaxFlow;

/**
 * @author salipuri
 *
 */
public class FordFulkerson {
	
	private boolean[] marked;				//marked[v.getId()] = true 	s->v in residual graph
	private Edge[] edgeTo;					//marked[v] = true
	private double valueMaxFlow;			//edgeTo[v] = edges in augmenting path
	
	public FordFulkerson(FlowNetwork flowNetwork,Vertex s,Vertex t) {
		
		while(hasAugmentingPath(flowNetwork,s,t)) {
			
		}
	}

}
