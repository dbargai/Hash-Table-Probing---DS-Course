import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	private ModHash otherHash;
	public DoubleHashTable(int m, long p) {
		super(m,p);
		otherHash=ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (this.hash.Hash(x)+i* otherHash.Hash(x));

	}
	
}
