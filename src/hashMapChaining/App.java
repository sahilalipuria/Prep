package hashMapChaining;

public class App {

	public static void main(String[] args) {
		
		HashTable hashTable = new HashTable();
		
		hashTable.put(1, 10);
		System.out.println();
		hashTable.put(2, 100);
		System.out.println();
		hashTable.put(3, 1000);
		System.out.println();
		hashTable.put(4, 10000);
		System.out.println();
		hashTable.put(5, 100000);
		System.out.println();
		hashTable.put(6, 1000000);
		System.out.println();
		hashTable.put(7, 10000000);
		System.out.println();
		hashTable.put(8, 100000000);
		System.out.println();
		hashTable.put(9, 1000000000);
		System.out.println();
		hashTable.put(10, 1000000000);
		System.out.println();
		hashTable.put(11, 1000000001);
		System.out.println();
		hashTable.put(12, 1000000002);
		System.out.println();
		
		System.out.println(hashTable.get(1));
		System.out.println(hashTable.get(11));

	}

}
