package UnionFind;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

public class QuickFind {
	
	private int [] numbers;
	private int n;
	
	public QuickFind( int nN){
		n = nN;
		numbers = new int[n];
		for(int i = 0; i < n; i++){
			numbers[i]=i;
		}
	}
	
	public void union(int p, int q) throws Exception{
		if(p >= n || q >= n){
			throw new Exception("p and/or q are >= than "+n+".");
		}else{
			int idP = numbers[p];
			int idQ = numbers[q];
			for(int i = 0; i < n; i++){
				if( numbers[i] == idQ){
					numbers[i] = idP;
				}
			}
		}
	}
	
	public boolean connected(int p, int q) throws Exception{
		if(p >= n || q >= n){
			throw new Exception("p and/or q are >= than "+n+".");
		}else{
			return numbers[p] == numbers[q];
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Introduce n: ");
		int N = in.nextInt();
		QuickFind uf = new QuickFind(N);
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
