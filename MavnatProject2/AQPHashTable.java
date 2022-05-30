import java.util.Random;

public class AQPHashTable extends OAHashTable {

	private ModHash hash;
	public AQPHashTable(int m, long p) {
		super(m);
		hash = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		if (i%2==0)
			return (int)(((long)hash.Hash(x)+(long)i*(long)i)%(long)m);
		else
			return (int)((((long)hash.Hash(x)-(long)i*(long)i)%(long)m)+m)%m;
	}
}
