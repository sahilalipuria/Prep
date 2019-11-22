package binaryHeap;

import java.util.Queue;
import java.util.PriorityQueue;

public class MyPriorityQueue {

	public static void main(String[] args) {
		
		Queue<Person> queue = new PriorityQueue<>();
		
		queue.add(new Person("Joe",37));
		queue.add(new Person("Kevin",22));
		queue.add(new Person("Adam",12));
		queue.add(new Person("Anna",45));
		
		while(queue.peek()!=null) {
			System.out.println(queue.poll());
		}

	}

}
