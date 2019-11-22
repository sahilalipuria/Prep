package genericHashTable;

public class App {

	public static void main(String[] args) {
		
		HashTable< String, Integer> hashTable = new HashTable<>();
		
		hashTable.put("a", 1);
		System.out.println(hashTable.size());
		hashTable.put("b", 2);
		System.out.println(hashTable.size());
		hashTable.put("c", 3);
		System.out.println(hashTable.size());
		hashTable.put("d", 4);
		System.out.println(hashTable.size());
		hashTable.put("e", 5);
		System.out.println(hashTable.size());
		hashTable.put("f", 6);
		System.out.println(hashTable.size());
		hashTable.put("g", 7);
		System.out.println(hashTable.size());
		hashTable.put("h", 8);
		System.out.println(hashTable.size());
		hashTable.put("bb", 9);
		System.out.println(hashTable.size());
		hashTable.put("v", 10);
		System.out.println(hashTable.size());
		hashTable.put("fff", 11);
		System.out.println(hashTable.size());
		
		hashTable.remove("c");
		System.out.println(hashTable.size());
		
		hashTable.remove("g");
		System.out.println(hashTable.size());
		
		hashTable.remove("f");
		System.out.println(hashTable.size());
		
		hashTable.remove("d");
		System.out.println(hashTable.size());
		
		hashTable.remove("b");
		System.out.println(hashTable.size());
		
		hashTable.remove("a");
		System.out.println(hashTable.size());

	}

}
