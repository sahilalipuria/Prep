/**
 * 
 */
package binarySearchTree;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author salipuri
 *
 */

public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	      }

public class BinaryTreeCameras {
	

	public int minCameraCover(TreeNode root) {
        if(root==null) return 0;
        int numOfCameras=0;
        int levels = 1;
        int currentStackSize = 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        HashMap<Integer,Integer> levelNodes= new HashMap<>();
        
        nodeStack.push(root);
        TreeNode currentNode = null;
        while(!nodeStack.isEmpty()) {
        	currentStackSize = nodeStack.size();
        	levelNodes.put(levels, currentStackSize);
        	while(currentStackSize!=0) {
        		currentNode = nodeStack.pop();
        		currentStackSize--;
        		if(currentNode.left!=null)
            		nodeStack.push(currentNode.left);
        		if(currentNode.right!=null)
        			nodeStack.push(currentNode.right);
        	}
        	levels++; 	
        }
        if(levels<2)
        	numOfCameras = 1;
        else {
        	for(int i=1;i<=levels;i++) {
            	if(i%3==0)
            		numOfCameras += levelNodes.get(i-1);
            }
        	if(levels%3==2) {
        		numOfCameras += levelNodes.get(levels-1);
        	}else if(levels%3== 1)
        		numOfCameras += levelNodes.get(levels);
        }
        
        return numOfCameras;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
