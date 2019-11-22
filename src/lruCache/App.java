package lruCache;

public class App {

	public static void main(String[] args) {
		
		LRUCache lruCache = new LRUCache();
		
		lruCache.put(0, "A");
		lruCache.put(1, "B");
		lruCache.put(2, "C");
		lruCache.put(3, "D");
		lruCache.put(4, "E");
		lruCache.put(5, "F");
		lruCache.put(6, "G");
		
		System.out.println(lruCache.get(6));
		lruCache.show();
		System.out.println();
		
		System.out.println(lruCache.get(3));
		lruCache.show();
		System.out.println();
		
		System.out.println(lruCache.get(4));
		lruCache.show();
		System.out.println();

	}

}
