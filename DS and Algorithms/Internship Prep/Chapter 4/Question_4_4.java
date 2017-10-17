package chap4;

public class Question_4_4 {
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
	}
	Node makeTree()
	{
		Node n11=new Node(11);
		Node n2=new Node(2);
		n2.left=n11;
		Node n10=new Node(10);
		Node n8=new Node(8);
		Node n4=new Node(4);
		Node n1=new Node(1);
		n1.left=n2;
		Node n9=new Node(9, n1, n10);
		Node n3=new Node(3, n8, n4);
		Node n7=new Node(7, n9, n3);
		Node root=n7;
		return root;
	}
	int getHeight(Node node)
	{
		if(node==null)
			return -1;
		return Math.max(getHeight(node.left), getHeight(node.right))+1;
	}
	boolean isBalanced(Node node)
	{
		if(node==null)
			return true;
		int heightDiff=Math.abs(getHeight(node.left)-getHeight(node.right));
		if(heightDiff>1)
			return false;
		else
		{
			return isBalanced(node.left) && isBalanced(node.right);
		}
	}
	public static void main(String[] args) {
		Question_4_4 obj=new Question_4_4();
		Node root=obj.makeTree();
		System.out.println("Balanced?"+obj.isBalanced(root));
	}
	
}
