package bst;

import treeDSA.MyBinaryTree;

import java.util.ArrayList;
import java.util.Collections;

import helperUtil.Node;

public class BT_to_BST {
	public static void main(String[] args) {
		MyBinaryTree binaryTree=new MyBinaryTree();
		Node root=binaryTree.createTree();
		System.out.println(binaryTree.printBT(root));
		ArrayList<Integer> al=new ArrayList<Integer>();
		inOrder(root,al);
		System.out.println("InOrder of BT: "+al);
		Collections.sort(al);
		int count[]= {0};
		inOrder(root,count, al);
		System.out.println(al);
		System.out.println(binaryTree.printBT(root));
	}
	static void inOrder(Node root,int[] count,ArrayList<Integer> al) {
		if(root==null) {
			return;
		}
		inOrder(root.left,count, al);
		root.data=al.get(count[0]);
		count[0]++;
		inOrder(root.right,count, al);
	}
	static void inOrder(Node root,ArrayList<Integer> al) {
		if(root==null)return;
		inOrder(root.left,al);
		if(root.data!=-1)al.add(root.data);
		inOrder(root.right, al);
	}
}

