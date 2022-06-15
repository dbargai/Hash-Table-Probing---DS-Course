//Student 1:
//name: Dvir Bargai
//ID: 208772715
//username: dvirbargai

//Student 2:
//name: Or Shemesh
//ID: 208992883
//username: orshemesh

public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	protected int m;
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		this.m = m;
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		for (int i=0; i<table.length; i++) {
			int j = Hash(key, i);
			if (table[j] == null)
				return null;
			else {
				if (table[j].GetKey() == key)
					return table[j];
			}
		}
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		if (this.Find(hte.GetKey())!=null)
			throw new KeyAlreadyExistsException(hte);
		for (int i=0; i<table.length; i++) {
			int j = Hash(hte.GetKey(), i);
			if (table[j] == null || table[j].GetKey()==-1) {
				table[j] = hte;
				return;
			}
		}
		throw new TableIsFullException(hte);
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		for (int i=0; i<table.length; i++){
			int j = Hash(key, i);
			if (table[j]==null)
				throw new KeyDoesntExistException(key);
			else {
				if (table[j].GetKey() == key) {
					table[j] = new HashTableElement(-1, -1);
					return;
				}
			}
		}
		throw new KeyDoesntExistException(key);
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
