package graphDSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdjacencyListGraph_Map {
	private Map<Integer, ArrayList<Integer>> G;
	public AdjacencyListGraph_Map() {
		G=new HashMap<Integer, ArrayList<Integer>>();
	}
	Map<Integer, ArrayList<Integer>> getGraph(){
		return G;
	}
	int totalVertex() {
		return G.size();
	}
	//add edge
	void addEdge(int source,int destination,boolean directed) {
		if(G.containsKey(source)) {
			ArrayList<Integer> ar=G.get(source);
			ar.add(destination);
			G.put(source, ar);
		}else {
			ArrayList<Integer> ar=new ArrayList<Integer>();
			ar.add(destination);
			G.put(source, ar);
		}
		
		if(!directed) {//if undirected graph then add destination to source
			if(G.containsKey(destination)) {
				ArrayList<Integer> ar=G.get(destination);
				ar.add(source);
				G.put(destination, ar);
			}else {
				ArrayList<Integer> ar=new ArrayList<Integer>();
				ar.add(source);
				G.put(destination, ar);
			}
		}
	}
	//remove edge
	void removeEdge(int source,int destination,boolean directed) {
		ArrayList<Integer> ar=G.get(source);
		ar.remove(destination);
		G.replace(source, ar);
		if(!directed) {//if directed then don't remove
			ArrayList<Integer> ar1=G.get(destination);
			ar1.remove(source);
			G.replace(destination, ar1);
		}
	}
	//print Graph
	 public String toString() { 
		  return G.toString();
	}
}
