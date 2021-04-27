package graphDSA;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
	void topologicalSort(ArrayList<Integer> G[]) {
		int[] vis = new int[G.length];
		Stack<Integer> stack=new Stack<Integer>();
		for (int i = 0; i < G.length; i++) {
			if (vis[i] == 0) {
				dfsUtil(G, i, vis,stack);
			}
		}
		System.out.print("Topological Sort: ");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	void dfsUtil(ArrayList<Integer> G[],int start,int[] vis,Stack<Integer> stack) {
		ArrayList<Integer> temp=G[start];
		vis[start]=1;
		for(int i=0;i<temp.size();i++) {
			if(vis[temp.get(i)]==0) {
				dfsUtil(G, temp.get(i), vis,stack);
				
			}
		}
		stack.push(start);
		
	}

	public static void main(String[] args) {
		AdjacencyListUsingArray alGArr1 = new AdjacencyListUsingArray(6);
		alGArr1.addEdge(1, 0, true);
		alGArr1.addEdge(1, 3, true);
		alGArr1.addEdge(2, 0, true);
		alGArr1.addEdge(2, 4, true);
		alGArr1.addEdge(3, 5, true);
		alGArr1.addEdge(4, 5, true);
		System.out.println(alGArr1.toString());
		TopologicalSort sort=new TopologicalSort();
		sort.topologicalSort(alGArr1.getGraph());
		
		
	}

}
