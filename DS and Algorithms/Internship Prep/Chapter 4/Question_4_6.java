package chap4;

public class Question_4_6 {
	Node n2,n1,n10,n8,n4,n9,n3,n7,root;
	private class Node {
	    private int data;
	    private Node right;
	    private Node left;
	    Node parent;
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
		n2=new Node(2);
		n10=new Node(10);
		n8=new Node(8);
		n4=new Node(4);
		n1=new Node(1);
		n1.left=n2;
		n9=new Node(9, n1, n10);
		n3=new Node(3, n8, n4);
		n7=new Node(7, n9, n3);
		n2.parent=n1;
		n1.parent=n9;
		n10.parent=n9;
		n8.parent=n3;
		n4.parent=n3;
		n9.parent=n7;
		n3.parent=n7;
		root=n7;
		return root;
	}
	Node inOrderSuccessor(Node node, Node root)
	{
		if(node.right!=null)
		{
			Node temp=node.right;
			while(temp.left!=null)
			{
				temp=temp.left;
			}
			return temp;
		}
		else
		{
			Node p=node.parent;
			while(p!=null && node==p.right)
			{
				node=p;
				p=p.parent;
			}
			return p;
		}
	}
	public static void main(String[] args) {
		Question_4_6 obj=new Question_4_6();
		Node root=obj.makeTree();
		System.out.println("Successor of "+obj.n8.data+" is: "+(obj.inOrderSuccessor(obj.n8, obj.root)).data);
	}
}
