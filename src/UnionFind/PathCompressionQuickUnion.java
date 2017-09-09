package UnionFind;

import java.util.Arrays;
import java.util.Scanner;

public class PathCompressionQuickUnion extends QuickUnion {

	public PathCompressionQuickUnion(int nN) {
		super(nN);
		// TODO Auto-generated constructor stub
	}
	
	protected int root(int p){
		while(p != numbers[p]){
			numbers[p] = numbers[numbers[p]];
			p = numbers[p];
		}
		return p;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Introduce n: ");
		int N = in.nextInt();
		PathCompressionQuickUnion uf = new PathCompressionQuickUnion(N);
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
