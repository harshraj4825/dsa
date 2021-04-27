package graphDSA;

import java.util.ArrayList;

public class DetectCycle {
	/*
	 * Detect cycle in undirected graph T.C=O(V+E) S.C=O(N)
	 */
	boolean detectCycleUndirected(ArrayList<Integer> G[]) {
		int[] vis = new int[G.length];
		for (int i = 0; i < G.length; i++) {
			if (vis[i] == 0) {
				if (detectCycleUtil(G, i, vis, -1))
					return true;
			}
		}
		return false;
	}

	boolean detectCycleUtil(ArrayList<Integer> G[], int start, int[] vis, int parent) {
		ArrayList<Integer> temp = G[start];
		vis[start] = 1;
		for (int i = 0; i < temp.size(); i++) {
			if (vis[temp.get(i)] == 0) {
				if (detectCycleUtil(G, temp.get(i), vis, start)) {
					return true;
				}
			} else if (temp.get(i) != parent)
				return true;
		}
		return false;
	}

	/*
	 * Detect cycle in directed graph T.C=O(V+E) S.C=O(N)
	 */
	boolean detectCycledirected(ArrayList<Integer> G[]) {
		int[] vis = new int[G.length];
		int[] ancestor = new int[G.length];
		for (int i = 0; i < G.length; i++) {
			if (vis[i] == 0) {
				if (detectCycleUtil(G, i, vis, ancestor))
					return true;
			}
		}
		return false;
	}

	boolean detectCycleUtil(ArrayList<Integer> G[], int start, int[] vis, int[] ancestor) {
		vis[start] = 1;
		ancestor[start] = 1;
		ArrayList<Integer> temp = G[start];
		for (int i = 0; i < temp.size(); i++) {
			if (vis[temp.get(i)] == 0) {
				if (detectCycleUtil(G, temp.get(i), vis, ancestor)) {
					return true;
				}
			} else if (ancestor[temp.get(i)]==1)
				return true;
		}
		ancestor[start]=0;
		return false;
	}

	public static void main(String[] args) {
		AdjacencyListUsingArray alGArr = new AdjacencyListUsingArray(7);
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
		DetectCycle detectCycle = new DetectCycle();
		boolean res = detectCycle.detectCycleUndirected(alGArr.getGraph());
		System.out.println("Cycle detected for undirected Graph: " + res);
		AdjacencyListUsingArray alGArr1 = new AdjacencyListUsingArray(4);
		alGArr1.addEdge(0, 1, true);
		alGArr1.addEdge(0, 2, true);
		alGArr1.addEdge(0, 3, true);
		alGArr1.addEdge(1, 2, true);
		alGArr1.addEdge(1, 3, true);
		alGArr1.addEdge(2, 3, true);
//		alGArr1.addEdge(4, 5, true);
//		alGArr1.addEdge(5, 6, true);
//		alGArr1.addEdge(6, 7, true);
//		alGArr1.addEdge(7, 6, true);
		
		System.out.println(alGArr1.toString());
		boolean res1 = detectCycle.detectCycledirected(alGArr1.getGraph());
		System.out.println("Cycle detected for directed Graph: " + res1);
	}

}
