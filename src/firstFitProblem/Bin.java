package firstFitProblem;

import java.util.ArrayList;
import java.util.List;

public class Bin {
	
	private int id;
	private int capacity;
	private int currentSize;
	private List<Integer> items;
	public Bin(int id, int capacity) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.items = new ArrayList<>();
	}
	
	public boolean put(Integer item) {
		if(this.currentSize + item > this.capacity)
			return false;
		
		this.currentSize += item;
		this.items.add(item);
		return true;
	}
	
	@Override
	public String toString() {
		String contentOfBin = "Items in bin #"+this.id+" : ";
		for(Integer item: items) {
			contentOfBin += item + " ";
		}
		return contentOfBin;
	}
	

}
