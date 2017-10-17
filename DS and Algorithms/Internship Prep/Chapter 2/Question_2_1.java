package chap2;

import java.util.HashSet;

public class Question_2_1 {
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
	 void removeDup(Node node)
	 {
		 HashSet<Integer> set=new HashSet<>();
		 if(node==head)
		 {
			 set.add(head.data);//head will always be added
		 }
		 while(node.next!=null)
		 {
			 if(set.contains(node.next.data))	//if that data is already present in the LL, just ignore it
			 {
				 node.next=node.next.next;
			 }
			 else
			 {
				 set.add(node.next.data);
				 node=node.next;
			 }
		 }
	 }
	 public static void main(String[] args) {
		Question_2_1 obj=new Question_2_1();
		obj.insert(1);
		obj.insert(2);
		obj.insert(1);
		obj.insert(2);
		obj.printList(head);
		System.out.println();
		obj.removeDup(head);
		obj.printList(head);
	}
}
