package chap2;

public class Question_2_6 {
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
	 boolean isPalindrome(Node node)
	 {
		 int numberOfNodes=0;
		 Node curr=node;
		 while(curr!=null)
		 {
			 numberOfNodes++;
			 curr=curr.next;
		 }
		 int seen=0;
		 curr=node;
		 while(curr!=null)
		 {
			 int temp=0;
			 Node trav=node;
			 while(trav!=null && temp!=numberOfNodes-1-seen)
			 {
				 trav=trav.next;
				 temp++;
			 }
			 if(trav.data==curr.data)
			 {
				 curr=curr.next;
				 seen++;
			 }
			 else if(trav.data!=curr.data)
			 {
				 return false;
			 }
		 }
		 return true;
	 }
	 public static void main(String[] args) {
		Question_2_6 obj=new Question_2_6();
		obj.insert(1);
		obj.insert(2);
		obj.insert(3);
		obj.insert(2);
		obj.insert(1);
		obj.printList(head);
		System.out.println("\nIs Palindrom? "+obj.isPalindrome(head));
	}
}
