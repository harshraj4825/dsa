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
	//insert in BST
	Node insert(Node root,int val) {
		if(root==null) return new Node(val);
		if(val==root.val)return root;
		if(val<root.val)root.left=insert(root.left,val);
		if(val>root.val)root.right=insert(root.right,val);
		return root;
	}
	//Deletion in BST
	Node deleteNode(Node root,int val) {
		if(root==null)return null;
		if(root.val==val) {
			if(root.left==null && root.right==null) {
				root=null;
			}
			else if(root.left!=null && root.right!=null) {
				Node temp=util(root.left);
				root.val=temp.val;
				root.left=deleteNode(root.left,temp.val);
				return root;
			}
			else if(root.left!=null) {
				return root.left;
			}
			else {
				return root.right;
			}
		}
		else if(val<root.val) {
			root.left=deleteNode(root.left,val);
		}else {
			root.right=deleteNode(root.right,val);
		}
		return root;
	}
	Node util(Node root) {
		if(root==null)return null;
		if(root.left==null&&root.right==null)return root;
		else if(root.left!=null)return util(root.left);
		else return util(root.right);
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
