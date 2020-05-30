/**
 * 
 */
package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @author salipuri
 *
 */
public class ProductSupplyOrder {

	/**
	 * @param args
	 */
	
	public static List<Integer> getRouteOrder(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, int company){
		
		List<Integer> result = new ArrayList<Integer>();
		
		if(cityFrom.size()==0 || cityTo.size()==0)
			return result;
		
		HashMap<Integer, ArrayList<Integer>> cityMap= new HashMap<>();
		int i =0;
		
		while(i<cityFrom.size()) {
			int currentCity = cityFrom.get(i);
			if(!cityMap.containsKey(currentCity)) {
				cityMap.put(currentCity, new ArrayList<Integer>());
			}
			cityMap.get(currentCity).add(cityTo.get(i));
			i++;
		}
		
		for(ArrayList<Integer> value: cityMap.values())
			Collections.sort(value);
			
		Queue<Integer> queue = new LinkedList<>();
		queue.add(company);
		
		while(!queue.isEmpty()) {
			int current = queue.remove();
			if(cityMap.get(current)!=null) {
				for(int j=0;j<cityMap.get(current).size();j++) {
					if(!result.contains(cityMap.get(current).get(j))) {
						queue.add(cityMap.get(current).get(j));
					}
				}
			}
			result.add(current);
		}
		
		return result;
	}
	
	public static List<Integer> getRouteOrder2(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, int company){
		
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> temp;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(company);
		
		while(!queue.isEmpty()) {
			int current = queue.remove();
			temp = new ArrayList<Integer>();
			for(int i=0;i<cityFrom.size();i++) {
				if(cityFrom.get(i)==current) {
					int toCity = cityTo.get(i);
					if(!result.contains(toCity) && !queue.contains(toCity)) {
						temp.add(toCity);
					}
				}
			}
			Collections.sort(temp);
			queue.addAll(temp);
			result.add(current);
		}
		
		return result;
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cityNodes;
		List<Integer> cityFrom = new ArrayList<>(Arrays.asList(1,1,3,1,5));
		List<Integer> cityTo = new ArrayList<>(Arrays.asList(2,3,2,5,4));
		int company = 1;
		
		long startTime = System.currentTimeMillis();
		System.out.println(getRouteOrder(5, cityFrom, cityTo, company));
		System.out.println("-------"+getRouteOrder2(5, cityFrom, cityTo, company));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		System.out.println();
		
		cityFrom = new ArrayList<>(Arrays.asList(1,2,2));
		cityTo = new ArrayList<>(Arrays.asList(2,3,4));
		
		startTime = System.currentTimeMillis();
		System.out.println(getRouteOrder(4, cityFrom, cityTo, company));
		System.out.println("-------"+getRouteOrder2(4, cityFrom, cityTo, company));
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println(totalTime);
		
		
	}

}
