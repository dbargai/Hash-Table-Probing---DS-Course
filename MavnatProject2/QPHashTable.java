import java.util.Random;

public class QPHashTable extends OAHashTable {

	public QPHashTable(int m, long p) {
		super(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (this.hash.Hash(x) + (i * i))%m;
	}
}
