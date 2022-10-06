//https://www.geeksforgeeks.org/vertex-cover-problem-set-2-dynamic-programming-solution-tree/
//O(n)
// C++ implementation for the above approach
#include <bits/stdc++.h>
using namespace std;

// An utility function to add an edge in the tree
void addEdge(vector<int> adj[], int x, int y)
{
	adj[x].push_back(y);
	adj[y].push_back(x);
}

void dfs(vector<int> adj[], vector<int> dp[], int src,
		int par)
{
	for (auto child : adj[src]) {
		if (child != par)
			dfs(adj, dp, child, src);
	}

	for (auto child : adj[src]) {
		if (child != par) {
			// not including source in the vertex cover
			dp[src][0] += dp[child][1];

			// including source in the vertex cover
			dp[src][1] += min(dp[child][1], dp[child][0]);
		}
	}
}

// function to find minimum size of vertex cover
void minSizeVertexCover(vector<int> adj[], int N)
{
	vector<int> dp[N + 1];

	for (int i = 1; i <= N; i++) {
		// 0 denotes not included in vertex cover
		dp[i].push_back(0);

		// 1 denotes included in vertex cover
		dp[i].push_back(1);
	}

	dfs(adj, dp, 1, -1);

	// printing minimum size vertex cover
	cout << min(dp[1][0], dp[1][1]) << endl;
}

// Driver Code
int main()
{
	/*						 1

						/		 \

					2			 7

			/			 \

			3			 6

	/	 |	 \

4		 8		 5
	
*/
	
	// number of nodes in the tree
	int N = 8;

	// adjacency list representation of the tree
	vector<int> adj[N + 1];

	addEdge(adj, 1, 2);
	addEdge(adj, 1, 7);
	addEdge(adj, 2, 3);
	addEdge(adj, 2, 6);
	addEdge(adj, 3, 4);
	addEdge(adj, 3, 8);
	addEdge(adj, 3, 5);

	minSizeVertexCover(adj, N);

	return 0;
}
