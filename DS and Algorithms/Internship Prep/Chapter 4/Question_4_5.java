package chap4;

public class Question_4_5 {
	private class Node {
	    private int data;
	    private Node right;
	    private Node left;
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

	public boolean isBST(Node n) {
	    return isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node n, int min, int max) {
	    if (n == null) return true;
	    if (n.data < min || n.data > max) return false;
	    return isBST(n.left, min, n.data) && isBST(n.right, n.data + 1, max);
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
	public static void main(String[] args) {
		Question_4_5 obj=new Question_4_5();
		Node root=obj.makeTree();
		System.out.println("BST? "+obj.isBST(root));
	}
}
