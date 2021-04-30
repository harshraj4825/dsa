package graphDSA;

import java.util.ArrayList;
import java.util.Iterator;

public class BellmanFord {
	class Pair{
		int source;
		int distination;
		Pair(int source,int distination){
			this.distination=distination;
			this.source=source;
		}
	}
	int[] bellmanFord(int[][] G,int V,int source) {
		ArrayList<Pair> edgeList=new ArrayList<BellmanFord.Pair>();
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if(G[i][j]!=0) {
					edgeList.add(new Pair(i, j));
				}
			}
		}
		return bellmanFord(G,edgeList,V,source);
	}
	/*
	 * T.C=O(V*E)
	 * S.C=O(V)
	 */
	int[] bellmanFord(int[][] G,ArrayList<Pair> edgeList,int V,int source) {
		int[] dist=new int[V];
		for(int i=0;i<V;i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		dist[source]=0;
		for(int i=0;i<V-1;i++) {
			Iterator<Pair> it=edgeList.iterator();
			while(it.hasNext()) {
				Pair pair=it.next();
				int u=pair.source;
				int v=pair.distination;
				if(G[u][v]!=0) {
					if(dist[u]!=Integer.MAX_VALUE && dist[u]+G[u][v]<dist[v]) {
						dist[v]=dist[u]+G[u][v];
					}
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		WeightedGraphAM weightedGraphAM=new WeightedGraphAM(6);
		weightedGraphAM.addEdge(0, 1, true, 6);
		weightedGraphAM.addEdge(0, 2, true, 4);
		weightedGraphAM.addEdge(0, 3, true, 5);
		weightedGraphAM.addEdge(1, 4, true, -1);
		weightedGraphAM.addEdge(2, 1, true, -2);
		weightedGraphAM.addEdge(2, 4, true, 3);
		weightedGraphAM.addEdge(3, 2, true, -2);
		weightedGraphAM.addEdge(3, 5, true, -1);
		weightedGraphAM.addEdge(4, 5, true, 3);
		System.out.println(weightedGraphAM.toString());
		BellmanFord bellmanFord=new BellmanFord();
		int[] arr=bellmanFord.bellmanFord(weightedGraphAM.getGraph()
				,weightedGraphAM.getGraph().length , 0);
		System.out.print("Bellman Ford Distance");
		for(int i=0;i<arr.length;i++) {
			System.out.print(+arr[i]+" ");
		}
	}

}
