package chap4;

//Java program to print all the node to leaf path
import java.util.*;

class Question_4_12 {

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
	boolean sumFound=false;
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
	
	void hasSum(Node node,ArrayList<Integer> pathOfSum , Integer sum,Integer requiredSum)
	{
		sumFound=hasPathOfSumUtil(node, pathOfSum, sum, requiredSum);
		while(node!=null && sumFound!=true)
		{
			hasSum(node.left, pathOfSum, sum, requiredSum);
			hasSum(node.right, pathOfSum, sum, requiredSum);
		}
	}
	boolean hasPathOfSumUtil(Node node,  ArrayList<Integer> pathOfSum, Integer sum, Integer requiredSum)
	{
		if (node == null)
		{
			return false;
		}

		/* append this node to the path array */
		pathOfSum.add(node.data);
		sum=sum+node.data;
		if(sum==requiredSum)
		{
			sumFound=true;
			printList(pathOfSum);
			return true;
		}
		else
		{
			hasPathOfSumUtil(node.left,new ArrayList<Integer> ( pathOfSum), sum, requiredSum);
			hasPathOfSumUtil(node.right,new ArrayList<Integer> ( pathOfSum), sum, requiredSum);
		}
		return (sum==requiredSum);
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
		Question_4_12 tree = new Question_4_12();
		Node root = tree.makeTree();
		int sum=0, requiredSum=35;
		ArrayList<Integer> pathOfSum = new ArrayList<Integer>();
		tree.hasSum(root, pathOfSum, sum, requiredSum);
	}
}
