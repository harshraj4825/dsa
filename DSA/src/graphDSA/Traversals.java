package graphDSA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Traversals {
	/* Breadth First Search
	 * T.C= O(V+E)
	 * S.C=O(V+E)
	 */
	void bfs(ArrayList<Integer> G[],int source) {
		Queue<Integer> queue=new LinkedList<Integer>();
		int vis[]=new int[G.length];
		queue.add(source);
		vis[source]=1;
		int temp; 
		ArrayList<Integer> tempAr;
		System.out.print("BFS Traversal: ");
		while(!queue.isEmpty()) {
			temp=queue.poll();
			System.out.print(temp+" ");
			tempAr=G[temp];
			
			for(int i=0;i<tempAr.size();i++) {
				if(vis[tempAr.get(i)]==0) {
					vis[tempAr.get(i)]=1;
					queue.add(tempAr.get(i));
				}
			}
		}
		System.out.println();
	}
	/*
	 * Depth First Search
	 * T.C= O(V+E);
	 * S.C= O(V+E)
	 */
	void dfs(ArrayList<Integer> G[],int source) {
		int vis[]=new int[G.length];
		System.out.print("DFS Traversal: ");
		dfsUtil(G,0,vis);
	}
	void dfsUtil(ArrayList<Integer> G[],int source,int[] vis) {
		ArrayList<Integer> temp=G[source];
		vis[source]=1;
		System.out.print(source+" ");
		for(int i=0;i<temp.size();i++) {
			if(vis[temp.get(i)]==0) {
				dfsUtil(G, temp.get(i), vis);
			}
		}
	}
	public static void main(String[] args) {
		AdjacencyListUsingArray alGArr=new AdjacencyListUsingArray(7);
		alGArr.addEdge(0, 1, false);
		alGArr.addEdge(0, 3, false);
		alGArr.addEdge(0, 4, false);
		alGArr.addEdge(0, 2, false);
		alGArr.addEdge(1, 2, false);
		alGArr.addEdge(1, 5, false);
		alGArr.addEdge(2, 6, false);
		alGArr.addEdge(3, 6, false);
		alGArr.addEdge(4, 5, false);
		System.out.println(alGArr.toString());
		//traversal
		Traversals traversals=new Traversals();
		//breadth first search
		traversals.bfs(alGArr.getGraph(), 0);
		//Depth first search
		traversals.dfs(alGArr.getGraph(), 0);
		
	}
	

}
