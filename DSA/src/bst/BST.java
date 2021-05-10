package bst;
import helperUtil.Node;
public class BST {
//	class Node{
//		
//	}
	//search in BST
	boolean searchBST(Node root,int val) {
		if(root==null)return false;
		if(root.data==val)return true;
		else if(val<root.data)return searchBST(root.left,val);
		else return searchBST(root.right,val);
	}
	//Searching maximum in BST
	int maxBST(Node root) {
		if(root==null)return -1;
		if(root.left==null&&root.right==null)return root.data;
		else if(root.right!=null)return maxBST(root.right);
		else return maxBST(root.left);
	}
	//Searching minimum in BST
	int minBST(Node root) {
		if(root==null)return -1;
		if(root.left==null&&root.right==null)return root.data;
		else if(root.left!=null)return minBST(root.left);
		else return minBST(root.right);
	}
	//insert in BST
	Node insert(Node root,int val) {
		if(root==null) return new Node(val);
		if(val==root.data)return root;
		if(val<root.data)root.left=insert(root.left,val);
		if(val>root.data)root.right=insert(root.right,val);
		return root;
	}
	//Deletion in BST
	Node deleteNode(Node root,int val) {
		if(root==null)return null;
		if(root.data==val) {
			if(root.left==null && root.right==null) {
				root=null;
			}
			else if(root.left!=null && root.right!=null) {
				Node temp=util(root.left);
				root.data=temp.data;
				root.left=deleteNode(root.left,temp.data);
				return root;
			}
			else if(root.left!=null) {
				return root.left;
			}
			else {
				return root.right;
			}
		}
		else if(val<root.data) {
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
		sb.append(root.data+" ");
		inOrederHelper(root.right,sb);	
	}
}
