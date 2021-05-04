package graphDSA;

import java.util.Arrays;

public class PrimsAlgoritmMST {
	int[][] primAlgorithmMST(int[][] G,int V){
		int distance[]=new int[V];
		boolean vis[]=new boolean[V];
		int[] parent=new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		int source=0;
		distance[source]=0;
		parent[source]=-1;
		for(int i=0;i<V;i++) {
			vis[source]=true;
			for(int j=0;j<V;j++) {
				if(G[source][j]!=0 && !vis[j]) {
					if(distance[j]>G[source][j]) {
						distance[j]=G[source][j];
						parent[j]=source;
					}
				}
			}
			source=minNode(V,vis,distance);
			
		}
		int ans[][]=new int[V][V];
		for(int i=0;i<V;i++) {
			if(i!=source) {
				ans[parent[i]][i]=G[parent[i]][i];
				ans[i][parent[i]]=G[parent[i]][i];
			}
		}
		return ans;
	}
	void print(int[][] G,int V) {
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				System.out.print(G[i][j]+" ");
			}
			System.out.println();
		}
	}
	int minNode(int V,boolean vis[],int dis[]) {
		int min=Integer.MAX_VALUE;
		int node=0;
		for(int i=0;i<V;i++) {
			if(!vis[i]) {
				if(min>dis[i]) {
					min=dis[i];
					node=i;
				}
			}
		}
		return node;
	}

	public static void main(String[] args) {
		WeightedGraphAM weightedGraphAM = new WeightedGraphAM(5);
		weightedGraphAM.addEdge(0, 1, false, 4);
		weightedGraphAM.addEdge(0, 2, false, 1);
		weightedGraphAM.addEdge(1, 2, false, 2);
		weightedGraphAM.addEdge(1, 4, false, 4);
		weightedGraphAM.addEdge(2, 3, false, 2);
		weightedGraphAM.addEdge(3, 4, false, 3);
		System.out.println(weightedGraphAM.toString());
		
		PrimsAlgoritmMST algoritmMST=new PrimsAlgoritmMST();
		int[][] ans=algoritmMST.primAlgorithmMST(weightedGraphAM.getGraph(), weightedGraphAM.getTotalNode());
		algoritmMST.print(ans, weightedGraphAM.getTotalNode());
	}
}
