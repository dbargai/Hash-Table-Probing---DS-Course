import java.util.Random;

public class LPHashTable extends OAHashTable {

	private ModHash hash;
	public LPHashTable(int m, long p) {
		super(m);
		this.hash = ModHash.GetFunc(m,p);
	}

	@Override
	public int Hash(long x, int i) {
		return (int)(((long)hash.Hash(x)+i)%((long)this.m));
	}

}
