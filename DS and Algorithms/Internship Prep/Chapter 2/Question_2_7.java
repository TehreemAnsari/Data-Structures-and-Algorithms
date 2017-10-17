package chap2;

public class Question_2_7 {
	//this code is for Y shaped intersection: ie: 1-3-5-6-7 and 2-4-5-6-7
	//5-6-7 is the same nodes for both list
	//for intersection of X type: 5-4-3-7- and 2-3-6-1- this code wont work
	//if you just have to find intersection point, since we cannot create objects of our own type
	//we are only comparing the data value.
	//if there is a common data value, then output that common data
	//can be done by iterating n^2 times
	//Can also use set, enter all elems from list 1, iterate list 2, check if elem is already present
	//if not present, add it in set, if present, this is the intersection point
	//this wont work for duplicate enteries.
	//Similaly for finding start point of loop, while traversing a linkedlist, check if node is present in set
	//if present, this is the start of the LL, else, add the node to set
	static Node head1=null;
	static Node head2=null;
	 class Node{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next=null;
		}
	}
	 void insert(int item, int listNumber)
	 {
		 Node newNode=new Node(item);
		 if(listNumber==1)
		 {
			 if(head1==null)
			 {
				 head1=newNode;
			 }
			 else
			 {
				 Node curr=head1;
				 while(curr.next!=null)		//go till the last node
				 {
					 curr=curr.next;
				 }
				 curr.next=newNode; 
			 }
		 }
		 if(listNumber==2)
		 {
			 if(head2==null)
			 {
				 head2=newNode;
			 }
			 else
			 {
				 Node curr=head2;
				 while(curr.next!=null)		//go till the last node
				 {
					 curr=curr.next;
				 }
				 curr.next=newNode; 
			 }
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
	 int findIntersection(Node node1,Node node2)
	 {
		 int size1=0,size2=0, diff=0;
		 Node temp1=node1;
		 while(temp1!=null)
		 {
			 size1++;
			 temp1=temp1.next;
		 }
		 Node temp2=node2;
		 while(temp2!=null)
		 {
			 size2++;
			 temp2=temp2.next;
		 }
		 diff=Math.abs(size1-size2);
		 System.out.println("Difference:"+diff);
		 temp1=node1;
		 temp2=node2;
		 System.out.println("I Temp1::"+temp1);
		 System.out.println("I Temp2::"+temp2);
		 if(Math.max(size1, size2)==size1)
		 {
			 while(diff!=0)
			 {
				 System.out.println("In if(Math.max(size1, size2)==size1)");
				 temp1=temp1.next;
			 }
		 }
		 else
		 {
			 while(diff!=0)
			 {
				 System.out.println("In else...");
				 temp2=temp2.next;
			 }
		 }
		 System.out.println("II Temp1::"+temp1);
		 System.out.println("II Temp2::"+temp2);
		 while(temp1!=null)
		 {
			 if(temp1.data==temp2.data)
			 {
				 System.out.println("In if(temp1.data==temp2.data)");
				 System.out.println("temp1.data::"+temp1.data);
				 return temp1.data;
			 }
			 temp1=temp1.next;
			 temp2=temp2.next;
		 }
		 return -1;
	 }
	 public static void main(String[] args) {
		 Question_2_7 obj=new Question_2_7();
			obj.insert(5,1);
			obj.insert(4,1);
			obj.insert(3,1);
			obj.insert(7,1);
			obj.insert(2,2);
			obj.insert(3,2);
			obj.insert(6,2);
			obj.insert(1,2);
			obj.printList(head1);
			System.out.println();
			obj.printList(head2);
			System.out.println("\nIntersection:"+obj.findIntersection(head1, head2));
	}
}
