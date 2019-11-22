package hashMapChaining;

public class HashTable {
	
	private HashItem[] hashtable;
	
	public HashTable() {
		this.hashtable = new HashItem[Constants.TABLE_SIZE];
	}
	
	private int hash(int key) {
		
		return (key%Constants.TABLE_SIZE);
		//return 1;						//For testing collision
	}
	
	public void put(int key,int value) {
		
		int hashArrayIndex = hash(key);
		
		if(hashtable[hashArrayIndex]== null) {
			System.out.println("No collisions!! Simple Insertion!!!");
			hashtable[hashArrayIndex] = new HashItem(key, value);
		}else {
			System.out.println("Collisions when inserting with key:"+key);
			
			HashItem hashItem = hashtable[hashArrayIndex];
			
			while(hashItem.getNextHashItem()!=null) {
				hashItem = hashItem.getNextHashItem();
				System.out.println("Considering next item in linked list with value:"+hashItem.getValue());
			}
			
			System.out.println("Finally we have find the place to insert....");
			hashItem.setNextHashItem(new HashItem(key, value));
		}
	}
	
	public int get(int key) {
		
		int generatedArrayIndex = hash(key);
		
		if(hashtable[generatedArrayIndex]==null) {
			return -1;
		}else {
			
			HashItem hashItem = hashtable[generatedArrayIndex];
			while(hashItem!=null && hashItem.getKey()!=key)
				hashItem = hashItem.getNextHashItem();
			
			if(hashItem == null)
				return -1;
			else
				return hashItem.getValue();
		}
	}

}
