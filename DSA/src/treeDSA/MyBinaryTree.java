package treeDSA;

import java.util.Scanner;
import helperUtil.Node;

public class MyBinaryTree {
	private StringBuilder sb = new StringBuilder();
	private Scanner sc = new Scanner(System.in);

	
	public Node createTree() {
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

	public String printBT(Node root) {
		if (root == null)
			return sb.append(-1 + " ").toString();
		sb.append(root.data + " ");
		printBT(root.left);
		printBT(root.right);
		return sb.toString();
	}

	

}
