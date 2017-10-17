package basic;

class BSTNode{
	int data;
	BSTNode leftChild;
	BSTNode rightChild;
	public BSTNode() {
	}
	public BSTNode(int data, BSTNode leftChild, BSTNode rightChild) {
		this.data=data;
		this.leftChild=leftChild;
		this.rightChild=rightChild;
	}
}
public class BST 
{
	BSTNode root;
	BST()
	{
		root=null; 
	}
	void insert(int item)
	{
		root=insertRec(item, root);
		
	}
	private BSTNode insertRec(int item, BSTNode root)
	{
		if(root==null)
		{
			root=new BSTNode(item, null, null);
			return root;
		}
		if(item<root.data)
		{
			root.leftChild=insertRec(item,root.leftChild);
			return root;
		}
		else
		{
			root.rightChild=insertRec(item,root.rightChild);
			return root;
		}
		
	}
	void print()
	{
		printBST(root);
		System.out.print("Over");
	}
	void printBST(BSTNode node)
	{
		if(node!=null)
		{
			System.out.print(node.data+"-");
			printBST(node.leftChild);
			printBST(node.rightChild);
		}
	}
	void search(int item)
	{
		System.out.println("Item found at: "+searchRec(item,root).data);
	}
	private BSTNode searchRec(int item, BSTNode node) {
		if(item==node.data || node==null)
		{
			return node;
		}
		else if(item<node.data)
		{
			return searchRec(item, node.leftChild);
		}
		else
			return searchRec(item, node.rightChild);
	}
	void delete(int item)
	{
		System.out.println("Node to be deleted is "+searchRec(item, root).data);
		deleteRec(searchRec(item, root)); //node to be deleted is searchRec(item, root)
		//replace the node to be deletedd with the right most child in the left subtree
	}
	void deleteRec(BSTNode node)
	{
		if(node.leftChild!=null&&node.rightChild!=null)//both children present
		{
			BSTNode predecessor=findPredecessor(node.leftChild);
			System.out.println("Predecessor of "+node.data+" is "+predecessor.data);
			node.data=predecessor.data;
			predecessor=null;
		}
		else if(node.leftChild==null)	//only right child present
		{
			node=node.rightChild;
			System.out.println("Value of node="+node);
			System.out.println(searchRec(10, root).leftChild.data);
		}
		else if (node.rightChild==null)	//only left child present
		{
			node=node.leftChild;
		}
	}
	BSTNode findPredecessor(BSTNode node)
	{
		if(node==null)
			return null;
		else if(node.rightChild==null)
		{
			return node;
		}
		else
		{
			return findPredecessor(node.rightChild);
		}
	}
	
	public static void main(String[] args) {
		BST tree=new BST();
		tree.insert(10);
		tree.insert(5);
		tree.insert(20);
		tree.print();
		tree.search(20);
		tree.delete(5);
		tree.print();
	}
}
