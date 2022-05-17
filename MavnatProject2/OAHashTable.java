
public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	protected int m;
	ModHash hash;
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		this.m = m;
		this.hash = new ModHash();
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
		for (int i=0; i<table.length; i++) {
			int j = Hash(hte.GetKey(), i);
			if (table[j] == null) {
				if (table[j].GetKey() == hte.GetKey())
					throw new KeyAlreadyExistsException(hte);
			}
			else {
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
			if (table[j].GetKey()==key)
				table[j] = new HashTableElement(-1,-1);
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
