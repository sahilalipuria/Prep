package genericHashTable;

public class HashTable<Key, Value> {

	private Key[] keys;
	private Value[] values;
	private int numOfItems;
	private int capacity; // max number of items that can be inserted in the table. Upper bound of
							// numOfItems.

	@SuppressWarnings("unchecked")
	public HashTable() {

		this.keys = (Key[]) new Object[Constants.TABLE_SIZE];
		this.values = (Value[]) new Object[Constants.TABLE_SIZE];
		this.capacity = Constants.TABLE_SIZE;
		this.numOfItems = 0;
	}

	public int size() {
		return this.numOfItems;
	}

	public boolean isEmpty() {
		return this.numOfItems == 0;
	}

	public Value get(Key key) {

		if (key == null)
			return null;

		int index = hash(key);

		while (keys[index] != null) {
			if (keys[index].equals(key)) {
				return values[index];
			}
			index = (index + 1) % capacity;
		}

		return null;
	}

	public void put(Key key, Value value) {

		if (key == null || value == null)
			return;

		if (numOfItems >= capacity * 0.75) {		//O(1) -> O(N)
			System.out.println("Doubling the size of hashtable.....");
			resize(2 * capacity);
		}

		int index = hash(key);

		while (keys[index] != null) {

			// update
			if (keys[index] == key) {
				values[index] = value;
				return;
			}

			index = (index + 1) % capacity;
		}

		keys[index] = key;
		values[index] = value;
		numOfItems++;
	}

	public void remove(Key key) {
		if (key == null)
			return;

		int index = hash(key);

		while (!keys[index].equals(key)) {
			index = (index + 1) % capacity;
		}

		keys[index] = null;
		values[index] = null;
		numOfItems--;

		while (keys[index] != null) {
			Key tempKey = keys[index];
			Value tempValue = values[index];

			keys[index] = null;
			values[index] = null;

			numOfItems--;

			put(tempKey, tempValue);

			index = (index + 1) % capacity;
		}

		if (numOfItems <= capacity / 3) {
			System.out.println("Halfing the size of hashtable....");
			resize(capacity / 2);
		}
	}

	// O(N) conclusion:  we have to make sure that we minimize the resize operations.
	private void resize(int newCapacity) {

		HashTable<Key, Value> newTable = new HashTable<>();

		for (int i = 0; i < capacity; i++) {
			if (keys[i] != null) {
				newTable.put(keys[i], values[i]);
			}
		}
		
		keys = newTable.getKeys();
		values = newTable.getValues();
		capacity = newTable.getCapacity();

	}

	public Key[] getKeys() {
		return keys;
	}

	public void setKeys(Key[] keys) {
		this.keys = keys;
	}

	public Value[] getValues() {
		return values;
	}

	public void setValues(Value[] values) {
		this.values = values;
	}

	public int getNumOfItems() {
		return numOfItems;
	}

	public void setNumOfItems(int numOfItems) {
		this.numOfItems = numOfItems;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int hash(Key key) {

		return Math.abs(key.hashCode()) % Constants.TABLE_SIZE;
	}
}
