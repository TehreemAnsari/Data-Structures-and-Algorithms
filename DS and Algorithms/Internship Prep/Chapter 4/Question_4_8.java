package chap4;

public class Question_4_8 {
	boolean v1,v2;
	static Node root;
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
	Node findLCA(int n1, int n2)
	{
		v1=false;
		v2=false;
		Node lca=findLCAUtil(root, n1,n2);
		if(v1 && v2)
		{
			return lca;
		}
		else 
			return null;
	}
	Node findLCAUtil(Node node, int n1, int n2)
	{
		if(node==null)
		{
			return null;
		}
		if(node.data==n1)
		{
			v1=true;
			return node;
		}
		if(node.data==n2)
		{
			v2=true;
			return node;
		}
		Node leftLCA=findLCAUtil(node.left, n1,n2);
		Node rightLCA=findLCAUtil(node.right, n1,n2);
		if(leftLCA!=null && rightLCA!=null)
		{
			return node;
		}
		else if(leftLCA!=null)
		{
			return leftLCA;
		}
		else
			return rightLCA;
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
		Question_4_8 obj=new Question_4_8();
		root=obj.makeTree();
		int num1=10;
		int num2=3;
		System.out.println("First common ancestor of "+num1+" and "+num2+" is:"+obj.findLCA(num1, num2).data);
	}
}
