package graphDSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class TarjonAlgorithm {
	/*
	 * T.C=O(V+E)
	 * S.C=O(4V)=O(V)
	 */
	int tarjonAlgo(Map<Integer, ArrayList<Integer>> G,int V) {
		int discover[]=new int[V];
		Arrays.fill(discover, -1);
		int minTime[]=new int[V];
		Stack<Integer> stack=new Stack<Integer>();
		boolean[] inStack=new boolean[V];
		int count=0;
		dfs(G,V,0,stack,discover,minTime,inStack,0);
		int flag=0;
		for(int i=V-1;i>=0;i--) {
			flag++;
			if(minTime[i]==discover[i]) {
				System.out.print("List of "+(count+1)+" Strogly connected component: ");
				while(flag>0) {
					System.out.print(stack.pop()+" ");
					flag--;
				}
				System.out.println();
				count++;
			}
		}
		return count;
	}
	void dfs(Map<Integer, ArrayList<Integer>> G,int V,int start,
			Stack<Integer> stack,
			int[] discover,int[] minTime,boolean[] inStack,
			int time) {
		discover[start]=time;
		minTime[start]=time;
		stack.push(start);
		inStack[start]=true;
		ArrayList<Integer> al=G.get(start);
		Iterator<Integer> it=al.iterator();
		while(it.hasNext()) {
			int temp=it.next();
			if(discover[temp]==-1) {
				dfs(G,V,temp,stack,discover,minTime,inStack,temp);
				minTime[start]=Math.min(minTime[start], minTime[temp]);
			}
			if(inStack[temp]==true) {
				minTime[start]=Math.min(minTime[start], discover[temp]);
			}
		}	
	}
	public static void main(String[] args) {
		AdjacencyListGraph_Map adjacencyListGraph_Map=new AdjacencyListGraph_Map();
		adjacencyListGraph_Map.addEdge(0, 1, true);
		adjacencyListGraph_Map.addEdge(1, 2, true);
		adjacencyListGraph_Map.addEdge(2, 3, true);
		adjacencyListGraph_Map.addEdge(3, 0, true);
		adjacencyListGraph_Map.addEdge(1, 4, true);
		adjacencyListGraph_Map.addEdge(4, 5, true);
		adjacencyListGraph_Map.addEdge(5, 6, true);
		adjacencyListGraph_Map.addEdge(6, 4, true);
		System.out.println(adjacencyListGraph_Map.toString());
		TarjonAlgorithm algorithm=new TarjonAlgorithm();
		int ans=algorithm.tarjonAlgo(adjacencyListGraph_Map.getGraph(), adjacencyListGraph_Map.totalVertex());
		System.out.println("# of strongly conncted component is: "+ans);
	}

}
