
// Java program to check if two binary tree are cousins 
class
Node 
{ 

int
data; 

Node left, right; 


Node(
int
item) 

{ 

data = item; 

left = right = 
null
; 

} 
} 

class
BinaryTree 
{ 

Node root; 


// Recursive function to check if two Nodes are 

// siblings 

boolean
isSibling(Node node, Node a, Node b) 

{ 

// Base case 

if
(node == 
null
) 

return
false
; 


return
((node.left == a && node.right == b) || 

(node.left == b && node.right == a) || 

isSibling(node.left, a, b) || 

isSibling(node.right, a, b)); 

} 


// Recursive function to find level of Node 'ptr' in 

// a binary tree 

int
level(Node node, Node ptr, 
int
lev) 

{ 

// base cases 

if
(node == 
null
) 

return
0
; 


if
(node == ptr) 

return
lev; 


// Return level if Node is present in left subtree 

int
l = level(node.left, ptr, lev + 
1
); 

if
(l != 
0
) 

return
l; 


// Else search in right subtree 

return
level(node.right, ptr, lev + 
1
); 

} 


// Returns 1 if a and b are cousins, otherwise 0 

boolean
isCousin(Node node, Node a, Node b) 

{ 

// 1. The two Nodes should be on the same level 

// in the binary tree. 

// 2. The two Nodes should not be siblings (means 

// that they should not have the same parent 

// Node). 

return
((level(node, a, 
1
) == level(node, b, 
1
)) && 

(!isSibling(node, a, b))); 

} 


//Driver program to test above functions 

public
static
void
main(String args[]) 

{ 

BinaryTree tree = 
new
BinaryTree(); 

tree.root = 
new
Node(
1
); 

tree.root.left = 
new
Node(
2
); 

tree.root.right = 
new
Node(
3
); 

tree.root.left.left = 
new
Node(
4
); 

tree.root.left.right = 
new
Node(
5
); 

tree.root.left.right.right = 
new
Node(
15
); 

tree.root.right.left = 
new
Node(
6
); 

tree.root.right.right = 
new
Node(
7
); 

tree.root.right.left.right = 
new
Node(
8
); 


Node Node1, Node2; 

Node1 = tree.root.left.left; 

Node2 = tree.root.right.right; 

if
(tree.isCousin(tree.root, Node1, Node2)) 

System.out.println(
"Yes"
); 

else

System.out.println(
"No"
); 

} 
} 

// This code has been contributed by Mayank Jaiswal 