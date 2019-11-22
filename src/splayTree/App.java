package splayTree;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tree<Integer> splayTree = new SplayTree<>();
		
		splayTree.insert(10);
		splayTree.insert(-5);
		splayTree.insert(0);
		splayTree.insert(20);
		splayTree.insert(30);
		
		((SplayTree)splayTree).printRoot();
		System.out.println();

		splayTree.inOrderTraversal();
		
		System.out.println("FINDING 0:"+splayTree.find(0));
	}

}
