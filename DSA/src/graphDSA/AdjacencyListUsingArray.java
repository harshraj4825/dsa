package graphDSA;

import java.util.ArrayList;

public class AdjacencyListUsingArray {
	private ArrayList<Integer> G[];
	public AdjacencyListUsingArray(int verices) {
		G=new ArrayList[verices];
		for(int i=0;i<verices;i++) {
			G[i]=new ArrayList<Integer>();
		}
	}
	ArrayList<Integer>[] getGraph() {
		return G;
	}
	
	//add edge
	void addEdge(int source,int destination,boolean directed) {
		{
			ArrayList<Integer> al=G[source];
			al.add(destination);
			G[source]=al;
		}
		
		if(!directed) {//if undirected graph then add destination to source
			ArrayList<Integer> al=G[destination];
			al.add(source);
			G[destination]=al;
		}
	}
	//remove edge
	void removeEdge(int source,int destination,boolean directed) {
		{
			ArrayList<Integer> ar=G[source];
			Integer init=destination;
			ar.remove(init);
			G[source]= ar;
		}
		if(!directed) {//if directed then don't remove
			ArrayList<Integer> ar=G[destination];
			ar.remove(new Integer(source));
			G[destination]= ar;
		}
	}
	//print Graph
	 public String toString() { 
		 StringBuilder sb=new StringBuilder();
		 for(int i=0;i<G.length;i++) {
			 sb.append(i+"-> ");
			 for(int j=0;j<G[i].size();j++) {
				 sb.append(G[i].get(j)+" ");
			 }
			 sb.append("\n");
		 }
		  return sb.toString();
	}

}
