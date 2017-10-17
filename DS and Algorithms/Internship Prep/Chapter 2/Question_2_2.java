package chap2;

import java.util.Scanner;

public class Question_2_2 {
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
	int returnKthLast(Node node, int k)
	{
		Node p1=node,p2=node;
		int increaseby=k;
		while(increaseby!=0)
		{
			if(p1.next!=null)
			{
				p1=p1.next;
				increaseby--;
			}
			else
			{
				System.out.println("Out of bound");
				return -1;
			}
		}
		while(p1!=null)
		{
			p2=p2.next;
			p1=p1.next;
		}
		return p2.data;
	}
	public static void main(String[] args) {
		Question_2_2 obj=new Question_2_2();
		obj.insert(5);
		obj.insert(4);
		obj.insert(3);
		obj.insert(2);
		obj.insert(0);
		obj.insert(1);
		obj.printList(head);
		System.out.println("Enter k");
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		System.out.println(k+"th last elem is:"+obj.returnKthLast(head, k));
		sc.close();
	}
}
