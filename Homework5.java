import java.util.Arrays;

//1. Implement Bellman Ford Algorithm to find the shortest path tree.
//
//a. your graph must have at least 10 nodes
//
//b. Your graph must have at least 15 edges.
//
//c. Some of the edge weights must be negative.
//
//d. Run the program on 2 cases - 1. The graph has negative edges but NO negative cycle. 2. Graph has a negative cycle.
//
//e. Your program must catch the negative cycle.
//
//f. submit code
//
//g submit the screen shot of execution.

public class Homework5 {
	private static void printMatrix(int[][] matrix) {
		// a function used to print the adjacency matrix of the graph
		for (int[] i : matrix) {
			System.out.println(Arrays.toString(i).substring(1, Arrays.toString(i).length() - 1));
		}
		System.out.println();
	}

	private static void bfa(int[][] matrix, char[] vertices, int start) {
		int[] weights = new int[matrix.length];
		int[] prevs = new int[matrix.length];
		for (int i : weights) {
			i = Integer.MAX_VALUE;
		}
		weights[start] = 0;
		prevs[start] = start;
		int times = 0;
		while (times < matrix.length) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (weights[j] > weights[i] + matrix[i][j]) {
						weights[j] = weights[i] + matrix[i][j];
						prevs[j] = i;
					}
				}
			}
			times++;
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (weights[j] > weights[i] + matrix[i][j]) {
					System.out.println(
							"a negative cycle contains in the graph, can't solve the graph with Bellman-Ford Method.");
					return;
				}
			}
		}
		System.out.println("The start point vertex is: " + vertices[start]);
		for (int i = 0; i < matrix.length; i++) {
			if (i != start) {
				System.out.println(
						"The shortest path from " + vertices[start] + " to" + vertices[i] + " is: " + weights[i]);
			}

		}
	}

	public static void main(String[] args) {
		// the vertices of the graph
		char[] vertices = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };

		// the adjacency matrix of the graph
		int[][] matrix = { { 0, 5, 0, 0, 0, -3, 0, 0, 0, 0 }, { 0, 0, 2, 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, -3, 0, 0, 0, 4, 0, 0 }, { 0, 0, 0, 0, 4, 0, 0, 0, 2, 0 }, { -2, 0, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 0, 0, 0, 0, 0, 0, 4, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, -5, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 9 }, { 0, 0, 0, 0, 0, -6, 0, 0, 0, 0 } };

		// printMatrix(matrix);
		bfa(matrix, vertices, 1);
	}

}
