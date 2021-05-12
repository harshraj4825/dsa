package linkedList;

class Node{
	int data;
	Node next;
	public Node(int data) {
		this.data=data;
		this.next=null;
	}
}
public class SinglyLinkedList {
	Node head=null;
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
	}
	

}
