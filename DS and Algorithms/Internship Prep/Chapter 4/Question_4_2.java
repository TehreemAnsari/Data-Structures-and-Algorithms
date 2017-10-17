package chap4;

public class Question_4_2 {
	class BSTNode
	{
		int data;
		BSTNode left,right;
		public BSTNode(int data) {
			this.data=data;
		}
	}
	BSTNode makeTree(int[] arr, int minIndex, int maxIndex)
	{ 
		//System.out.println("MinIndex:"+minIndex+" maxIndex:"+maxIndex);
		if(minIndex>maxIndex)	//When minIndex becomes greater than maxIndex, then return!!!
		{
			return null;
		}
		int middle=(minIndex+maxIndex)/2;
		BSTNode node=new BSTNode(arr[middle]);
		System.out.println(node.data);
		node.left=makeTree(arr, minIndex, middle-1);
		node.right=makeTree(arr,middle+1,maxIndex);
		return node;
	}
	void printTree(BSTNode node)
	{
		if(node==null)
			return;
		printTree(node.left);
		System.out.print(node.data+" ");
		printTree(node.right);
	}
	public static void main(String[] args) {
		Question_4_2 obj=new Question_4_2();
		int values[]= {1,2,3,4,7,9,12,19};
		BSTNode root= obj.makeTree(values, 0, values.length-1); //MaxIndex is NOT just values.length, 1 has to be subtracted from it
		System.out.println("Root:"+root.data);
		obj.printTree(root);
		//obj.printTree(obj.makeTree(values, 0, values.length));
		//System.out.println(obj.makeTree(values, 0, values.length).data);
	}
}
