//https://www.geeksforgeeks.org/channel-assignment-problem/
//O(m+n)
import java.util.*;
class GFG
{
static int M = 3;
static int N = 3;

// A Depth First Search based recursive function
// that returns true if a matching for vertex u is possible
static boolean bpm(int table[][], int u,
				boolean seen[], int matchR[])
{
	// Try every receiver one by one
	for (int v = 0; v < N; v++)
	{
		// If sender u has packets to send
		// to receiver v and receiver v is not
		// already mapped to any other sender
		// just check if the number of packets is
		// greater than '0' because only one packet
		// can be sent in a time frame anyways
		if (table[u][v] > 0 && !seen[v])
		{
			seen[v] = true; // Mark v as visited

			// If receiver 'v' is not assigned to
			// any sender OR previously assigned sender
			// for receiver v (which is matchR[v]) has an
			// alternate receiver available. Since v is
			// marked as visited in the above line,
			// matchR[v] in the following recursive call
			// will not get receiver 'v' again
			if (matchR[v] < 0 || bpm(table, matchR[v],
									seen, matchR))
			{
				matchR[v] = u;
				return true;
			}
		}
	}
	return false;
}

// Returns maximum number of packets
// that can be sent parallelly in
// 1 time slot from sender to receiver
static int maxBPM(int table[][])
{
	// An array to keep track of the receivers
	// assigned to the senders. The value of matchR[i]
	// is the sender ID assigned to receiver i.
	// The value -1 indicates nobody is assigned.
	int []matchR = new int[N];

	// Initially all receivers are
	// not mapped to any senders
	Arrays.fill(matchR, -1);

	int result = 0; // Count of receivers assigned to senders
	for (int u = 0; u < M; u++)
	{
		// Mark all receivers as not seen for next sender
		boolean []seen = new boolean[N];
		Arrays.fill(seen, false);

		// Find if the sender 'u' can be
		// assigned to the receiver
		if (bpm(table, u, seen, matchR))
			result++;
	}

	System.out.println("The number of maximum packets" +
					" sent in the time slot is " + result);

	for (int x = 0; x < N; x++)
		if (matchR[x] + 1 != 0)
			System.out.println("T" + (matchR[x] + 1) +
							"-> R" + (x + 1));
	return result;
}

// Driver Code
public static void main(String[] args)
{
	int table[][] = {{0, 2, 0},
					{3, 0, 1},
					{2, 4, 0}};
	
	maxBPM(table);
}
}

// This code is contributed by Rajput-Ji
