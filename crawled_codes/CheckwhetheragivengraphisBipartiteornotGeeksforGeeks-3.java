//https://www.geeksforgeeks.org/bipartite-graph/
//O(v+e)
import java.util.*;

public class GFG{
	
	static class Pair{
		int first, second;
		
		Pair(int f, int s){
			first = f;
			second = s;
		}
	}
	
	static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj)
	{
	
		// vector to store colour of vertex
		// assigning all to -1 i.e. uncoloured
		// colours are either 0 or 1
		// for understanding take 0 as red and 1 as blue
		int col[] = new int[V];
		Arrays.fill(col, -1);
	
		// queue for BFS storing {vertex , colour}
		Queue<Pair> q = new LinkedList<Pair>();
	
		//loop incase graph is not connected
		for (int i = 0; i < V; i++) {
		
		// if not coloured
			if (col[i] == -1) {
			
			// colouring with 0 i.e. red
				q.add(new Pair(i, 0));
				col[i] = 0;
			
				while (!q.isEmpty()) {
					Pair p = q.peek();
					q.poll();
				
					//current vertex
					int v = p.first;
				
					// colour of current vertex
					int c = p.second;
					
					// traversing vertexes connected to current vertex
					for (int j : adj.get(v))
					{
					
						// if already coloured with parent vertex color
						// then bipartite graph is not possible
						if (col[j] == c)
							return false;
					
						// if uncoloured
						if (col[j] == -1)
						{
						
						// colouring with opposite color to that of parent
							col[j] = (c==1) ? 0 : 1;
							q.add(new Pair(j, col[j]));
						}
					}
				}
			}
		}
	
		// if all vertexes are coloured such that
		// no two connected vertex have same colours
		return true;
	}
	
	// Driver Code Starts.
	public static void main(String args[])
	{
	
		int V, E;
		V = 4 ;
		E = 8;
		
		// adjacency list for storing graph
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < V; i++){
			adj.add(new ArrayList<Integer>());
		}
		
		adj.get(0).add(1);
		adj.get(0).add(3);
		
		adj.get(1).add(0);
		adj.get(1).add(2);
		
		adj.get(2).add(1);
		adj.get(2).add(3);
		
		adj.get(3).add(0);
		adj.get(3).add(2);
		
		boolean ans = isBipartite(V, adj);
		
		// returns 1 if bipartite graph is possible
		if (ans)
			System.out.println("Yes");
	
		// returns 0 if bipartite graph is not possible
		else
			System.out.println("No");
	
	}
}

// This code is contributed by adityapande88.
