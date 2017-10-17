package basic;

import java.util.ArrayList;

class BinaryNode {
	int data;
	BinaryNode left,right;
 
	public BinaryNode(int data) {
		this.data = data;
		this.left = this.right = null;
	}
 
	void inOrder() {
		if(this == null)
			return;
 
		if(this.left != null)
			this.left.inOrder();
 
		System.out.print(this.data + " ");
 
		if(this.right != null)	
			this.right.inOrder();
	}
 
	void preOrder() {
		if(this == null)
			return;
 
		System.out.print(this.data + " ");
 
		if(this.left != null)
			this.left.preOrder();
 
		if(this.right != null)	
			this.right.preOrder();
	}
}
 
class ConstructAllPossibleBTs {
 
	static ArrayList<BinaryNode> constructAllPossibleBSTs(int start, int end) {
		ArrayList<BinaryNode> arr = new ArrayList<BinaryNode>();
 
		if(start > end) {
			arr.add(null);
			return arr;
		}
 
		for(int i=start;i<=end;i++) {
			ArrayList<BinaryNode> leftSubTree = constructAllPossibleBSTs(start,i-1);
			ArrayList<BinaryNode> rightSubTree = constructAllPossibleBSTs(i+1,end);
 
			for(int j=0;j<leftSubTree.size();j++) {
				BinaryNode left = leftSubTree.get(j);
				for(int k=0;k<rightSubTree.size();k++) {
					BinaryNode right = rightSubTree.get(k);
					BinaryNode root = new BinaryNode(i);
					root.left = left;
					root.right = right;
					arr.add(root);
				}
			}
		}
 
		return arr;
	}
 
	public static void main(String[] args) {
		ArrayList<BinaryNode> arr = constructAllPossibleBSTs(1,3);
 
		for(int i=0;i<arr.size();i++) {
			System.out.println("inOrder");
			arr.get(i).inOrder();
			System.out.println();
 
			System.out.println("preOrder");
			arr.get(i).preOrder();
			System.out.println("\n");
		}
	}
}