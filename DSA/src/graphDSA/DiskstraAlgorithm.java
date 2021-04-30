package graphDSA;

import java.util.Map;
import java.util.TreeMap;

public class DiskstraAlgorithm {
	/*
	 * shortest path algorithm
	 * 1. No negative edge
	 */
	int[] diskstraArray(int[][] G,int V,int source) {
		boolean[] vis=new boolean[V];
		int[] dist=new int[V];
		for(int i=0;i<V;i++) {
			dist[i]=Integer.MAX_VALUE;
			vis[i]=false;
		}
		dist[source]=0;
		for(int i=0;i<V;i++) {
			vis[source]=true;
			for(int j=0;j<V;j++) {
				if(!vis[j] && G[source][j]!=0 && (dist[source]+G[source][j]<dist[j])) {
					dist[j]=dist[source]+G[source][j];
				}
			}
			source=min(dist,vis,V);
		}
		return dist;
	}
	int min(int[] arr,boolean[] vis,int V) {
		int minNode=0;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<V;i++) {
			if(!vis[i] && arr[i]<min) {
				min=arr[i];
				minNode=i;
			}
		}
		return minNode;
	}
	/*
	 * method-2
	 * T.C O(log(E)*n)
	 * S.C=O(V+E)
	 */
	int[] diskstraTreeMap(int[][] G,int V,int source) {
		boolean[] vis=new boolean[V];
		int[] dist=new int[V];
		for(int i=0;i<V;i++) {
			dist[i]=Integer.MAX_VALUE;
			vis[i]=false;
		}
		dist[source]=0;
		TreeMap<Integer, Integer> treeMap=new TreeMap<Integer, Integer>();
		treeMap.put(dist[source], source);
		Map.Entry<Integer, Integer> temp;
		int min;
		int node;
		while(!treeMap.isEmpty()) {
			temp=treeMap.pollFirstEntry();
			node=temp.getValue();
			vis[node]=true;
			for(int j=0;j<V;j++) {
				if(!vis[j] && G[node][j]!=0 && (dist[node]+G[node][j]<dist[j])) {
					dist[j]=dist[node]+G[node][j];
					treeMap.put(dist[j], j);
				}
			}
		}
		return dist;
	}
	public static void main(String[] args) {
		WeightedGraphAM weightedGraphAM=new WeightedGraphAM(5);
		weightedGraphAM.addEdge(0, 1, true, 1);
		weightedGraphAM.addEdge(0, 2, true, 4);
		weightedGraphAM.addEdge(1, 3, true, 4);
		weightedGraphAM.addEdge(1, 2, true, 2);
		weightedGraphAM.addEdge(2, 4, true, 4);
		weightedGraphAM.addEdge(3, 4, true, 4);
		System.out.println(weightedGraphAM.toString());
		
		DiskstraAlgorithm dAlgorithm=new DiskstraAlgorithm();
		int arr[]=dAlgorithm.diskstraArray(weightedGraphAM.getGraph(),
				weightedGraphAM.getTotalNode(), 0);
		int arr1[]=dAlgorithm.diskstraTreeMap(weightedGraphAM.getGraph(),
				weightedGraphAM.getTotalNode(), 0);
		System.out.print("Dijkstra Algorithm: ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(+arr[i]+" ");
		}
		System.out.println();
		System.out.print("Dijkstra Algorithm using TreeMap:  ");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
	}
	

}
