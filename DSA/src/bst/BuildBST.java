package bst;

import bst.BST.Node;

public class BuildBST {
	public static void main(String[] args) {
		BST bst=new BST();
		Node root = null;
		root=bst.insert(root, 30);
		root=bst.insert(root, 25);
		root=bst.insert(root, 35);
		root=bst.insert(root, 22);
		root=bst.insert(root, 27);
		root=bst.insert(root, 33);
		root=bst.insert(root, 37);
		System.out.println(bst.toString(root));
		System.out.println(bst.searchBST(root, 30));
		System.out.println(bst.searchBST(root, 27));
		System.out.println(bst.searchBST(root, 26));
		System.out.println(bst.searchBST(root, 37));
	}
}
