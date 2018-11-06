import java.util.*;

//Create an undirected graph of at least 10 vertices and 15 edges.
//
//Draw the graph and include the graph image in your submission.
//
//1. Do A DFS traversal on the graph.
//
//   Print the graph before traversal - adjacency matrix or adjacency list
//
//   print the start vertex of your dfs
//
//   print the nodes in the order they were visited.
//
//2. Do a BFS traversal for the same graph.
//
//     Print the nodes in the order they are visited for the dfs traversal.
//
//
//Submit the code
//
//submit the graph that you start out with
//
//submit the screen shot of each execution

public class Homework4 {
	private static void printMatrix(int[][] matrix) {
		// a function used to print the adjacency matrix of the graph
		for (int[] i : matrix) {
			System.out.println(Arrays.toString(i).substring(1,Arrays.toString(i).length()-1));
		}
		System.out.println();
	}

	private static void dfs(int[][] matrix, char[] vertices, int index, boolean[] alreadyVisited) {
		// a function used to do dfs of the graph
		System.out.print(vertices[index]);
		alreadyVisited[index] = true;
		for (int i = 0; i < matrix[index].length; i++) {
			if (matrix[index][i] == 1 && alreadyVisited[i] == false) {
				System.out.print(" -> ");
				dfs(matrix, vertices, i, alreadyVisited);
			}
		}
	}

	private static void bfs(int[][] matrix, char[] vertices, int index) {
		// a function used to do bfs of the graph.
		Queue<Integer> queue = new LinkedList<>();
		boolean[] alreadyVisited = new boolean[matrix.length];
		System.out.print(vertices[index]);
		alreadyVisited[index] = true;
		queue.add(index);
		while (!queue.isEmpty()) {
			int now = queue.poll();
			if (alreadyVisited[now] == false) {
				System.out.print(" -> " + vertices[now]);
				alreadyVisited[now] = true;
			}
			for (int i = 0; i < matrix[now].length; i++) {
				if (matrix[now][i] == 1 && alreadyVisited[i] == false) {
					queue.add(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		// the vertices of the graph
		char[] vertices = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };

		// the adjacency matrix of the graph
		int[][] matrix = { { 0, 1, 0, 0, 1, 1, 0, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 1, 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 1, 0, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0, 0, 0, 1, 1 }, { 0, 0, 1, 0, 0, 1, 0, 0, 0, 1 },
				{ 0, 0, 0, 1, 0, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 1, 1, 0, 0 } };

		System.out.println("The adjacency matrix of the graph is:");
		printMatrix(matrix); // print the adjacency matrix

		System.out.println("The start vertex of DFS is: " + vertices[0]); // do dfs start with the vertex 'A'
		System.out.println("The DFS node sequence is: ");
		dfs(matrix, vertices, 0, new boolean[matrix.length]);

		System.out.println("\n\n" + "The start vertex of BFS is: " + vertices[0]); // do bfs start with the vertex 'A'
		System.out.println("The BFS node sequence is: ");
		bfs(matrix, vertices, 0);
	}

}

