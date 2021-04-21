package graphDSA;

public class GraphImplementation {

	public static void main(String[] args) {
		//Adjacency of Matrix of unweighted Graph Graph
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
	}
	
	
}
