
// Java program to check if there exist an edge whose 
// removal creates two trees of same size 

class
Node 
{ 

int
key; 

Node left, right; 


public
Node(
int
key) 

{ 

this
.key = key; 

left = right = 
null
; 

} 
} 

class
BinaryTree 
{ 

Node root; 


// To calculate size of tree with given root 

int
count(Node node) 

{ 

if
(node == 
null
) 

return
0
; 


return
count(node.left) + count(node.right) + 
1
; 

} 


// This function returns true if there is an edge 

// whose removal can divide the tree in two halves 

// n is size of tree 

boolean
checkRec(Node node, 
int
n) 

{ 

// Base cases 

if
(node == 
null
) 

return
false
; 


// Check for root 

if
(count(node) == n - count(node)) 

return
true
; 


// Check for rest of the nodes 

return
checkRec(node.left, n) 

|| checkRec(node.right, n); 

} 


// This function mainly uses checkRec() 

boolean
check(Node node) 

{ 

// Count total nodes in given tree 

int
n = count(node); 


// Now recursively check all nodes 

return
checkRec(node, n); 

} 


// Driver code 

public
static
void
main(String[] args) 

{ 

BinaryTree tree = 
new
BinaryTree(); 

tree.root = 
new
Node(
5
); 

tree.root.left = 
new
Node(
1
); 

tree.root.right = 
new
Node(
6
); 

tree.root.left.left = 
new
Node(
3
); 

tree.root.right.left = 
new
Node(
7
); 

tree.root.right.right = 
new
Node(
4
); 

if
(tree.check(tree.root)==
true
) 

System.out.println(
"YES"
); 

else

System.out.println(
"NO"
); 

} 
} 

// This code has been contributed by Mayank Jaiswal(mayank_24) 