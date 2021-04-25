package linkedListDSA;

public class MyLinkedList {
	private Node head;
	private int size;
	public MyLinkedList() {
		this.head=null;
		size=0;
	}
	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node insert(int data) {
		Node new_node = new Node(data);
//		new_node.next = null;

		if (head == null) {
			head = new_node;
			size++;
		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new_node;
			size++;
		}
		return head;
	}
	int size() {
		return size;
	}
	Node reverse(Node head) {
		Node revrsedList=null;
		Node curr=head;
		Node tempNext=null;
		while(curr!=null) {
			tempNext=curr.next;
			curr.next=revrsedList;
			revrsedList=curr;
			curr=tempNext;
		}
		return revrsedList;
	}
	String print(Node head) {
		StringBuilder sb=new StringBuilder();
		Node temp=head;
		while(temp!=null) {
			sb.append(temp.data+"-->");
			temp=temp.next;
		}
		sb.append("null");
		return sb.toString();
	}
	
}
