package UnionFind;

public class WPCQuickUnion extends WeightedQuickUnion{

	public WPCQuickUnion(int nN) {
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

}
