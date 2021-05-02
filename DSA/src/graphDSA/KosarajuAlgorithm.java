package graphDSA;

import java.util.Stack;

public class KosarajuAlgorithm {
	int kosaraju(int G[][], int V) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean vis[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				dfs(G, V, i, vis, stack);
			}
		}
		vis = new boolean[V];
		reverseGraph(G, V);
		int temp;
		int count=0;
		while(!stack.isEmpty()) {
			temp=stack.pop();
			if(!vis[temp]) {
				DFS(G,V,temp,vis);
				count++;	
			}
		}
		return count;
	}

	void dfs(int[][] G, int V, int source, boolean[] vis, Stack<Integer> stack) {
		vis[source] = true;
		for (int i = 0; i < V; i++) {
			if (G[source][i] != 0 && vis[i] == false) {
				dfs(G, V, i, vis, stack);
			}
		}
		stack.add(source);
	}
	void DFS(int[][] G, int V, int source, boolean[] vis) {
		vis[source] = true;
		for (int i = 0; i < V; i++) {
			if (G[source][i] != 0 && vis[i] == false) {
				DFS(G, V, i, vis);
			}
		}
	}

	void reverseGraph(int[][] G, int V) {
		for (int i = 0; i < V; i++) {
			for (int j = i; j < V; j++) {
				int temp = G[i][j];
				G[i][j] = G[j][i];
				G[j][i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		WeightedGraphAM weightedGraphAM = new WeightedGraphAM(10);
		weightedGraphAM.addEdge(0, 1, true, 3);
		weightedGraphAM.addEdge(1, 2, true, 6);
		weightedGraphAM.addEdge(2, 0, true, 6);
		weightedGraphAM.addEdge(2, 3, true, 2);
		weightedGraphAM.addEdge(3, 4, true, 4);
		weightedGraphAM.addEdge(4, 3, true, 2);
		weightedGraphAM.addEdge(5, 4, true, 1);
		weightedGraphAM.addEdge(5, 6, true, 1);
		weightedGraphAM.addEdge(6, 7, true, 2);
		weightedGraphAM.addEdge(6, 9, true, 4);
		weightedGraphAM.addEdge(7, 8, true, 4);
		weightedGraphAM.addEdge(8, 5, true, 2);
		System.out.println(weightedGraphAM.toString());
		KosarajuAlgorithm algorithm = new KosarajuAlgorithm();
		System.out.println("Kosaraju Algorithm: ");
		System.out.println("No. of strongly connected component: "
				+ algorithm.kosaraju(weightedGraphAM.getGraph(), weightedGraphAM.getTotalNode()));
	}

}
