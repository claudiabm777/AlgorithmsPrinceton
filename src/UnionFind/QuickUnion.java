package UnionFind;

import java.util.Arrays;
import java.util.Scanner;

public class QuickUnion {
	
	private int [] numbers;
	private int n;
	
	public QuickUnion(int nN){
		n = nN;
		numbers = new int [n];
		for(int i = 0; i < n; i++){
			numbers[i]=i;
		}
	}
	
	private int root(int p){
		if(numbers[p] == p){
			return numbers[p];
		}else{
			return root(numbers[p]);
		}
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
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Introduce n: ");
		int N = in.nextInt();
		QuickUnion uf = new QuickUnion(N);
		System.out.println("Introduce pairs: ");
		while (in.hasNext()){
			int p = in.nextInt();
			int q = in.nextInt();
			try{
				if (!uf.connected(p, q)){
					uf.union(p, q);
					System.out.println(Arrays.toString(uf.numbers));
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
