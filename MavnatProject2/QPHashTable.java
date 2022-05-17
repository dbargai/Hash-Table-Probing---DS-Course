import java.util.Random;

public class QPHashTable extends OAHashTable {
	private ModHash hash;
	public QPHashTable(int m, long p) {
		super(m);
		hash = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (this.hash.Hash(x) + (i * i))%m;
	}
}
