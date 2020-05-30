/**
 * 
 */
package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author salipuri
 * 
 * Chef gets a unique non-repeated ingredient everyday one for 3 category of “FAT,FIBER,CARB”.
 * He only cooks the food when using at least 2 ingredients of same category. 
 * Mainly he chooses the oldest one to cook else he doesn’t cook.
 *
 */
public class ChefWorkingDay {

	/**
	 * @param args
	 */
	
	private static HashMap<String, List<Integer>> categoryMap = new HashMap<>();
	private static PriorityQueue<String> minHeap = new PriorityQueue<String>(
			(a, b) -> categoryMap.get(a).get(0) - categoryMap.get(b).get(0));
	private static PriorityQueue<String> maxHeap = new PriorityQueue<String>(
			(a, b) -> categoryMap.get(b).size() - categoryMap.get(a).size());
	
	public static void cook(String firstIngredient,String secondIngredient) {
		categoryMap.get(firstIngredient).remove(0);
		categoryMap.get(firstIngredient).remove(0);
		
		minHeap.remove(firstIngredient);
		maxHeap.remove(firstIngredient);

		String secondIngredient = minHeap.poll();
		categoryMap.get(secondIngredient).remove(0);
		minHeap.remove(secondIngredient);
		maxHeap.remove(secondIngredient);

		System.out.print(1);
		if (categoryMap.get(firstIngredient).size() > 0) {
			minHeap.add(firstIngredient);
			maxHeap.add(firstIngredient);
		}
		if (categoryMap.get(secondIngredient).size() > 0) {
			minHeap.add(secondIngredient);
			maxHeap.add(secondIngredient);
		}
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int numberOfDays = in.nextInt();
		String ingredient;
		String category = "";
		for (int i = 0; i < numberOfDays; i++) {
			ingredient = in.next();
			if (ingredient.startsWith("FAT")) {
				category = "FAT";
			} else if (ingredient.startsWith("CARB")) {
				category = "CARB";
			} else if (ingredient.startsWith("FIBER")) {
				category = "FIBER";
			}
			if (!categoryMap.containsKey(category))
				categoryMap.put(category, new ArrayList<>());
			categoryMap.get(category).add(i);
			if (!minHeap.contains(category)) {
				minHeap.add(category);
				maxHeap.add(category);
			}
			if (categoryMap.get(category).size() >= 2 && minHeap.size() > 1) {
				categoryMap.get(category).remove(0);
				categoryMap.get(category).remove(0);
				
				minHeap.remove(category);
				maxHeap.remove(category);

				String secondIngredient = minHeap.poll();
				categoryMap.get(secondIngredient).remove(0);
				minHeap.remove(secondIngredient);
				maxHeap.remove(secondIngredient);

				System.out.print(1);
				if (categoryMap.get(category).size() > 0) {
					minHeap.add(category);
					maxHeap.add(category);
				}
				if (categoryMap.get(secondIngredient).size() > 0) {
					minHeap.add(secondIngredient);
					maxHeap.add(secondIngredient);
				}
			} else if (maxHeap.size() > 1 && categoryMap.get(maxHeap.peek()).size() > 1) {
				categoryMap.get(category).remove(0);
				minHeap.remove(category);
				maxHeap.remove(category);

				String secondIngredient = maxHeap.poll();
				categoryMap.get(secondIngredient).remove(0);
				categoryMap.get(secondIngredient).remove(0);
				minHeap.remove(secondIngredient);
				maxHeap.remove(secondIngredient);
				
				if (categoryMap.get(category).size() > 0) {
					minHeap.add(category);
					maxHeap.add(category);
				}
				if (categoryMap.get(secondIngredient).size() > 0) {
					minHeap.add(secondIngredient);
					maxHeap.add(secondIngredient);
				}
				
			} else
				System.out.print(0);
		}
    }

}
