package graphDSA;

import java.util.ArrayList;

public class MotherVertex {
	/*
	 * T.C =O(V+E);
	 * worst T.C=O(V(V+E))
	 */
	boolean motherVertex(ArrayList<Integer> G[],int V) {
		boolean[] vis=new boolean[V];
		int lastDfsNode=0;
		for(int i=0;i<V;i++) {
			if(!vis[i]) {
				dfs(G,V,i,vis);
				lastDfsNode=i;
			}
			
		}
//		int count=0;
		vis=new boolean[V];
		dfs(G,V,lastDfsNode,vis);
		for(int i=0;i<V;i++) {
			if(!vis[i])return false;
		}
		return true;
	}
	void dfs(ArrayList<Integer> G[],int V,int source,boolean[] vis) {
		ArrayList<Integer> temp=G[source];
		vis[source]=true;
		for(int i:temp) {
			if(!vis[i]) {
				dfs(G,V,i,vis);
			}
		}
	}
	public static void main(String[] args) {
		AdjacencyListUsingArray alGArr=new AdjacencyListUsingArray(6);
		alGArr.addEdge(0, 1, true);
		alGArr.addEdge(1, 2, true);
		alGArr.addEdge(2, 3, true);
		alGArr.addEdge(4, 5, true);
		alGArr.addEdge(5, 0, true);
		System.out.println(alGArr.toString());
		
		MotherVertex vertex=new MotherVertex();
		System.out.println(vertex.motherVertex(alGArr.getGraph(), alGArr.getGraph().length));
		
	}

}
