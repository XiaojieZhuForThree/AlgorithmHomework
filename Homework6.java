import java.util.Arrays;

//Implement Hash table.
//
//Pick 20 random words.  Each word must be of different lengths, maximum length 8 and minimum length 3.
//
//The words will be of letters a-zA-Z0-9 and the space character.
//
//Insert them into a hash table.  The hashing algorithm uses ASCII table values for each character and adds up the values. 
//Initially the table size is 31.  The program should increase the table size and rehash.
//
//The collision resolution is done using quadratic probing.
//
//At the end print the total number of collisions you get.
//
//If the table size is more than 20,000 and the words to insert are 8000, is the above hashing algorithm adequate ? why ?

class HashTable {
	int collisions;
	int tableSize;
	int load;
	String[] table;

	HashTable() {
		this.table = new String[31];
		this.tableSize = 31;
		this.load = 0;
	}

	HashTable(int i) {
		this.table = new String[i];
		this.tableSize = i;
		this.load = 0;
	}

	void put(String key, String val) {
		if (load * 2 >= tableSize) {
			reHash();
		}
		int hashVal = getHash(key);
		if (table[hashVal] != null) {
			collisions++;
			hashVal = quadratic(hashVal);
		}
		table[hashVal] = val;
		load++;
	}

	void reHash() {
		int record = collisions;
		int nextPrime = generateNextPrime(tableSize);
		String[] prevTable = table.clone();
		this.table = new String[nextPrime];
		this.tableSize = nextPrime;
		this.load = 0;
		for (String i : prevTable) {
			if (i != null) {
				put(i, i);				
			}
		}
		collisions = record;
	}

	int getHash(String n) {
		int val = 0;
		for (int i = 0; i < n.length(); i++) {
			val += n.charAt(i);
		}
		return val % tableSize;
	}

	int quadratic(int hash) {
		int i = 1, next = hash;
		while (table[next] != null) {
			next = (hash + i * i) % tableSize;
			i++;
		}
		return next;
	}

	int generateNextPrime(int cur) {
		int next = cur * 2;
		while (!isPrime(next)) {
			next++;
		}
		return next;
	}

	boolean isPrime(int i) {
		for (int j = 2; j < i; j++) {
			if (i % j == 0)
				return false;
		}
		return true;
	}
}

public class Homework6 {
	public static void main(String[] args) {
		String[] words = new String[] { "tribunal", "aviator", "draft", "aroma", "draft", "costly", "700 kB", " aKp",
				"skimpy", "Amd", "WGLpX5i", "pi34EhMJ", "hair", "castic", "running", "screen", "13Y8g", "clinic",
				"dandruff", "NOJhj8", "ninja" };
		HashTable table = new HashTable();
		for (String i : words) {
			table.put(i, i);
		}
		System.out.println("The total number of collisions is: " + table.collisions);		
	}

}
