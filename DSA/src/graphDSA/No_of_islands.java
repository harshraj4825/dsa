package graphDSA;

public class No_of_islands {
	int No_ofisland(int[][] input){
		boolean vis[][]=new boolean[input.length][input[0].length];
		int count=0;
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[0].length;j++) {
				if(input[i][j]!=0 && !vis[i][j]) {
						dfs(input,vis,i,j);
						count++;
				}
			}
		}
		return count;
	}
	void dfs(int[][] input,boolean[][] vis,int i,int j) {
		vis[i][j]=true;
		for(int p=-1;p<=1;p++) {
			for(int q=-1;q<=1;q++) {
				if(q==0 && p==0)continue;
				if( isValid(p+i,q+j,vis) &&input[i+p][j+q]!=0) {
					dfs(input,vis,p+i,q+j);
				}
			}
		}
	}
	boolean isValid(int x,int y,boolean[][] vis) {
		if(x>=vis.length||y>=vis[0].length||x<0||y<0||vis[x][y])return false;
//		vis[x][y]=true;
		return true;
	}

	public static void main(String[] args) {
		int[][] input={
				{1,1,0,0,0},
				{0,1,0,0,1},
				{1,0,0,1,1},
				{0,0,0,0,0},
				{1,0,1,0,1}
				};
		//output :5
		No_of_islands islands=new No_of_islands();
		System.out.println(islands.No_ofisland(input));
	}

}
