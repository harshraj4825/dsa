package linkedList;

public class DoublyLinkedList {
	private class Node {
		int data;
		Node pre,next;
		public Node(int data) {
			this.data=data;
			pre=null;
			next=null;
		}
	}
	Node head=null;
	Node LastHead=null;
	void insertAtEnd(int data) {
		Node inNode=new Node(data);
		if(head==null) {
			head=inNode;
			LastHead=inNode;
			return;
		}
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=inNode;
		inNode.pre=temp;
		LastHead=inNode;
	}
	void printDLL() {
		if(head==null) {
			System.out.println("NULL");
			return;
		}
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	void printFromBack() {
		if(LastHead==null) {
			System.out.println("NULL");
			return;
		}
		Node temp=LastHead;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.pre;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		DoublyLinkedList Dll=new DoublyLinkedList();
		System.out.println("Insertion");
		Dll.printDLL();
		Dll.printFromBack();
		Dll.insertAtEnd(10);
		Dll.printDLL();
		Dll.printFromBack();
		Dll.insertAtEnd(20);
		Dll.printDLL();
		Dll.printFromBack();
	}

}
