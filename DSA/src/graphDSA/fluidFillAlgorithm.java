package graphDSA;

public class fluidFillAlgorithm {
	void fluidFill(int[][] input,int newColor,int oldColor){
		boolean[][] vis=new boolean[input.length][input[0].length];
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[0].length;j++) {
				if(input[i][j]==oldColor) {
					fluidFillUtil(input,vis,i,j,oldColor,newColor);
				}
			}
		}
	}
	void fluidFillUtil(int[][] input,boolean[][] vis,int i,int j,
			int oldColor,int newColor) {
		if(!isSafe(input,vis,i,j,oldColor))return;
		vis[i][j]=true;
		if(input[i][j]==oldColor)input[i][j]=newColor;
		fluidFillUtil(input,vis,i-1,j,oldColor,newColor);
		fluidFillUtil(input,vis,i+1,j,oldColor,newColor);
		fluidFillUtil(input,vis,i,j-1,oldColor,newColor);
		fluidFillUtil(input,vis,i,j+1,oldColor,newColor);
		
	}
	boolean isSafe(int[][] input,boolean[][] vis,int i,int j,int oldColor) {
		if(i>=input.length || j>=input[0].length || i<0||j<0||
				vis[i][j]==true||input[i][j]!=oldColor)return false;
		return true;
	}
	void printArr(int[][] input) {
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[0].length;j++) {
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] input= 
			{
				{0,1,1,1,1},
				{4,2,3,1,5},
				{5,6,9,4,5},
				{7,7,7,5,5},
				{7,8,9,12,4}
			};
		int newColor=2;
		int oldColor=1;
		
		fluidFillAlgorithm algorithm=new fluidFillAlgorithm();
		algorithm.printArr(input);
		System.out.println("-------------------------");
		algorithm.fluidFill(input, newColor, oldColor);
		algorithm.printArr(input);
	}

}
