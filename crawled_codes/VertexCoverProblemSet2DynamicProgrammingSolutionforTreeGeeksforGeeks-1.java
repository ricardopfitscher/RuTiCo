//https://www.geeksforgeeks.org/vertex-cover-problem-set-2-dynamic-programming-solution-tree/
//O(n)
// A naive recursive Java implementation
// for vertex cover problem for a tree

class GFG
{
	// A utility function to find min of two integers
	static int min(int x, int y)
	{
		return (x < y) ? x : y;
	}

	/*
	* A binary tree node has data, pointer
	to left child and a pointer to right
	* child
	*/
	static class node
	{
		int data;
		node left, right;
	};

	// The function returns size
	// of the minimum vertex cover
	static int vCover(node root)
	{
		// The size of minimum vertex cover
		// is zero if tree is empty or there
		// is only one node
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 0;

		// Calculate size of vertex cover
		// when root is part of it
		int size_incl = 1 + vCover(root.left) +
							vCover(root.right);

		// Calculate size of vertex cover
		// when root is not part of it
		int size_excl = 0;
		if (root.left != null)
			size_excl += 1 + vCover(root.left.left) +
							vCover(root.left.right);
		if (root.right != null)
			size_excl += 1 + vCover(root.right.left) +
								vCover(root.right.right);

		// Return the minimum of two sizes
		return Math.min(size_incl, size_excl);
	}

	// A utility function to create a node
	static node newNode(int data)
	{
		node temp = new node();
		temp.data = data;
		temp.left = temp.right = null;
		return temp;
	}

	// Driver code
	public static void main(String[] args)
	{
		// Let us construct tree given in the above diagram
		node root = newNode(20);
		root.left = newNode(8);
		root.left.left = newNode(4);
		root.left.right = newNode(12);
		root.left.right.left = newNode(10);
		root.left.right.right = newNode(14);
		root.right = newNode(22);
		root.right.right = newNode(25);

		System.out.printf("Size of the smallest vertex" +
							"cover is %d ", vCover(root));

	}
}

// This code is contributed by 29AjayKumar
