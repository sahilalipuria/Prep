/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author salipuri
 * 
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 
 Note:

1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].
 *
 */
public class PossibleBipartition {
	
	private static Map<Integer, List<Integer>> graph;
    private static int[] visited;
    
    public static boolean possibleBipartition(int N, int[][] dislikes) {
        if(N == 0 || dislikes.length == 0) return true;
        graph = new HashMap<>();
        for(int[] dislike : dislikes){
            List<Integer> temp = graph.containsKey(dislike[0]) ? graph.get(dislike[0]): new ArrayList<>();
            temp.add(dislike[1]);
            graph.put(dislike[0], temp);
            temp = graph.containsKey(dislike[1]) ? graph.get(dislike[1]): new ArrayList<>();
            temp.add(dislike[0]);
            graph.put(dislike[1], temp);
        }
        visited = new int[N + 1];
        for(int i = 0; i < N; i++){
            if(visited[i] == 0){
                if(!dfs(i, 1)) return false;
            }
        }
        return true;
    }
    private static boolean dfs(int node, int color){
        if(visited[node] != 0 && visited[node] != color) return false;
        if(visited[node] == color) return true;
        visited[node] = color;
        List<Integer> neighbours = graph.get(node);
        if(neighbours == null) return true;
        for(Integer neighbour : neighbours){
            if(!dfs(neighbour, -color)) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(possibleBipartition(4,new int[][] {{1,2},{1,3},{2,4}}));
	}

}
