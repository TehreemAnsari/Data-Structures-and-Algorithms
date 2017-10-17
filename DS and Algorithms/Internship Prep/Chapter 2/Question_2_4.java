package chap2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Question_2_4 {
	static Node head=null;
	static Node newLLHead=null;
	static class Node{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next=null;
		}
	}
	static Node insert(int item, Node node)
	 {
		 Node newNode=new Node(item);
		 if(node==null)
		 {
			 node=newNode;	//ie no list exist, create a ll and return it as head
		 }
		 else
		 {
			 Node curr=node;
			 while(curr.next!=null)		//go till the last node
			 {
				 curr=curr.next;
			 }
			 curr.next=newNode; 
		 }
		 return node;
	 }
	 void printList(Node node)
	 {
		 while(node!=null)
		 {
			 System.out.print(node.data+"-");
			 node=node.next;
		 }
	 }
	 void getPartition(Node node, int partitionNum)
	 {
		Node curr=node;
		/*  if(curr==head && curr.data>=partitionNum)
		 {
			newLLHead= insert(head.data,newLLHead);
			 head.next=head;
		 }
		 while(curr.next!=null) 
		 {
			 if(curr.next.data>=partitionNum)
			 {
				 insert(curr.next.data, newLLHead);
				 curr.next=curr.next.next;
			 }
			 else
			 {
				 curr=curr.next;
			 }
		 }
		 curr.next=newLLHead;*/
		LinkedList<Integer> newll=new LinkedList<>();
		if(curr==head && curr.data>=partitionNum)
		{
			newll.add(curr.data);
			head=head.next;
		}
		while(curr.next!=null)
		{
			if(curr.next.data>=partitionNum)
			{
				newll.add(curr.next.data);
				curr.next=curr.next.next;
			}
			else
			 {
				 curr=curr.next;
			 }
		}
		Iterator<Integer> itr=newll.iterator();
		while(itr.hasNext())
		{
			Node newNode=new Node(itr.next());
			curr.next=newNode;
			curr=curr.next;
		}
	 }
	 public static void main(String[] args) {
		Question_2_4 obj=new Question_2_4();
		head = insert(1, head);
		insert(9, head);
		insert(2, head);
		insert(8, head);
		insert(3, head);
		insert(7, head);
		insert(1, head);
		insert(6, head);
		insert(5, head);
		obj.printList(head);
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter partition number");
		int n=sc.nextInt();
		obj.getPartition(head, n);
		System.out.println("Parted list is");
		obj.printList(head);
		sc.close();
	}
}
