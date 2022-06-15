//Student 1:
//name: Dvir Bargai
//ID: 208772715
//username: dvirbargai

//Student 2:
//name: Or Shemesh
//ID: 208992883
//username: orshemesh

import java.util.Random;

public class QPHashTable extends OAHashTable {
	private ModHash hash;
	public QPHashTable(int m, long p) {
		super(m);
		hash = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (int)(((long)this.hash.Hash(x) + (long)(i) * (long)i)%(long)m);
	}
}
