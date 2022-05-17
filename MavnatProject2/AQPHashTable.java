import java.util.Random;

public class AQPHashTable extends OAHashTable {

	private ModHash hash;
	public AQPHashTable(int m, long p) {
		super(m);
		hash = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		double pos = hash.Hash(x)+Math.pow(-1,i)*Math.pow(i,2);
		return (int)(pos%this.m+this.m)%this.m;
	}
}
