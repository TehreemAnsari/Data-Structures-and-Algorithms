package basic;

class SLLNode{
	int data;
	SLLNode next;
}

public class SingleLinkedList {
	SLLNode head=null;
	void insert(int item) 
	{
		SLLNode newNode=new SLLNode();
		newNode.data=item;
		newNode.next=null;
		if(head==null)
		{
			head=newNode;
			System.out.println("LL created, inserted at head");
		}
		else
		{
			SLLNode currNode=new SLLNode();
			currNode=head;
			while(currNode.next!=null)
			{
				currNode=currNode.next;
			}
			currNode.next=newNode;
			System.out.println("Node inserted");
		}
		print();
	}
	void search(int item)
	{
		if(head==null)
		{
			System.out.println("LL not present");
		}
		else
		{
			SLLNode currNode=new SLLNode();
			currNode=head;
			while(currNode.next!=null && currNode.data!=item)
			{
				currNode=currNode.next;
			}
			if(currNode.data==item)
			{
				System.out.println("Item found");
			}
			else
			{
				System.out.println("item not found");
			}
			
		}
		print();
	}
	void delete(int item)
	{
		if(head==null)
		{
			System.out.println("LL not present");
		}
		else
		{
			SLLNode currNode=new SLLNode();
			currNode=head;
			while(currNode.next!=null)
			{
				if(currNode.next.data==item)
				{
					currNode.next=currNode.next.next;
					System.out.println("Item deleted");
					return;
				}
				currNode=currNode.next;
			}
			System.out.println("Item not found");
			
		}
		print();
	}
	void print()
	{
		SLLNode currNode=new SLLNode();
		currNode=head;
		while (currNode!=null) {
			System.out.print(currNode.data+"-");
			currNode=currNode.next;
		}
		System.out.print("LL over\n");
	}
	public static void main(String[] args) {
		SingleLinkedList sllObj=new SingleLinkedList();
		sllObj.insert(3);
		sllObj.insert(9);
		//sllObj.delete(5);
		sllObj.insert(7);
		sllObj.search(7);
		sllObj.delete(9);
		sllObj.delete(5);
		//System.out.println("Contents of sllObj"+sllObj);
	}
}
