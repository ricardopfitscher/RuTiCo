//https://www.geeksforgeeks.org/bipartite-graph/
//O(v+e)
// Java program to find out whether
// a given graph is Bipartite or not.
// Using recursion.
class GFG
{
	static final int V = 4;

	static boolean colorGraph(int G[][],
							int color[],
							int pos, int c)
	{
		if (color[pos] != -1 &&
			color[pos] != c)
			return false;

		// color this pos as c and
		// all its neighbours as 1-c
		color[pos] = c;
		boolean ans = true;
		for (int i = 0; i < V; i++)
		{
			if (G[pos][i] == 1)
			{
				if (color[i] == -1)
					ans &= colorGraph(G, color, i, 1 - c);

				if (color[i] != -1 && color[i] != 1 - c)
					return false;
			}
			if (!ans)
				return false;
		}
		return true;
	}

	static boolean isBipartite(int G[][])
	{
		int[] color = new int[V];
		for (int i = 0; i < V; i++)
			color[i] = -1;

		// start is vertex 0;
		int pos = 0;
	
		// two colors 1 and 0
		return colorGraph(G, color, pos, 1);
	}

	// Driver Code
	public static void main(String[] args)
	{
		int G[][] = { { 0, 1, 0, 1 },
					{ 1, 0, 1, 0 },
					{ 0, 1, 0, 1 },
					{ 1, 0, 1, 0 } };

		if (isBipartite(G))
			System.out.print("Yes");
		else
			System.out.print("No");
	}
}

// This code is contributed by Rajput-Ji
