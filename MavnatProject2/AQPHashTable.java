import java.util.Random;

public class AQPHashTable extends OAHashTable {


	public AQPHashTable(int m, long p) {
		super(m);
		hash = new ModHash();
		// TODO Complete hash table constructor.
	}
	
	@Override
	public int Hash(long x, int i) {

		return (hash.Hash(x)+Math.pow(-1,i)*Math.pow(i,2)%this.m;
		return 0;
	}
}
