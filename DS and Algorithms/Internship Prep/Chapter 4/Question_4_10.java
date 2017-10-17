package chap4;

public class Question_4_10 {
	class Node
	{
		int data;
		Node left,right;
		public Node(int data) {
			this.data=data;
		}
		public Node(int data, Node left, Node right)
		{
			this.data=data;
			this.left=left;
			this.right=right;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
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
	
	Node makeT1()
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
		System.out.println("n11="+n11);
		return n1;
	}
	Node makeT2()
	{
		n11.left=n14;
		System.out.println("n11="+n11);
		n11.right=n6;
		n14.left=n24;
		n14.right=n16;
		n6.left=n17;
		n6.right=n2;
		return n11;
	}
	//boolean matchFound=false;
	Node matchedNode=null;
	Node getSubtreeRoot(Node root2, Node root1)
	{
		if(root1==null|| root2==null)
		{
			return null;
		}
		System.out.println("Root1="+root1+" root2="+root2);
		System.out.println("Root1.hashcode="+root1.hashCode());
		System.out.println("Root2.hashcode="+root2.hashCode());
		System.out.println("Is root1==root2?"+(root1.hashCode()==root2.hashCode()));
		if(root1.hashCode()==root2.hashCode())
		{
			//matchFound=true;
			matchedNode=root1;
			System.out.println("Matched node="+matchedNode);
		}
		else {
			getSubtreeRoot(root2, root1.left);
			getSubtreeRoot(root2, root1.right);
		}
		return matchedNode;
	}
	boolean checkSubtree(Node root2, Node node)
	{
		System.out.println("Root2="+root2);
		System.out.println("Node to check="+node);
		if(root2==null && node==null)
			return true;
		if(node!=root2)
			return false;
		return checkSubtree(root2.left, node.left) && checkSubtree(root2.right, node.right);
	}
	public static void main(String[] args) {
		Question_4_10 obj=new Question_4_10();
		Node root1=obj.makeT1();
		System.out.println("root1="+root1);
		Node root2=obj.makeT2();
		System.out.println("root2="+root2);
		Node subTreeNode=obj.getSubtreeRoot(root2, root1);
		System.out.println("Subtree Node="+subTreeNode);
		System.out.println("Is Subtree?"+obj.checkSubtree(root2, subTreeNode));
	}
}
