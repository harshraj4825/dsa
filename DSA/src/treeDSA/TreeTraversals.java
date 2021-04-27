package treeDSA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import treeDSA.MyBinaryTree.Node;

public class TreeTraversals {
	// DFS
		void preOrder(Node root) {
			if (root == null)
				return;
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}

		void inOrder(Node root) {
			if (root == null)
				return;
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);

		}

		void postOrder(Node root) {
			if (root == null)
				return;
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
		// BFS

		/*
		 * Level order top to button and left to right
		 */
		void levelOrderTBLR(Node root) {
			if (root == null)
				return;
			// ArrayList of printing
			ArrayList<Integer> ar = new ArrayList<Integer>();
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			Node temp;
			while (!queue.isEmpty()) {
				temp = queue.poll();
				ar.add(temp.data);
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			}
			System.out.println("Level order top to button and left to right : " + ar);
		}

		// Level order top to button and right to left
		void levelOrderTBRL(Node root) {
			if (root == null)
				return;
			// ArrayList of printing
			ArrayList<Integer> ar = new ArrayList<Integer>();
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			Node temp;
			while (!queue.isEmpty()) {
				temp = queue.poll();
				ar.add(temp.data);
				if (temp.right != null)
					queue.offer(temp.right);
				if (temp.left != null)
					queue.offer(temp.left);

			}
			System.out.println("Level order top to button and right to left : " + ar);
		}

		// Level order button to top and right to left
		void levelOrderBTRL(Node root) {
			if (root == null)
				return;
			// ArrayList of printing
			Queue<Node> queue = new LinkedList<Node>();
			Stack<Integer> stack = new Stack<Integer>();
			queue.add(root);
			Node temp;
			while (!queue.isEmpty()) {
				temp = queue.poll();
				stack.push(temp.data);
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			}
			System.out.print("LevelOrder button to top and right to left: ");
			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println();
		}

		// Level order button to top and left to right
		void levelOrderBTLR(Node root) {
			if (root == null)
				return;
			// ArrayList of printing
			Queue<Node> queue = new LinkedList<Node>();
			Stack<Integer> stack = new Stack<Integer>();
			queue.add(root);
			Node temp;
			while (!queue.isEmpty()) {
				temp = queue.poll();
				stack.push(temp.data);
				if (temp.right != null)
					queue.offer(temp.right);
				if (temp.left != null)
					queue.offer(temp.left);
			}
			System.out.print("LevelOrder button to top and left to right: ");
			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println();
		}
		//Zig-Zag traversal
		void zig_zag(Node root) {
			if(root==null)return ;
			ArrayList<Integer> ar=new ArrayList<Integer>();
			Stack<Node> stack1=new Stack<Node>();
			Stack<Node> stack2=new Stack<Node>();
			stack1.push(root);
			Node temp;
			while(!(stack1.isEmpty())||!(stack2.isEmpty())) {
				while(!stack1.isEmpty()) {
					temp =stack1.pop();
					ar.add(temp.data);
					if(temp.right!=null)stack2.push(temp.right);
					if(temp.left!=null)stack2.push(temp.left);
				}
				while(!stack2.isEmpty()) {
					temp =stack2.pop();
					ar.add(temp.data);
					if(temp.left!=null)stack1.push(temp.left);
					if(temp.right!=null)stack1.push(temp.right);
				}
			}
			System.out.println("Zig-Zag Traversal: "+ar);
		}

}
