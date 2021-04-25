package linkedListDSA;


public class BuildLinkedList {
	
	public static void main(String[] args) {
		
		MyLinkedList ll=new MyLinkedList();
		MyLinkedList.Node head;
		head=ll.insert(1);
		head=ll.insert(2);
		head=ll.insert(3);
		head=ll.insert(4);
		
		System.out.println(ll.print(head));
		MyLinkedList.Node reverseHead=ll.reverse(head);
		System.out.println(ll.print(reverseHead));
	}

}

