//https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/
//O(n^2 * m)
// Java program to find length
// of the shortest chain
// transformation from source
// to target
import java.util.*;

class GFG{
static class pair
{
	String first;
	int second;
	public pair(String first, int second)
	{
	this.first = first;
	this.second = second;
	}
}

// Returns length of shortest chain
// to reach 'target' from 'start'
// using minimum number of adjacent
// moves. D is dictionary
static int shortestChainLen(
	String start, String target,
	HashSet<String> D)
{

	if(start == target)
	return 0;

	// Map of intermediate words and
	// the list of original words
	Map<String, Vector<String>> umap = new HashMap<>();

	// Find all the intermediate
	// words for the start word
	for(int i = 0; i < start.length(); i++)
	{
	String str = start.substring(0,i) + "*" +
		start.substring(i+1);
	Vector<String> s = umap.get(str);
	if(s==null)
		s = new Vector<String>();
	s.add(start);
	umap.put(str, s);
	}

	// Find all the intermediate words for
	// the words in the given Set
	for(String it : D)
	{
	String word = it;
	for(int j = 0; j < word.length(); j++)
	{
		String str = word.substring(0, j) + "*" +
		word.substring(j + 1);
		Vector<String> s = umap.get(str);
		if(s == null)
		s = new Vector<String>();
		s.add(word);
		umap.put(str, s);
	}
	}

	// Perform BFS and push (word, distance)
	Queue<pair> q = new LinkedList<>();

	Map<String, Integer> visited = new HashMap<String, Integer>();

	q.add(new pair(start, 1));
	visited.put(start, 1);

	// Traverse until queue is empty
	while(!q.isEmpty())
	{
	pair p = q.peek();
	q.remove();

	String word = p.first;
	int dist = p.second;

	// If target word is found
	if(word == target)
	{
		return dist;
	}

	// Finding intermediate words for
	// the word in front of queue
	for(int i = 0; i < word.length(); i++)
	{
		String str = word.substring(0, i) + "*" +
		word.substring(i + 1);

		Vector<String> vect = umap.get(str);
		for(int j = 0; j < vect.size(); j++)
		{
		// If the word is not visited
		if(!visited.containsKey(vect.get(j)) )
		{
			visited.put(vect.get(j), 1);
			q.add(new pair(vect.get(j), dist + 1));
		}
		}
	}

	}

	return 0;
}

// Driver code
public static void main(String[] args)
{

	// Make dictionary
	HashSet<String> D = new HashSet<String>();
	D.add("poon");
	D.add("plee");
	D.add("same");
	D.add("poie");
	D.add("plie");
	D.add("poin");
	D.add("plea");
	String start = "toon";
	String target = "plea";
	System.out.print("Length of shortest chain is: "
					+ shortestChainLen(start, target, D));
}
}

// This code is contributed by 29AjayKumar
