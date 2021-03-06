package graphDSA;

public class GraphImplementation {

	public static void main(String[] args) {
		//Adjacency of un_weighted Graph
		AdjacencyMatrixGraph graph=new AdjacencyMatrixGraph(4);
		
		graph.addEdge(0, 1, false);
		graph.addEdge(0, 3, false);
		graph.addEdge(1, 2, false);
		graph.addEdge(2, 3, true);
		graph.addEdge(1, 3, false);
		System.out.println("Adjacency of Matrix of un_weighted Graph Graph");
		System.out.println(graph.toString());
		
		//Adjacency Matrix of weighted Graph
		WeightedGraphAM W_graph=new WeightedGraphAM(4);
		
		W_graph.addEdge(0, 1, false,1);
		W_graph.addEdge(0, 3, false,3);
		W_graph.addEdge(1, 2, false,4);
		W_graph.addEdge(2, 3, true,1);
		W_graph.addEdge(1, 3, false,2);
		System.out.println("Adjacency of Matrix of weighted Graph Graph");
		System.out.println(W_graph.toString());
		
		//AdjacencyList of un_weighted Graph using map
		//map because storage efficient
		AdjacencyListGraph_Map alGraph=new AdjacencyListGraph_Map();
		alGraph.addEdge(0, 1, false);
		alGraph.addEdge(0, 3, false);
		alGraph.addEdge(1, 2, false);
		alGraph.addEdge(2, 3, true);
		alGraph.addEdge(1, 3, false);
		System.out.println("AdjacencyList of un_weighted Graph");
		System.out.println(alGraph.toString());
		
		//AdjacencyList of un_weighted Graph using Array --> ArrayList<Integer> G[]
		AdjacencyListUsingArray alGArr=new AdjacencyListUsingArray(4);
		alGArr.addEdge(0, 1, false);
		alGArr.addEdge(0, 3, false);
		alGArr.addEdge(1, 2, false);
		alGArr.addEdge(2, 3, true);
		alGArr.addEdge(1, 3, false);
		System.out.println("\nAdjacencyList of un_weighted Graph using Array");
		System.out.println(alGArr.toString());

		
	}
	
	
}
