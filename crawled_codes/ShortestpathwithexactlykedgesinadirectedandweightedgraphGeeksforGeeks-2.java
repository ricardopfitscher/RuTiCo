//https://www.geeksforgeeks.org/shortest-path-exactly-k-edges-directed-weighted-graph/
//O(v^3k)
// Dynamic Programming based Java program to find shortest path with
// exactly k edges
import java.util.*;
import java.lang.*;
import java.io.*;

class ShortestPath
{
	// Define number of vertices in the graph and infinite value
	static final int V = 4;
	static final int INF = Integer.MAX_VALUE;

	// A Dynamic programming based function to find the shortest path
	// from u to v with exactly k edges.
	int shortestPath(int graph[][], int u, int v, int k)
	{
		// Table to be filled up using DP. The value sp[i][j][e] will
		// store weight of the shortest path from i to j with exactly
		// k edges
		int sp[][][] = new int[V][V][k+1];

		// Loop for number of edges from 0 to k
		for (int e = 0; e <= k; e++)
		{
			for (int i = 0; i < V; i++) // for source
			{
				for (int j = 0; j < V; j++) // for destination
				{
					// initialize value
					sp[i][j][e] = INF;

					// from base cases
					if (e == 0 && i == j)
						sp[i][j][e] = 0;
					if (e == 1 && graph[i][j] != INF)
						sp[i][j][e] = graph[i][j];

					// go to adjacent only when number of edges is
					// more than 1
					if (e > 1)
					{
						for (int a = 0; a < V; a++)
						{
							// There should be an edge from i to a and
							// a should not be same as either i or j
							if (graph[i][a] != INF && i != a &&
									j!= a && sp[a][j][e-1] != INF)
								sp[i][j][e] = Math.min(sp[i][j][e],
										graph[i][a] + sp[a][j][e-1]);
						}
					}
				}
			}
		}
		return sp[u][v][k];
	}

	public static void main (String[] args)
	{
		/* Let us create the graph shown in above diagram*/
		int graph[][] = new int[][]{ {0, 10, 3, 2},
									{INF, 0, INF, 7},
									{INF, INF, 0, 6},
									{INF, INF, INF, 0}
								};
		ShortestPath t = new ShortestPath();
		int u = 0, v = 3, k = 2;
		System.out.println("Weight of the shortest path is "+
						t.shortestPath(graph, u, v, k));
	}
}
//This code is contributed by Aakash Hasija
