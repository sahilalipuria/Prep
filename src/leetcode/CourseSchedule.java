/**
 * 
 */
package leetcode;

import java.util.LinkedList;

/**
 * @author salipuri
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
 *
 */
public class CourseSchedule {

	/**
	 * @param args
	 */
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
        throw new IllegalArgumentException("illegal prerequisites array");
    }
 
    int len = prerequisites.length;
 
    if(numCourses == 0 || len == 0){
        return true;
    }
 
    // counter for number of prerequisites
    int[] pCounter = new int[numCourses];
    for(int i=0; i<len; i++){
        pCounter[prerequisites[i][0]]++;
    }
 
    //store courses that have no prerequisites
    LinkedList<Integer> queue = new LinkedList<Integer>();
    for(int i=0; i<numCourses; i++){
        if(pCounter[i]==0){
            queue.add(i);
        }
    }
 
    // number of courses that have no prerequisites
    int numNoPre = queue.size();
 
    while(!queue.isEmpty()){
        int top = queue.remove();
        for(int i=0; i<len; i++){
            // if a course's prerequisite can be satisfied by a course in queue
            if(prerequisites[i][1]==top){
                pCounter[prerequisites[i][0]]--;
                if(pCounter[prerequisites[i][0]]==0){
                    numNoPre++;
                    queue.add(prerequisites[i][0]);
                }
            }
        }
    }
 
    return numNoPre == numCourses;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(canFinish(2, new int[][] {{1,0}}));
	}

}
