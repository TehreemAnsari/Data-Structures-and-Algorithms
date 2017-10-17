package chap4;

import java.util.Random;

public class Question_4_11 {
	class Node
	{
		int data;
		Node left,right;
		public Node(int data) {
			this.data=data;
		}		
	}
	Node n1=new Node(1);
	Node n11=new Node(11);
	Node n9=new Node(9);
	Node n14=new Node(14);
	Node n6=new Node(6);
	Node n21=new Node(21);
	Node n18=new Node(18);
	Node n24=new Node(24);
	Node n16=new Node(16);
	Node n17=new Node(17);
	Node n2=new Node(2);
	Node n15=new Node(15);
	Node n3=new Node(3);
	Node n12=new Node(12);
	Node n8=new Node(8);
	Node makeT()
	{
		n1.left=n11;
		n1.right=n9;
		n11.left=n14;
		n11.right=n6;
		n9.left=n21;
		n9.right=n18;
		n14.left=n24;
		n14.right=n16;
		n6.left=n17;
		n6.right=n2;
		n21.left=n15;
		n21.right=n3;
		n18.left=n12;
		n18.right=n8;
		return n1;
	}
	static Random rand = new Random();
	static int treesize=15;
	static int randomNum = rand.nextInt(treesize);
	static int count = -1;
	static Node randNode;

	public static Node getRandomTraversal(Node root){

	    count++;

	    if(count == randomNum)
	        randNode = root;

	    if(root.left != null)
	        getRandomTraversal(root.left);

	    if(root.right != null)
	        getRandomTraversal(root.right);
	    return randNode;
	}
	public static void main(String[] args) {
		Question_4_11 obj=new Question_4_11();
		Node root=obj.makeT();
		System.out.println("Random node:"+obj.getRandomTraversal(root).data);
	}
}
