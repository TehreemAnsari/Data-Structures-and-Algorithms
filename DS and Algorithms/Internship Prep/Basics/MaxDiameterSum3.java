package basic;

import java.util.Scanner;

//Java program to find maximum path sum between two leaves
//of a binary tree
class Node {

	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

//An object of Res is passed around so that the
//same value can be used by multiple recursive calls.
class Res {
	int val;
}

class MaxDiameterSum3 {
	

	static Node root;

	// A utility function to find the maximum sum between any
	// two leaves.This function calculates two values:
	// 1) Maximum path sum between two leaves which is stored
	// in res.
	// 2) The maximum root to leaf path sum which is returned.
	// If one side of root is empty, then it returns INT_MIN
	int maxPathSumUtil(Node node, Res res) {

		// Base cases
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return node.data;

		// Find maximum sum in left and right subtree. Also
		// find maximum root to leaf sums in left and right
		// subtrees and store them in ls and rs
		int ls = maxPathSumUtil(node.left, res);
		int rs = maxPathSumUtil(node.right, res);

		// If both left and right children exist
		if (node.left != null && node.right != null) {

			// Update result if needed
			res.val = Math.max(res.val, ls + rs + node.data);

			// Return maxium possible value for root being
			// on one side
			return Math.max(ls, rs) + node.data;
		}

		// If any of the two children is empty, return
		// root sum for root being on one side
		return (node.left == null) ? rs + node.data
				: ls + node.data;
	}

	// The main function which returns sum of the maximum
	// sum path between two leaves. This function mainly
	// uses maxPathSumUtil()
	int maxPathSum(Node node)
	{
		Res res = new Res();
		res.val = Integer.MIN_VALUE;
		maxPathSumUtil(root, res);
		return res.val;
	}

	Node makeTree(int a[], Node node, int index)
	{
		if(index>a.length-1)
			return null;
		node=new Node(a[index]);
		node.left=makeTree(a, node.left, 2*index+1);
		node.right=makeTree(a, node.right, 2*index+2);
		
		return node;
	}
	//Driver program to test above functions
	public static void main(String args[]) {
		MaxDiameterSum3 tree = new MaxDiameterSum3();
		int numberOfNodes = 0;
		int a[] = null;
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
			//System.out.println("Enter no of nodes");
			numberOfNodes=sc.nextInt();
			a=new int[numberOfNodes];
			for(int j=0;j<numberOfNodes;j++)
			{
				a[j]=sc.nextInt();
				//System.out.println(a[j]);
			}
			if(numberOfNodes==1)
				System.out.println(a[0]);
			else
			{
				tree.root=tree.makeTree(a, tree.root, 0);
				System.out.println(tree.maxPathSum(root));
			}
			
		}
	}
}

