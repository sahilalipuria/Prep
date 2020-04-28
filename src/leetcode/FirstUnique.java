/**
 * 
 */
package leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * @author salipuri
 *
 */
public class FirstUnique {

	HashSet<Integer> nonUniqueQueue = new LinkedHashSet();
	HashSet<Integer> uniqueQueue = new LinkedHashSet<>();
	
	public FirstUnique(int[] nums) {
        for(int num: nums) {
        	add(num);
        }
    }
    
    public int showFirstUnique() {
        try {
        	return uniqueQueue.iterator().next();
        }catch(NoSuchElementException e) {
        	return -1;
        }
    }
    
    public void add(int value) {
    	System.out.println("Adding "+value);
    	if(nonUniqueQueue.contains(value))return;
    	if(uniqueQueue.contains(value)) {
    		uniqueQueue.remove(value);
    		nonUniqueQueue.add(value);
    		return;
    	}
    	
    	uniqueQueue.add(value);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Your FirstUnique object will be instantiated and called as such:
		 * FirstUnique obj = new FirstUnique(nums);
		 * int param_1 = obj.showFirstUnique();
		 * obj.add(value);
		 */
	}

}
