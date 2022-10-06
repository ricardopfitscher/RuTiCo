//https://www.geeksforgeeks.org/count-possible-paths-source-destination-exactly-k-edges/
//O(v^3)
// Java program to count walks from
// u to v with exactly k edges
import java.util.*;
import java.lang.*;
import java.io.*;

class KPaths {
	static final int V = 4; // Number of vertices

	// A Dynamic programming based function to count walks from u
	// to v with k edges
	int countwalks(int graph[][], int u, int v, int k)
	{
		// Table to be filled up using DP. The value count[i][j][e]
		// will/ store count of possible walks from i to j with
		// exactly k edges
		int count[][][] = new int[V][V][k + 1];

		// Loop for number of edges from 0 to k
		for (int e = 0; e <= k; e++) {
			for (int i = 0; i < V; i++) // for source
			{
				for (int j = 0; j < V; j++) // for destination
				{
					// initialize value
					count[i][j][e] = 0;

					// from base cases
					if (e == 0 && i == j)
						count[i][j][e] = 1;
					if (e == 1 && graph[i][j] != 0)
						count[i][j][e] = 1;

					// go to adjacent only when number of edges
					// is more than 1
					if (e > 1) {
						for (int a = 0; a < V; a++) // adjacent of i
							if (graph[i][a] != 0)
								count[i][j][e] += count[a][j][e - 1];
					}
				}
			}
		}
		return count[u][v][k];
	}

	// Driver method
	public static void main(String[] args) throws java.lang.Exception
	{
		/* Let us create the graph shown in above diagram*/
		int graph[][] = new int[][] { { 0, 1, 1, 1 },
									{ 0, 0, 0, 1 },
									{ 0, 0, 0, 1 },
									{ 0, 0, 0, 0 } };
		int u = 0, v = 3, k = 2;
		KPaths p = new KPaths();
		System.out.println(p.countwalks(graph, u, v, k));
	}
} // Contributed by Aakash Hasija
