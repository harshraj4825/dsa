package bst;

import bst.BST.Node;

public class BuildBST {
	public static void main(String[] args) {
		BST bst=new BST();
		Node root = null;
		//insertion
		root=bst.insert(root, 30);
		root=bst.insert(root, 25);
		root=bst.insert(root, 35);
		root=bst.insert(root, 22);
		root=bst.insert(root, 27);
		root=bst.insert(root, 33);
		root=bst.insert(root, 37);
		System.out.println(bst.toString(root));
		//Searching in BST
		System.out.println("Element Found(27): "+bst.searchBST(root, 27));
		System.out.println("Element Found(26): "+bst.searchBST(root, 26));
		//Maximum and Minimum in BST
		System.out.println("Maximum element: "+bst.maxBST(root));
		System.out.println("Minimum element: "+bst.minBST(root));
		//Deletion in BST(important)
		bst.deleteNode(root, 35);
		System.out.println("Delete of 35 : "+bst.toString(root));
		//
		//
	}
}
