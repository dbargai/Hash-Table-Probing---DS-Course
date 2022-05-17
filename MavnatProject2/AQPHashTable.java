import java.util.Random;

public class AQPHashTable extends OAHashTable {


	public AQPHashTable(int m, long p) {
		super(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		double pos = hash.Hash(x)+Math.pow(-1,i)*Math.pow(i,2);
		return (int)(pos+this.m)%this.m;
	}
}
