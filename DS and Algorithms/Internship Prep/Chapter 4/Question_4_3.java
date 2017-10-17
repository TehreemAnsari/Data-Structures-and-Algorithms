package chap4;
import java.util.*;

public class Question_4_3 {
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
	static ArrayList<LinkedList<Node>> lists=new ArrayList<LinkedList<Node>>();
	void createLevelOrderTree(Node root, int level)
	{
		if(root==null)
			return;
		LinkedList<Node> list=null;
		if(lists.size()==level)
		{
			list=new LinkedList<Node>();
			lists.add(list);
		}
		else
		{
			list=lists.get(level);
		}
		list.add(root);
		createLevelOrderTree(root.left, level+1);
		createLevelOrderTree(root.right, level+1);
	}
	void printLevels(ArrayList<LinkedList<Node>> lists)
	{
		int level=0;
		for(LinkedList<Node> list: lists)
		{ 
			System.out.println("\nIn level "+level);
			for(Node nodes:list)
			{
				System.out.print(nodes.data+" ");
			}
			level++;
		}
			
	}
	Node makeTree()
	{
		Node n2=new Node(2);
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
	void printTree(Node node)
	{
		if(node==null)
			return;
		printTree(node.left);
		System.out.print(node.data+" ");
		printTree(node.right);
	}
	public static void main(String[] args) {
		Question_4_3 obj=new Question_4_3();
		Node treeRoot=obj.makeTree();
		obj.createLevelOrderTree(treeRoot, 0);
		obj.printLevels(lists);
		//obj.printTree(obj.makeTree());
	}
}
