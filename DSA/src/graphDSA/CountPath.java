package graphDSA;

import java.util.ArrayList;

public class CountPath {
	int countPath(ArrayList<Integer> G[],int V,int source,int destination) {
		int[] count= {0};
		boolean vis[]=new boolean[V];
		
		dfs(G,V,source,destination,vis,count);
		return count[0];
	}
	/*
	 * T.C= O(V+E)
	 */
	void dfs(ArrayList<Integer> G[],int V,int source,int destination,
			boolean[] vis,int[] count) {
		if(source==destination) {
			count[0]++;
			return;
		}
		vis[source]=true;
		for(int i:G[source]) {
			if(!vis[i]) {
				dfs(G,V,i,destination,vis,count);
			}
		}
		vis[source]=false;
	}
	public static void main(String[] args) {
		AdjacencyListUsingArray adjacencyListUsingArray=new AdjacencyListUsingArray(4);
		adjacencyListUsingArray.addEdge(0, 1, true);
		adjacencyListUsingArray.addEdge(0, 2, true);
		adjacencyListUsingArray.addEdge(0, 3, true);
		adjacencyListUsingArray.addEdge(1, 2, true);
		adjacencyListUsingArray.addEdge(2, 3, true);
		System.out.println(adjacencyListUsingArray.toString());
		CountPath countPath=new CountPath();
		System.out.println(
				countPath.countPath(adjacencyListUsingArray.getGraph(), 
				adjacencyListUsingArray.getGraph().length, 0, 3));
	}

}
