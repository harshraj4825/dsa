package graphDSA;

public class AdjacencyMatrixGraph {
	int V;
	int[][] G;
	public AdjacencyMatrixGraph(int noOfvertices) {
		this.V=noOfvertices;
		this.G=new int[V][V];
	}
	//add edge
	void addEdge(int source,int destination,boolean directed) {
		G[source][destination]=1;
		if(!directed) {//if undirected graph then add destination to source
			G[destination][source]=1;
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
