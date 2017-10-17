package basic;

//Java program to find maximum path sum in Binary Tree

/* Class containing left and right child of current
node and key value*/
/*class Node {

	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

//An object of Res is passed around so that the
//same value can be used by multiple recursive calls.
class Res {
	public int val;
}*/

class MaxDiameterSum2 {

	// Root of the Binary Tree
	BinaryNode root;

	// This function returns overall maximum path sum in 'res'
	// And returns max path sum going through root.

	int findMaxSum() {
		return findMaxSum(root);
	}

	// Returns maximum path sum in tree with given root
	int findMaxSum(BinaryNode node) {

		// Initialize result
		// int res2 = Integer.MIN_VALUE;
		Res res = new Res();
		res.val = Integer.MIN_VALUE;

		// Compute and return result
		findMaxUtil(node, res);
		return res.val;
	}
	int findMaxUtil(BinaryNode node, Res res)
	{

		// Base Case
		if (node == null)
			return 0;

		// l and r store maximum path sum going through left and
		// right child of root respectively
		int l = findMaxUtil(node.left, res);
		int r = findMaxUtil(node.right, res);

		// Max path for parent call of root. This path must
		// include at-most one child of root
		int max_single = Math.max(Math.max(l, r) + node.data,
								node.data);


		// Max Top represents the sum when the Node under
		// consideration is the root of the maxsum path and no
		// ancestors of root are there in max sum path
		int max_top = Math.max(max_single, l + r + node.data);

		// Store the Maximum Result.
		res.val = Math.max(res.val, max_top);

		return max_single;
	}


	/* Driver program to test above functions */
	public static void main(String args[]) {
		MaxDiameterSum2 tree = new MaxDiameterSum2();
		tree.root = new BinaryNode(10);
		tree.root.left = new BinaryNode(2);
		tree.root.right = new BinaryNode(10);
		tree.root.left.left = new BinaryNode(20);
		tree.root.left.right = new BinaryNode(1);
		tree.root.right.right = new BinaryNode(-25);
		tree.root.right.right.left = new BinaryNode(3);
		tree.root.right.right.right = new BinaryNode(4);
		System.out.println("maximum path sum is : " +tree.findMaxSum());
	}
}
