
// A naive recursive implementation of 
// Largest Independent Set problem 
class
GFG { 

// A utility function to find 
// max of two integers 
static
int
max(
int
x, 
int
y) 
{ 

return
(x > y) ? x : y; 
} 

/* A binary tree node has data, 
pointer to left child and a 
pointer to right child */
static
class
Node 
{ 

int
data; 

Node left, right; 
}; 

// The function returns size of the 
// largest independent set in a given 
// binary tree 
static
int
LISS(Node root) 
{ 

if
(root == 
null
) 

return
0
; 


// Calculate size excluding the current node 

int
size_excl = LISS(root.left) + 

LISS(root.right); 


// Calculate size including the current node 

int
size_incl = 
1
; 

if
(root.left!=
null
) 

size_incl += LISS(root.left.left) + 

LISS(root.left.right); 

if
(root.right!=
null
) 

size_incl += LISS(root.right.left) + 

LISS(root.right.right); 


// Return the maximum of two sizes 

return
max(size_incl, size_excl); 
} 

// A utility function to create a node 
static
Node newNode( 
int
data ) 
{ 

Node temp = 
new
Node(); 

temp.data = data; 

temp.left = temp.right = 
null
; 

return
temp; 
} 

// Driver Code 
public
static
void
main(String args[]) { 

// Let us construct the tree 

// given in the above diagram 

Node root = newNode(
20
); 

root.left = newNode(
8
); 

root.left.left = newNode(
4
); 

root.left.right = newNode(
12
); 

root.left.right.left = newNode(
10
); 

root.left.right.right = newNode(
14
); 

root.right = newNode(
22
); 

root.right.right = newNode(
25
); 


System.out.println(
"Size of the Largest"

+ 
" Independent Set is "

+ LISS(root)); 

} 
} 

// This code has been contributed by 29AjayKumar 