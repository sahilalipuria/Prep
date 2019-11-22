package firstFitProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstFitDecreasingAlgo {
	
	private List<Bin> bins = new ArrayList<Bin>();
	private List<Integer> items;
	private int binCapacity;
	private int binCounter =1;
	public FirstFitDecreasingAlgo(List<Integer> items, int binCapacity) {
		super();
		this.items = items;
		this.binCapacity = binCapacity;
	}
	
	public void solveBinPacking() {
		
		Collections.sort(items, Collections.reverseOrder());
		
		if(this.items.get(0)>binCapacity) {
			System.out.println("NO FEASIBLE SOLUTION");
			return;
		}
		
		this.bins.add(new Bin(binCounter, binCapacity));
		
		for(Integer item: items) {
			boolean isOk = false;		//to track if we have put the item in bin or not
			int currentBin =0;
			while(!isOk) {
				if(currentBin==this.bins.size()) {
					Bin newBin = new Bin(binCounter++, binCapacity);
					newBin.put(item);
					this.bins.add(newBin);
					isOk = true;
				}
				else if(this.bins.get(currentBin).put(item)) {
					isOk = true;
				}
				else {
					currentBin++;		// trying next bin
				}
			}
		}
	}
	
	public void showResult() {
		for(Bin bin: bins) {
			System.out.println(bin);
		}
	}

}
