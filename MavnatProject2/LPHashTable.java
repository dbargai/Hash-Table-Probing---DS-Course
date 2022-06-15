//Student 1:
//name: Dvir Bargai
//ID: 208772715
//username: dvirbargai

//Student 2:
//name: Or Shemesh
//ID: 208992883
//username: orshemesh

import java.util.Random;

public class LPHashTable extends OAHashTable {

	private ModHash hash;
	public LPHashTable(int m, long p) {
		super(m);
		this.hash = ModHash.GetFunc(m,p);
	}

	@Override
	public int Hash(long x, int i) {
		return ((hash.Hash(x)+i)%(this.m));
	}

}
