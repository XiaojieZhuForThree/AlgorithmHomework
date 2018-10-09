import java.util.Arrays;
import java.util.Random;

/*
given an array of numbers. Convert the numbers into heap, using floyd's method. At least 10 numbers,

1. Print the array before it is converted to heap

2. Print the heap after it is converted to heap

3. Then insert a new number into heap. and print the array

4. Then delete a new number in the heap and print the array
 */

public class Homework3 {
	public static void main(String[] args) {
		int[] heap = generateHeap(20);
		System.out.println(Arrays.toString(heap));
		convertHeap(heap);
		System.out.println(Arrays.toString(heap));
		heap = insert(heap, 28);
		System.out.println(Arrays.toString(heap));
		heap = delete(heap);
		System.out.println(Arrays.toString(heap));
		
	}
	private static int[] generateHeap(int n) {
		Random random = new Random(148);
		int[] heap = new int[n+1];
		heap[0] = n;
		for (int i = 1; i < n+1; i++) {
			heap[i] = random.nextInt(100);
		}
		return heap;
	}
	private static void convertHeap(int[] heap) {
		int index = heap.length / 2;
		while (index > 0) {
			int comp = index;
			while (comp * 2 < heap.length) {
				int swap = comp * 2;
				if (comp * 2 < heap.length - 1) {
					if (heap[comp * 2] > heap[comp * 2 + 1]) {
						swap++;
					}
				}
				if (heap[comp] > heap[swap]) {
					int tmp = heap[comp];
					heap[comp] = heap[swap];
					heap[swap] = tmp;
				}
				comp = swap;
			}
			index--;
		}
		return;
	}
	private static int[] insert(int[] heap, int i) {
		int[] newheap = new int[heap.length+1];
		for (int j = 0; j < heap.length; j++) {
			newheap[j] = heap[j];
		}
		newheap[0]++;
		newheap[heap.length] = i;
		convertHeap(newheap);
		return newheap;
	}
	private static int[] delete(int[] heap) {
		int[] newheap = new int[heap.length-1];
		newheap[0] = heap[0]-1;
		newheap[1] = heap[heap.length-1];
		for (int j = 2; j < heap.length-1; j++) {
			newheap[j] = heap[j];
		}
		convertHeap(newheap);
		return newheap;
	}
}
