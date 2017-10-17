package basic;

//Java program to print all the node to leaf path
import java.util.*;

class PrintPaths {

	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node n1 = new Node(1);
	Node n11 = new Node(11);
	Node n9 = new Node(9);
	Node n14 = new Node(14);
	Node n6 = new Node(6);
	Node n21 = new Node(21);
	Node n18 = new Node(18);
	Node n24 = new Node(24);
	Node n16 = new Node(16);
	Node n17 = new Node(17);
	Node n2 = new Node(2);
	Node n15 = new Node(15);
	Node n3 = new Node(3);
	Node n12 = new Node(12);
	Node n8 = new Node(8);

	Node makeTree() {
		n1.left = n11;
		n1.right = n9;
		n11.left = n14;
		n11.right = n6;
		n9.left = n21;
		n9.right = n18;
		n14.left = n24;
		n14.right = n16;
		n6.left = n17;
		n6.right = n2;
		n21.left = n15;
		n21.right = n3;
		n18.left = n12;
		n18.right = n8;
		return n1;
	}

	void printPaths(Node node) {
		if(node == null)
			return;
		ArrayList<Integer> path = new ArrayList<Integer>();
		printPathsRecur(node, path, 0);
	}

	void printPathsRecur(Node node, ArrayList<Integer> path, Integer sum) {
		if (node == null)
		{
			return;
		}

		/* append this node to the path array */
		path.add(node.data);
		sum=sum+node.data;
		
		/* it's a leaf, so print the path that led to here */
		if (node.left == null && node.right == null)
		{
			path.add(sum);
			printList(path);
			return;
		}
		
		else {
			/* otherwise try both subtrees */
			printPathsRecur(node.left, new ArrayList<Integer>(path), sum);
			//create a new ArrayList<Integer>(path) otherwise it will keep adding to the previous list itself
			//This will create new Object of ArrayList each time, and then on returning it takes the previous copy
			//trace it and check
			printPathsRecur(node.right, new ArrayList<Integer>(path),sum);
		}
	}

	void printList(ArrayList<Integer> path) {
		for(int i=0;i<path.size()-1;i++)
		{
			System.out.print(path.get(i)+" ");
		}
		System.out.print("sum="+path.get(path.size()-1));
		System.out.println();
	}

	public static void main(String args[]) {
		PrintPaths tree = new PrintPaths();
		Node root = tree.makeTree();
		tree.printPaths(root);
	}
}
