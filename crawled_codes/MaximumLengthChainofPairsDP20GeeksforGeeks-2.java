//https://www.geeksforgeeks.org/maximum-length-chain-of-pairs-dp-20/
//O(n^2)
// Java program for above approach
import java.util.*;

class GFG{

// Structure val
static class val
{
	int first;
	int second;
};

static class pair
{
	int first, second;
	
	public pair(int first, int second)
	{
		this.first = first;
		this.second = second;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + first;
		result = prime * result + second;
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
			
		pair other = (pair) obj;
		if (first != other.first)
			return false;
		if (second != other.second)
			return false;
			
		return true;
	}
	
}

static Map<pair, Integer> m = new HashMap<>();

// Memoisation function
static int findMaxChainLen(val p[], int n,
						int prev, int pos)
{
	
	// Check if pair { pos, prev } exists
	// in m
	if (m.containsKey(new pair(pos, prev)))
	{
		return m.get(new pair(pos, prev));
	}

	// Check if pos is >=n
	if (pos >= n)
		return 0;

	// Check if p[pos].first is
	// less than prev
	if (p[pos].first <= prev)
	{
		return findMaxChainLen(p, n, prev,
							pos + 1);
	}

	else
	{
		int ans = Math.max(findMaxChainLen(
							p, n, p[pos].second, 0) + 1,
						findMaxChainLen(
							p, n, prev, pos + 1));
								
		m.put(new pair(pos, prev), ans);
		return ans;
	}
}

// Function to calculate maximum
// chain length
static int maxChainLen(val p[], int n)
{
	m.clear();

	// Call memoisation function
	int ans = findMaxChainLen(p, n, 0, 0);
	return ans;
}

// Driver Code
public static void main(String[] args)
{
	int n = 5;
	val []p = new val[n];
	for(int i = 0; i < n; i++)
		p[i] = new val();
		
	p[0].first = 5;
	p[0].second = 24;

	p[1].first = 39;
	p[1].second = 60;

	p[2].first = 15;
	p[2].second = 28;

	p[3].first = 27;
	p[3].second = 40;

	p[4].first = 50;
	p[4].second = 90;
	
	// Function Call
	System.out.print(maxChainLen(p, n) + "\n");
}
}

// This code is contributed by 29AjayKumar
