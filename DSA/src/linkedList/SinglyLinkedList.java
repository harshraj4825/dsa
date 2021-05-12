package linkedList;


public class SinglyLinkedList {
	class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	Node head=null;
	//insert at end
	void insertAtEnd(int data) {
		if(head==null) {
			head=new Node(data);
			return;
		}
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=new Node(data);
	}
	//insert at start
	void insertAtBeginning(int data) {
		if(head==null) {
			head=new Node(data);
			return;
		}
		Node temp=new Node(data);
		temp.next=head;
		head=temp;
		
	}
	//insert at a index
	//index start from 0
	void insertAtIndex(int index,int data) {
		int count=0;
		
		Node inNode=new Node(data);
		if(index==0){
			inNode.next=head;
			head=inNode;
			return;
		}
		else if(index>getSize()) {
			System.out.println("indexOutofBound");
			System.out.println("Please insert at index <= "+getSize());
			return;
		}
		Node temp=head;
		Node preVious=null;
		while(count<index) {
			count++;
			preVious=temp;
			temp=temp.next;
		}
		inNode.next=temp;
		preVious.next=inNode;
	}
	//reverse LinledList
	void reverse() {
		Node temp=head;
		Node preVious=null;
		Node next=head;
		while(temp!=null) {
			next=temp.next;
			temp.next=preVious;
			preVious=temp;
			temp=next;
		}
		head=preVious;
	}
	//get size of LinkedList
	int getSize() {
		int count=0;
		Node temp=head;
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
		return count;
	}
	void printLL(){
		if(head==null) {
			System.out.println("Null");
			return;
		}
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		SinglyLinkedList ll=new SinglyLinkedList();
		ll.printLL();
		int size=ll.getSize();
		System.out.println("Size of LinkedList: "+size);
		
		ll.insertAtEnd(8);
		ll.printLL();
		size=ll.getSize();
		System.out.println("Size of LinkedList: "+size);
		ll.insertAtEnd(10);
		ll.insertAtEnd(11);
		ll.printLL();
		size=ll.getSize();
		System.out.println("Size of LinkedList: "+size);
		
		ll.insertAtBeginning(15);
		ll.printLL();
		size=ll.getSize();
		System.out.println("Size of LinkedList: "+size);
		
		ll.insertAtIndex(0, 20);
		ll.printLL();
		size=ll.getSize();
		System.out.println("Size of LinkedList: "+size);
		ll.insertAtIndex(2, 25);
		ll.printLL();
		size=ll.getSize();
		System.out.println("Size of LinkedList: "+size);
		ll.insertAtIndex(6, 50);
		ll.printLL();
		size=ll.getSize();
		System.out.println("Size of LinkedList: "+size);
		ll.insertAtIndex(8, 50);
		ll.printLL();
		size=ll.getSize();
		System.out.println("Size of LinkedList: "+size);
		
		ll.reverse();
		ll.printLL();
		size=ll.getSize();
		System.out.println("Size of LinkedList: "+size);
		
	}
	

}
