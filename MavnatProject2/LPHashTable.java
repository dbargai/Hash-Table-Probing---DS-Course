import java.util.Random;

public class LPHashTable extends OAHashTable {

	public LPHashTable(int m, long p) {
		super(m,p);

	}

	@Override
	public int Hash(long x, int i) {
		return (hash.Hash(x)+i)%(this.m);
	}

}
