package graphDSA;

public class FloydWarshallAlgorithm {
	int[][] FloydWarshall(int[][] G,int V){
		int[][] A=new int[V][V];
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if(i!=j && G[i][j]==0) {
					A[i][j]=Integer.MAX_VALUE;
					continue;
				}
				A[i][j]=G[i][j];
			}
		}
		for(int k=0;k<V;k++) {
			for(int i=0;i<V;i++) {
				for(int j=0;j<V;j++) {
					if(A[i][k]!=Integer.MAX_VALUE &&A[k][j]!=Integer.MAX_VALUE&& A[i][j]>A[i][k]+A[k][j]) {
						A[i][j]=A[i][k]+A[k][j];
					}
				}
			}
		}
		
		return A;
		
	}
	public static void main(String[] args) {
		WeightedGraphAM weightedGraphAM=new WeightedGraphAM(7);
		weightedGraphAM.addEdge(0, 1, true, 3);
		weightedGraphAM.addEdge(0, 2, true, 6);
		weightedGraphAM.addEdge(1, 0, true, 3);
		weightedGraphAM.addEdge(1, 2, true, 2);
		weightedGraphAM.addEdge(1, 3, true, 1);
		weightedGraphAM.addEdge(2, 0, true, 6);
		weightedGraphAM.addEdge(2, 1, true, 2);
		weightedGraphAM.addEdge(2, 3, true, 1);
		weightedGraphAM.addEdge(2, 4, true, 4);
		weightedGraphAM.addEdge(2, 5, true, 2);
		weightedGraphAM.addEdge(3, 1, true, 1);
		weightedGraphAM.addEdge(3, 2, true, 1);
		weightedGraphAM.addEdge(3, 4, true, 2);
		weightedGraphAM.addEdge(3, 6, true, 4);
		weightedGraphAM.addEdge(4, 2, true, 4);
		weightedGraphAM.addEdge(4, 3, true, 2);
		weightedGraphAM.addEdge(4, 5, true, 2);
		weightedGraphAM.addEdge(4, 6, true, 1);
		weightedGraphAM.addEdge(5, 2, true, 2);
		weightedGraphAM.addEdge(5, 4, true, 2);
		weightedGraphAM.addEdge(5, 6, true, 1);
		weightedGraphAM.addEdge(6, 3, true, 4);
		weightedGraphAM.addEdge(6, 4, true, 1);
		weightedGraphAM.addEdge(6, 5, true, 1);
		System.out.println(weightedGraphAM.toString());
		FloydWarshallAlgorithm algorithm=new FloydWarshallAlgorithm();
		int[][] arr=algorithm.FloydWarshall(weightedGraphAM.getGraph(), 
				weightedGraphAM.getTotalNode());
		System.out.println("FloyedWarshall Distance");
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(+arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
