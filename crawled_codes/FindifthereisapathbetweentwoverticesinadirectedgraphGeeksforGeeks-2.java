//https://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/
//O(v+e)
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

vector<ll> adj[100000];
bool visited[100000];

bool dfs(int start, int end)
{
	if (start == end)
		return true;
	visited[start] = 1;
	for (auto x : adj[start]) {
		if (!visited[x])
			if (dfs(x, end))
				return true;
	}
	return false;
}

int main()
{

	int V = 4;
	vector<ll> members = { 2, 5, 7, 9 };

	int E = 4;
	vector<pair<ll, ll> > connections
		= { { 2, 9 }, { 7, 2 }, { 7, 9 }, { 9, 5 } };

	for (int i = 0; i < E; i++)
		adj[connections[i].first].push_back(
			connections[i].second);

	int sender = 7, receiver = 9;

	if (dfs(sender, receiver))
		cout << "1";
	else
		cout << "0";

	return 0;
}
// this code is contributed by prophet1999
