package hashMapLinearProbing;

import hashMapChaining.Constants;

/*
 * In linear probing, we linearly probe for next slot. For example, typical gap between two probes is 1 as taken in below example also.
let hash(x) be the slot index computed using hash function and S be the table size

If slot hash(x) % S is full, then we try (hash(x) + 1) % S
If (hash(x) + 1) % S is also full, then we try (hash(x) + 2) % S
If (hash(x) + 2) % S is also full, then we try (hash(x) + 3) % S 
..................................................
..................................................
 */

public class HashTable {
	
	private HashItem[] hashTable;

	public HashTable() {
		this.hashTable = new HashItem[Constants.TABLE_SIZE];
	}
	
	public void put(int key,int value) {
		
		int generatedIndex = hash(key);
		System.out.println("Put method called with value:"+value+" -generatedIndex:"+generatedIndex);
		
		while(hashTable[generatedIndex] != null) {
			generatedIndex = (generatedIndex+1)%Constants.TABLE_SIZE;
			System.out.println("Collision:nextIndex->"+generatedIndex);
		}
		
		System.out.println("Inserted finally with index: "+generatedIndex);
		hashTable[generatedIndex]= new HashItem(key, value);
	}
	
	public int get(int key) {
		
		int generatedIndex = hash(key);
		
		while(hashTable[generatedIndex]!=null && hashTable[generatedIndex].getKey()!=key) {
			generatedIndex = (generatedIndex+1)%Constants.TABLE_SIZE;
			System.out.println("Hopping to the next index: "+generatedIndex);
		}
		
		if(hashTable[generatedIndex]==null) {
			return -1;
		}
		
		return hashTable[generatedIndex].getValue();
	}
	
	private int hash(int key) {
		
		return (key%Constants.TABLE_SIZE);
		//return 1;						//For testing collision
	}

}
