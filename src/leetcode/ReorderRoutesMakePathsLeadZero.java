/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author salipuri
 * 
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 * 
 * There are n cities numbered from 0 to n-1 and n-1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [a, b] represents a road from city a to b.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach the city 0 after reorder.

Example 1:
Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 2:
Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 3:
Input: n = 3, connections = [[1,0],[2,0]]
Output: 0
 

Constraints:

2 <= n <= 5 * 10^4
connections.length == n-1
connections[i].length == 2
0 <= connections[i][0], connections[i][1] <= n-1
connections[i][0] != connections[i][1]	
 *
 */
public class ReorderRoutesMakePathsLeadZero {

	/**
	 * @param args
	 */
	
	public static int minReorder(int n, int[][] cs) {
        HashSet<String> st = new HashSet<>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] c : cs) {
            st.add(c[0] + "," + c[1]);
            map.computeIfAbsent(c[0], k -> new HashSet<>());
            map.computeIfAbsent(c[1], k -> new HashSet<>());
            map.get(c[0]).add(c[1]);
            map.get(c[1]).add(c[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int res = 0;
        boolean[] vs = new boolean[n];
        vs[0] = true;
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int next : map.getOrDefault(c, new HashSet<>())) {
                if (vs[next]) continue;
                vs[next] = true;
                if (!st.contains(next + "," + c)) res++;
                q.offer(next);
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(minReorder(6, new int[][] {{0,1},{1,3},{2,3},{4,0},{4,5}}));
	}

}
