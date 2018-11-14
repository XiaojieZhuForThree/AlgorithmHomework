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
		int[] weights = new int[matrix.length], prevs = new int[matrix.length];
		for (int i = 0; i < weights.length; i++) {
			weights[i] = Integer.MAX_VALUE;
		}
		weights[start] = 0;
		prevs[start] = start;
		for (int times = 0; times < matrix.length; times++) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (matrix[i][j] != 0 && weights[i] != Integer.MAX_VALUE
							&& weights[j] > weights[i] + matrix[i][j]) {
						weights[j] = weights[i] + matrix[i][j];
						prevs[j] = i;
					}
				}
			}
		}

		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != 0 && weights[i] != Integer.MAX_VALUE && weights[j] > weights[i] + matrix[i][j]) {
					System.out.println(
							"A negative cycle contains in the graph, can't solve the graph with Bellman-Ford Method.");
					return;
				}
			}
		}
		System.out.println("The start point vertex is: " + vertices[start]);
		for (int i = 0; i < matrix.length; i++) {
			if (i != start) {
				StringBuilder sb = new StringBuilder();
				sb.append(vertices[i]);
				int j = i;
				while (j != start) {
					j = prevs[j];
					sb.append(" >- " + vertices[j]);
				}
				System.out.print("The weight of the shortest path from " + vertices[start] + " to " + vertices[i]
						+ " is: " + weights[i]);
				System.out.println(", the path is : " + sb.reverse().toString());
			}
		}
	}

	public static void main(String[] args) {
		// the vertices of the graph
		char[] vertices = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };

		// the adjacency matrix of the graph
		int[][] matrix1 = { { 0, 5, 0, 0, 0, -3, 0, 0, 0, 0 }, { 0, 0, 2, 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, -3, 0, 0, 0, 4, 0, 0 }, { 0, 0, 0, 0, 4, 0, 0, 0, 2, 0 }, { -2, 0, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 0, 0, 0, 0, 0, 0, 4, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, -5, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 9 }, { 0, 0, 0, 0, 0, -6, 0, 0, 0, 0 } };
		int[][] matrix2 = { { 0, 5, 0, 0, 0, -3, 0, 0, 0, 0 }, { 0, 0, 2, 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, -3, 0, 0, 0, 4, 0, 0 }, { 0, 0, 0, 0, 4, 0, 0, 0, 2, 0 }, { -2, 0, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 0, 0, 0, 0, 0, 0, 4, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, -5, -6 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 9 }, { 0, 0, 0, 0, 0, -6, 0, 0, 0, 0 } };

		// printMatrix(matrix);
		System.out.println("1. First we test the Bellman-Ford method with a graph with negative edges but no negative circle: ");
		System.out.println("The adjacency matrix: ");
		printMatrix(matrix1);
		bfa(matrix1, vertices, 0);
		System.out.println("\n\n2. Now we test the Bellman-Ford method with a graph with negative circle: ");
		System.out.println("The adjacency matrix: ");
		printMatrix(matrix2);
		bfa(matrix2, vertices, 0);
	}

}
