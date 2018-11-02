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
		for (int[] i : matrix) {
			System.out.println(Arrays.toString(i));
		}
	}
	private static void dfs(int[][] matrix, char[] vertices, int index, Set<Character> alreadyVisited) {
		if (!alreadyVisited.contains(vertices[index])) {
			System.out.print(vertices[index]);
			alreadyVisited.add(vertices[index]);
			for (int i = index+1; i < matrix[index].length; i++) {
				if (matrix[index][i] == 1) {
					dfs(matrix, vertices, i, alreadyVisited);
				}
			}
		}
	}
	public static void main(String[] args) {
		char[] vertices = {'A','B','C','D','E','F','G','H','I','J'};
		int[][] graph = {{0,1,0,0,1,1,0,0,0,0},{1,0,1,0,0,0,1,0,0,0},{0,1,0,1,0,0,0,1,0,0},{0,0,1,0,1,0,0,0,1,0},{1,0,0,1,0,0,0,0,0,1},
		{1,0,0,0,0,0,0,1,1,0},{0,1,0,0,0,0,0,0,1,1},{0,0,1,0,0,1,0,0,0,1},{0,0,0,1,0,1,1,0,0,0},{0,0,0,0,1,0,1,1,0,0}};
		
		printMatrix(graph);
		
		System.out.println('\n'+"The start vertex of dfs is:"+ vertices[0]);
		dfs(graph, vertices, 0, new HashSet<>());
	}

}
