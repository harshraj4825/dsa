package graphDSA;
// Adjacency matrix of weighted graph
public class WeightedGraphAM {
	private int V;
	private int[][] G;
	public WeightedGraphAM(int noOfvertices) {
		this.V=noOfvertices;
		this.G=new int[V][V];
	}
	int[][] getGraph() {
		return G;
	}
	int getTotalNode() {
		return V;
	}
	//add edge
	void addEdge(int source,int destination,boolean directed,int weight) {
		G[source][destination]=weight;
		if(!directed) {//if undirected graph then add destination to source
			G[destination][source]=weight;
		}
	}
	//remove edge
	void removeEdge(int source,int destination,boolean directed) {
		G[source][destination]=0;
		if(!directed) {//if directed then don't remove
			G[destination][source]=0;
		}
	}
	//print Graph
	 public String toString() {
		    StringBuilder s = new StringBuilder();
		    for (int i = 0; i < V; i++) {
		      for (int j : G[i]) {
		        s.append(j + " ");
		      }
		      s.append("\n");
		    }
		  return s.toString();
	}

}
