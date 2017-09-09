package UnionFind;

import java.util.Arrays;
import java.util.Scanner;

public class WeightedQuickUnion extends QuickUnion {
	
	protected int [] sizes;
	
	public WeightedQuickUnion(int nN) {
		super(nN);
		sizes = new int [n];
		for(int i = 0; i < n; i++){
			sizes[i] = 1;
		}
		// TODO Auto-generated constructor stub
	}
	public void union(int p, int q) throws Exception{
		if(p >= n || q >= n){
			throw new Exception("p and/or q are >= than "+n+".");
		}else{
			int rootP = root(p);
			int rootQ = root(q);
			if (rootP != rootQ){
				if(sizes[rootP]< sizes[rootQ]){
					numbers[rootP]=rootQ;
					sizes[rootQ]+=sizes[rootP];
				}else{
					numbers[rootQ]=rootP;
					sizes[rootP]+=sizes[rootQ];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Introduce n: ");
		int N = in.nextInt();
		WeightedQuickUnion uf = new WeightedQuickUnion(N);
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
