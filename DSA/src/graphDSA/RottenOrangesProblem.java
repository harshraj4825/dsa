package graphDSA;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangesProblem {
	class Pair {
		int i;
		int j;
		public Pair(int i,int j) {
			this.i=i;
			this.j=j;
		}
	}
	int minTime(int[][] input) {
		int time=0;
		Queue<Pair> queue=new LinkedList<RottenOrangesProblem.Pair>();
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[0].length;j++) {
				if(input[i][j]==2) {
					queue.add(new Pair(i, j));
				}
			}
		}
		int count =queue.size();
		while(count>0) {
			for(int i=0;i<count;i++) {
				Pair pair=queue.poll();
				pushNeighbour(input,pair,queue);
			}
			count=queue.size();
			if(count>0)time++;
		}
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[0].length;j++) {
				if(input[i][j]==1) {
					return -1;
				}
			}
		}
		return time;
	}
	void pushNeighbour(int[][] input,Pair pair,Queue<Pair> queue) {
		int i=pair.i;
		int j=pair.j;
		int x[]= {-1,1,0,0};
		int y[]= {0,0,-1,1};
		for(int k=0;k<x.length;k++) {
			if(!isValid(input,i,j,k,x,y))continue;
			queue.add(new Pair(i+x[k],j+y[k]));
			input[i+x[k]][j+y[k]]=2;
		}
	}
	boolean isValid(int[][] input,int i,int j,int k,int[] x,int[] y) {
		if(i+x[k]>=input.length || j+y[k]>=input[0].length ||
				i+x[k]<0 || j+y[k]<0 ||
				input[i+x[k]][j+y[k]]!=1)return false;
			
		return true;
	}

	public static void main(String[] args) {
		/*
		 * 0--Wall
		 * 1--Fresh
		 * 2--Rotten Orange
		 */
		int[][] input=
			{
					{0,0,0,1},
					{2,1,1,1},
					{2,0,2,0},
					{1,1,0,2}
			};
		RottenOrangesProblem orangesProblem=new RottenOrangesProblem();
		System.out.println("Time taken for rotten all oranges: "+orangesProblem.minTime(input));
	}

}
