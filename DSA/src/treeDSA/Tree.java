package treeDSA;
import helperUtil.Node;

public class Tree {

	public static void main(String[] args) {
		MyBinaryTree bt=new MyBinaryTree();
		Node root =bt.createTree();
		System.out.println(bt.printBT(root));
		
		TreeTraversals treeTraversal=new TreeTraversals();
		//DFS
		System.out.print("Print PreOrder DFS: ");
		treeTraversal.preOrder(root);
		System.out.println();
		System.out.print("Print InOrder DFS: ");
		treeTraversal.inOrder(root);
		System.out.println();
		System.out.print("Print PostOrder DFS: ");
		treeTraversal.postOrder(root);
		System.out.println();
		
		//BFS
		treeTraversal.levelOrderTBLR(root);
		treeTraversal.levelOrderTBRL(root);
		treeTraversal.levelOrderBTLR(root);
		treeTraversal.levelOrderBTRL(root);
		treeTraversal.zig_zag(root);
		
		//Advanced Tree Traversal
		AdvancedTreeTraversals advancedTreeTraversals=new AdvancedTreeTraversals();
		//Vertical Order Traversal
		advancedTreeTraversals.verticalTraversal(root);
		advancedTreeTraversals.diagonalTraversal(root);
		
		
	}

}
