/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author salipuri
 * 
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 

Note:

1 <= N <= 1000
trust.length <= 10000
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N
 *
 */
public class FindTheTownJudge {

	/**
	 * @param args
	 */
	
	public static int findJudge(int N, int[][] trust) {
        HashSet<Integer> pplSet = new HashSet<>();
        HashMap<Integer, List<Integer>> trustMap = new HashMap<Integer, List<Integer>>();
        int result;
        
        for(int i=1;i<=N;i++) {
        	pplSet.add(i);
        }
        
        for(int i=0;i<trust.length;i++) {
        	if(!trustMap.containsKey(trust[i][0])) {
        		trustMap.put(trust[i][0], new ArrayList<>(Arrays.asList(trust[i][1])));
        	}else
        	{
        		List<Integer> tempList = new ArrayList<>(trustMap.get(trust[i][0]));
        		if(tempList!=null) {
        			tempList.add(trust[i][1]);
        			trustMap.put(trust[i][0], tempList);
        		}
        	}
        	pplSet.remove(trust[i][0]);
        }
        
        if(pplSet.isEmpty() || pplSet.size()>1)
        	return -1;
        
        result = pplSet.iterator().next();
        for(Map.Entry<Integer, List<Integer>> entry: trustMap.entrySet()) {
        	if(entry.getKey() == result)
        		continue;
        	
        	if(!entry.getValue().contains(result))
        		return -1;
        }
        
        return result;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findJudge(3, new int[][] {{1,2},{2,3}}));
		System.out.println(findJudge(3, new int[][] {{1,3},{2,3}}));
		System.out.println(findJudge(3, new int[][] {{1,3},{2,3},{3,1}}));
	}

}
