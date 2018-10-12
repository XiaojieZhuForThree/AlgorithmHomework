import java.util.Random;

/*
 1. Create a single linked list of integers. The values in each node must not be sorted.

    The number of nodes in the list must be at least 15.

    Traverse the list and print each value in the node.

2. Sort the list.  Sort it so that you DO NOT swap the values in the nodes.  But you MUST swap the complete node

   Traverse the list again and print each value in the node.


submit screen shot of each  execution.

submit the code.
 */

class Node { // create the class node, which contains two variables
	int val;
	Node next;

	Node(int value) { // the constructor
		val = value;
	}
}

public class Homework1 {
	public static void main(String[] args) {
		Node head = getLinkedList(20, -100, 100); // create a new unsorted linkedlist
		System.out.println("unsorted linked list: ");
		printData(head); // print the values of the list
		System.out.println("sorted linked list: ");
		head = sort(head); // sort the list
		printData(head); // print the sorted values

	}

	private static Node getLinkedList(int len, int lr, int hr) { // function used to generate a new list
		Random ram = new Random(3);
		int range = hr - lr + 1, diff = lr;
		Node head = new Node(ram.nextInt(range) + diff);
		Node dummy = head;
		for (int i = 1; i < len; i++) {
			dummy.next = new Node(ram.nextInt(range) + diff);
			dummy = dummy.next;
		}
		return head;
	}

	private static void printData(Node node) { // function to print the list's values
		while (node != null) {
			System.out.print(node.val);
			if (node.next != null) {
				System.out.print("->"); // if there's another node linked, add a "->"
			}
			node = node.next;
		}
		System.out.print("\n");
		return;
	}

	private static Node sort(Node node) { // sort the list with swap node method
		if (node == null || node.next == null) {
			return node;
		}
		boolean shouldswap = true; // to check if the list needs another sort
		Node init = new Node(0);
		init.next = node;
		while (shouldswap == true) {
			shouldswap = false;
			Node head = init, hub = head.next, tar = hub.next; // set a initial node to conduct the swap.
			while (tar != null) {
				Node tarn = tar.next;
				if (hub.val > tar.val) { // if the adjacent nodes has unsorted values, swap them
					shouldswap = true;
					swap(head, hub, tar, tarn);
					head = tar; // then go to the next adjacent nodes
					tar = tarn;

				} else { // if the two nodes are sorted, move to the next pair
					head = hub;
					hub = tar;
					tar = tarn;
				}
			}
		}
		return init.next;
	}

	private static void swap(Node head, Node hub, Node tar, Node tarn) { // swap the middle two nodes
		head.next = tar;
		tar.next = hub;
		hub.next = tarn;
	}
}
