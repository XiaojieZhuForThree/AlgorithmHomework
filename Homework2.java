import java.util.Arrays;

/*
 1. We covered Binary search in the class. Given an array of sorted numbers, 
 you can search for an item using binary search. Modify the algorithm so that you 
 do tertiary search.  So in each iteration you divide into 3 parts.

   The program must be done using recursion. 

Remember there are NO GLOBAL variables allowed.  NO static variables allowed.

   Run the program 4 times.

   1. Your array is a size of 15 numbers.  The number you are looking for is in the array.

   2. Your array is a size of 15 numbers.  The number you are looking for is NOT in the array.

   3. Your array is a size of 16 numbers.  The number you are looking for is in the array.

   4. Your array is a size of 16 numbers.  The number you are looking for is NOT in the array.

submit screen shot for each execution.

submit your code.
 */
public class Homework2 {

	public static void main(String[] args) {
		int[] example1 = { 1, 2, 3, 4, 5, 7, 8, 15, 19, 31, 41, 61, 73, 84, 95 }; // create the 15-number array
		int[] example2 = { 1, 3, 5, 6, 11, 15, 18, 19, 21, 27, 32, 38, 41, 44, 47, 52 }; // create the 15-number array
		int target1 = 19, target2 = 16, target3 = 27, target4 = 35; // create the targets that we're looking for
		search(example1, target1); // execute each search(15 length array, number in the list)
		search(example1, target2); // (15 length array, number not in the list)
		search(example2, target3); // (16 length array, number in the list)
		search(example2, target4); // (16 length array, number not in the list)

	}

	private static void search(int[] array, int target) { // build the function to print the index of the number
		System.out.println("array is: " + Arrays.toString(array)); // if it's in the array, otherwise indicate that it's
																	// not
		System.out.println("The size of the array is: " + array.length); // in the list
		System.out.println("the number we are looking for is : " + target);
		System.out.println("results: ");
		int ans = findItem(array, target, 0, array.length - 1);  // run the function finditem
		if (ans == -1) { 				// if the return value is -1, means that the target isn't in the array
			System.out.println(target + " doesn't exist in the array\n");
		} else {
			System.out.println(target + " exists in array, " + "index: " + ans + "\n");
		}
	}

	private static int findItem(int[] array, int target, int start, int end) {
		if (start > end) { // base case: if first indicate is greater than the second, return -1,
							// indicating that
			return -1; // the number we're looking for doesn't exist
		}
		int tert = (end - start + 1) / 3; // divide the array into 3 parts
		if (array[start + tert] == target) { // base case: if the middle points contains the number, return the index
			return start + tert;
		} else if (array[end - tert] == target) {
			return end - tert;
		} else { // else, compare the target with each dividing points, determining it's
					// potential position
			if (array[start + tert] > target) { // then recurse the function
				return findItem(array, target, start, start + tert - 1);
			} else if (array[start + tert] < target && target < array[end - tert]) {
				return findItem(array, target, start + tert + 1, end - tert);
			} else {
				return findItem(array, target, end - tert + 1, end);
			}
		}
	}
}
