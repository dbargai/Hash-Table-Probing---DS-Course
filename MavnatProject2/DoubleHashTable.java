import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	private ModHash otherHash;
	private ModHash hash;
	public DoubleHashTable(int m, long p) {
		super(m);
		hash = ModHash.GetFunc(m,p);
		otherHash=ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (this.hash.Hash(x)+i* otherHash.Hash(x));

	}
	
}
