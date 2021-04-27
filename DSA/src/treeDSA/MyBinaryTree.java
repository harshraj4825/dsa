package treeDSA;

import java.util.Scanner;

public class MyBinaryTree {
	private StringBuilder sb = new StringBuilder();
	private Scanner sc = new Scanner(System.in);

	class Node {
		Node left, right;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	Node createTree() {
		System.out.println("Enter Value: ");
		int data = sc.nextInt();
		if (data == -1)
			return null;
		Node root = new Node(data);
		System.out.println("Enter left of " + data);
		root.left = createTree();
		System.out.println("Enter right of " + data);
		root.right = createTree();
		return root;
	}

	String printBT(Node root) {
		if (root == null)
			return sb.append(-1 + " ").toString();
		sb.append(root.data + " ");
		printBT(root.left);
		printBT(root.right);
		return sb.toString();
	}

	

}
