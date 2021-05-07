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
	//Searching maximum in BST
	int maxBST(Node root) {
		if(root==null)return -1;
		if(root.left==null&&root.right==null)return root.val;
		else if(root.right!=null)return maxBST(root.right);
		else return maxBST(root.left);
	}
	//Searching minimum in BST
	int minBST(Node root) {
		if(root==null)return -1;
		if(root.left==null&&root.right==null)return root.val;
		else if(root.left!=null)return minBST(root.left);
		else return minBST(root.right);
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
