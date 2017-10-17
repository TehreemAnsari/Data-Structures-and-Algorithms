package basic;

public class ReverseLL_2 {
	static Node head=null;
	 class Node{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next=null;
		}
	}
	 void insert(int item)
	 {
		 Node newNode=new Node(item);
		 if(head==null)
		 {
			 head=newNode;
		 }
		 else
		 {
			 Node curr=head;
			 while(curr.next!=null)		//go till the last node
			 {
				 curr=curr.next;
			 }
			 curr.next=newNode; 
		 }
	 }
	 void printList(Node node)
	 {
		 while(node!=null)
		 {
			 System.out.print(node.data+"-");
			 node=node.next;
		 }
	 }
	 Node reverseUtil(Node curr, Node prev)
	 {
		 if(curr.next==null)
		 {
			 head=curr;
			 curr.next=prev;
			 return null; 	//here if we have return head; too, it works same, why?
		 }
		 Node next1=curr.next;
		 curr.next=prev;
		 reverseUtil(next1, curr);
		 return head;
	 }
	 public static void main(String[] args) {
		ReverseLL_2 obj=new ReverseLL_2();
		obj.insert(1);
		obj.insert(2);
		obj.insert(3);
		obj.insert(4);
		obj.insert(5);
		obj.printList(head);
		System.out.println();
		obj.reverseUtil(head, null);
		obj.printList(head);
	}
}
