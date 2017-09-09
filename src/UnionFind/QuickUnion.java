package UnionFind;

import java.util.Arrays;
import java.util.Scanner;

public class QuickUnion {
	
	protected int [] numbers;
	protected int n;
	
	public QuickUnion(int nN){
		n = nN;
		numbers = new int [n];
		for(int i = 0; i < n; i++){
			numbers[i]=i;
		}
	}
	
	protected int root(int p){
		while(p != numbers[p]){
			p = numbers[p];
		}
		return p;
	}
	
	public void union(int p, int q) throws Exception{
		if(p >= n || q >= n){
			throw new Exception("p and/or q are >= than "+n+".");
		}else{
			int rootP = root(p);
			int rootQ = root(q);
			if (rootP != rootQ){
				numbers[rootQ]=rootP;
			}
		}
	}
	
	public boolean connected(int p, int q) throws Exception{
		if(p >= n || q >= n){
			throw new Exception("p and/or q are >= than "+n+".");
		}else{
			int rootP = root(p);
			int rootQ = root(q);
			return rootP == rootQ;
			
		}
	}

}
