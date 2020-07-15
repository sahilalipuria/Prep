/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author salipuri
 * 
 * 1514. Path with Maximum Probability
 * 
 * You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].

Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.

 

Example 1:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
Example 2:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
Output: 0.30000
Example 3:



Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
Output: 0.00000
Explanation: There is no path between 0 and 2.
 

Constraints:

2 <= n <= 10^4
0 <= start, end < n
start != end
0 <= a, b < n
a != b
0 <= succProb.length == edges.length <= 2*10^4
0 <= succProb[i] <= 1
There is at most one edge between every two nodes.


 *
 */



public class PathWithMaxProbability {

	class State {
		int node;
		double prob;
		State(int _node, double _prob) {
			node = _node;
			prob = _prob;
		}
	}
	
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
		// build graph -> double[0]: node, double[1]: parent-to-node prob
		HashMap<Integer, List<double[]>> map = new HashMap<>();
		for (int i = 0; i < edges.length; ++i) {
			int[] edge = edges[i];

			map.putIfAbsent(edge[0], new ArrayList<>());
			map.putIfAbsent(edge[1], new ArrayList<>());

			map.get(edge[0]).add(new double[] {edge[1], succProb[i]});
			map.get(edge[1]).add(new double[] {edge[0], succProb[i]});
		}

		double[] probs = new double[n];  // best prob so far for each node
		PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> (((Double) b.prob).compareTo((Double) a.prob)));
		pq.add(new State(start, 1.0));

		while (!pq.isEmpty()) {

			State state = pq.poll();
			int parent = state.node;
			double prob = state.prob;

			if (parent == end) return prob;

			for (double[] child : map.getOrDefault(parent, new ArrayList<>())) {
				// add to pq only if: it can make a better prob
				if (probs[(int) child[0]] >= prob * child[1]) continue;

				pq.add(new State((int) child[0], prob * child[1]));
				probs[(int) child[0]] = prob * child[1];
			}

		}

		return 0;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
