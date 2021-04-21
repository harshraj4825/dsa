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
		System.out.println("Adjacency of Matrix of unweighted Graph Graph");
		System.out.println(graph.toString());
		System.out.println("After removing");
		graph.removeEdge(1, 2, false);
		graph.removeEdge(2, 3, true);
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
		System.out.println("After removing");
		W_graph.removeEdge(1, 2, false);
		W_graph.removeEdge(2, 3, true);
		System.out.println(W_graph.toString());
	}
	
	
}
