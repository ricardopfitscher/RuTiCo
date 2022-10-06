
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
Res 
{ 

boolean
res = 
false
; 
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


// This function returns size of tree rooted with given 

// root. It also set "res" as true if there is an edge 

// whose removal divides tree in two halves. 

// n is size of tree 

int
checkRec(Node root, 
int
n, Res res) 

{ 

// Base case 

if
(root == 
null
) 

return
0
; 


// Compute sizes of left and right children 

int
c = checkRec(root.left, n, res) + 
1

+ checkRec(root.right, n, res); 


// If required property is true for current node 

// set "res" as true 

if
(c == n - c) 

res.res = 
true
; 


// Return size 

return
c; 

} 


// This function mainly uses checkRec() 

boolean
check(Node root) 

{ 

// Count total nodes in given tree 

int
n = count(root); 


// Initialize result and recursively check all nodes 

Res res = 
new
Res(); 

checkRec(root, n, res); 


return
res.res; 

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
(tree.check(tree.root) == 
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