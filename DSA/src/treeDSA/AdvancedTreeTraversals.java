package treeDSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import treeDSA.MyBinaryTree.Node;

public class AdvancedTreeTraversals {
	class Pair{
		int hd;
		Node node;
		public Pair(int hd,Node node) {
			this.hd=hd;
			this.node=node;
		}
	}
	//Vertical Order Traversals using lever order
	void verticalTraversal(Node root) {
		
		HashMap<Integer, ArrayList<Integer>> hashmap=new HashMap<Integer, ArrayList<Integer>>();
		if(root==null)return;
		Queue<Pair> queue=new LinkedList<Pair>();
		queue.add(new Pair(0,root));
		Pair temp;
		int key;
		Node tempNode;
		while(!queue.isEmpty()) {
			temp=queue.poll();
			key=temp.hd;
			tempNode=temp.node;
			if(hashmap.containsKey(key)) {
				ArrayList<Integer> ar=hashmap.get(key);
				ar.add(tempNode.data);
				hashmap.replace(key, ar);
			}else {
				ArrayList<Integer> ar=new ArrayList<Integer>();
				ar.add(tempNode.data);
				hashmap.put(key, ar);
			}
			if(tempNode.left!=null) {
				queue.add(new Pair(key-1,tempNode.left));
			}
			if(tempNode.right!=null) {
				queue.add(new Pair(key+1,tempNode.right));
			}
		}
		System.out.println(hashmap);
	}
	void diagonalTraversal(Node root) {
		if(root==null)return;
//		HashSet<Integer> set=new HashSet<Integer>();
		HashMap<Integer, ArrayList<Integer>> hashmap=new HashMap<Integer, ArrayList<Integer>>();
		diagonalTraversalUtil(root,0,hashmap);
		System.out.println("Diagonal Traversal= "+hashmap);
	}
	private void diagonalTraversalUtil(Node root,int hd,HashMap<Integer, ArrayList<Integer>> hashmap) {
		if(root==null)return;
		if(hashmap.containsKey(hd)) {
			ArrayList<Integer> ar=hashmap.get(hd);
			ar.add(root.data);
			hashmap.replace(hd, ar);
		}else {
			ArrayList<Integer> ar=new ArrayList<Integer>();
			ar.add(root.data);
			hashmap.put(hd, ar);
		}
		if(root.right!=null) {
			diagonalTraversalUtil(root.right,hd,hashmap);
		}
		if(root.left!=null) {
			diagonalTraversalUtil(root.left,hd+1,hashmap);
		}
		
	}

}
