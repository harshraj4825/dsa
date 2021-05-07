package bst;

public class BST {
	class Node{
		int val;
		Node left,right;
		public Node(int val) {
			this.val=val;
			left=null;
			right=null;
		}
	}
	//insert in BST
	Node insert(Node root,int val) {
		if(root==null) return new Node(val);
		if(val==root.val)return root;
		if(val<root.val)root.left=insert(root.left,val);
		if(val>root.val)root.right=insert(root.right,val);
		return root;
	}
//	Node delete(Node root,int val) {
//		
//	}
	//search in BST
	boolean searchBST(Node root,int val) {
		if(root==null)return false;
		if(root.val==val)return true;
		else if(val<root.val)return searchBST(root.left,val);
		else return searchBST(root.right,val);
	}
	//print BST
	String toString(Node root) {
		StringBuilder sb=new StringBuilder();
		inOrederHelper(root,sb);
		return sb.toString();
	}
	void inOrederHelper(Node root,StringBuilder sb) {
		if(root==null)return ;
		inOrederHelper(root.left,sb);
		sb.append(root.val+" ");
		inOrederHelper(root.right,sb);	
	}
}
