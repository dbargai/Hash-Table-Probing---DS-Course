

import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	private ModHash otherHash;
	private ModHash hash;
	public DoubleHashTable(int m, long p) {
		super(m);
		hash = ModHash.GetFunc(m,p);
		otherHash=ModHash.GetFunc(m-1,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (int)(((long)this.hash.Hash(x)+(long)i*(long)(otherHash.Hash(x)+1))%(long)m);


	}
	
}
