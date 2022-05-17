import java.util.Random;

public class ModHash {
	private long a;
	private long b;
	private int m;
	private long p;

	public ModHash(long a,long b,int m,long p) {
		this.a=a;
		this.b=b;
		this.m=m;
		this.p=p;
	}

	public static ModHash GetFunc(int m, long p){
		/*p is a primary number , m is the size of the table.*/
		long LOWER_RANGE = 0; //assign lower range value
		long UPPER_RANGE = p; //assign upper range value
		Random random = new Random();
		long a = LOWER_RANGE+1 +
				(long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE+1));
		long b = LOWER_RANGE +
				(long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
		return new ModHash(a,b,m,p);
	}

	public int Hash(long key) {
		return  (int)(((this.a*key+this.b)%p)%m);

	}
}

