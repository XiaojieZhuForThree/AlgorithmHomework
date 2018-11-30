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

class HashTable {				// establish a class named HashTable
	int collisions;				// reserve an integer used to store the happenings of collisions
	int tableSize;				// reserve an integer used to store the size of table
	int load;					// reserve an integer used to store the load for the calculation of load factor
	String[] table;

	HashTable() {							// constructor with the default table size set as 31
		this.table = new String[31];
		this.tableSize = 31;
		this.load = 0;
	}

	HashTable(int i) {						// another constructor where the size could be set manually
		this.table = new String[i];
		this.tableSize = i;
		this.load = 0;
	}

	void put(String key, String val) {		// function for insertion
		if (load * 2 >= tableSize) {
			reHash();
		}
		int hashVal = getHash(key);
		if (table[hashVal] != null) {
			hashVal = quadratic(hashVal);
		}
		table[hashVal] = val;
		load++;
	}

	void reHash() {						// function to increase the size of table and rehash 
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
	}

	int getHash(String n) {				// function to calculate the hash value
		int val = 0;
		for (int i = 0; i < n.length(); i++) {
			val += n.charAt(i);
		}
		return val % tableSize;
	}

	int quadratic(int hash) {			// function for quadratic probing
		int i = 1, next = hash;
		while (table[next] != null) {
			collisions++;
			next = (hash + i * i) % tableSize;
			i++;
		}
		return next;
	}

	int generateNextPrime(int cur) {	// used to generate the next prime number
		int next = cur * 2;
		while (!isPrime(next)) {
			next++;
		}
		return next;
	}

	boolean isPrime(int i) {			// used to check if the number is a prime
		for (int j = 2; j < i; j++) {
			if (i % j == 0)
				return false;
		}
		return true;
	}
}

public class Homework6 {
	public static void main(String[] args) {
		// generate 20 random words
		String[] words = new String[] { "tribunal", "aviator", "draft", "aroma", "draft", "costly", "700 kB", "AK 47",
				"skimpy", "And", "5 dollars", "2PM", "hair", "castic", "running", "screen", "YEARS", "clinic",
				"guitar", "goodtime", "ninja" };
		// create a new instance of the HashTable we wrote
		HashTable table = new HashTable();
		// insert the 20 random words into the HashTable
		for (String i : words) {
			table.put(i, i);
		}
		//Print the total number of collisions.
		System.out.println("After inserting the 20 words, the total number of collisions is: " + table.collisions);		
	}
}

//If the table size is more than 20,000 and the words to insert are 8000, is the above hashing algorithm adequate ? why ?
//Answer:
//	if the table size is more than 20,000, and the words to insert are 8000, the algorithm would not be adequate, because the 
