
// Java code to add all greater values to 
// every node in a given BST 

// A binary tree node 
class
Node { 


int
data; 

Node left, right; 


Node(
int
d) 

{ 

data = d; 

left = right = 
null
; 

} 
} 

class
BinarySearchTree { 


// Root of BST 

Node root; 


// Constructor 

BinarySearchTree() 

{ 

root = 
null
; 

} 


// Inorder traversal of the tree 

void
inorder() 

{ 

inorderUtil(
this
.root); 

} 


// Utility function for inorder traversal of 

// the tree 

void
inorderUtil(Node node) 

{ 

if
(node == 
null
) 

return
; 


inorderUtil(node.left); 

System.out.print(node.data + 
" "
); 

inorderUtil(node.right); 

} 


// adding new node 

public
void
insert(
int
data) 

{ 

this
.root = 
this
.insertRec(
this
.root, data); 

} 


/* A utility function to insert a new node with 

given data in BST */

Node insertRec(Node node, 
int
data) 

{ 

/* If the tree is empty, return a new node */

if
(node == 
null
) { 

this
.root = 
new
Node(data); 

return
this
.root; 

} 


/* Otherwise, recur down the tree */

if
(data <= node.data) { 

node.left = 
this
.insertRec(node.left, data); 

} 
else
{ 

node.right = 
this
.insertRec(node.right, data); 

} 

return
node; 

} 


// This class initialises the value of sum to 0 

public
class
Sum { 

int
sum = 
0
; 

} 


// Recursive function to add all greater values in 

// every node 

void
modifyBSTUtil(Node node, Sum S) 

{ 

// Base Case 

if
(node == 
null
) 

return
; 


// Recur for right subtree 

this
.modifyBSTUtil(node.right, S); 


// Now *sum has sum of nodes in right subtree, add 

// root->data to sum and update root->data 

S.sum = S.sum + node.data; 

node.data = S.sum; 


// Recur for left subtree 

this
.modifyBSTUtil(node.left, S); 

} 


// A wrapper over modifyBSTUtil() 

void
modifyBST(Node node) 

{ 

Sum S = 
new
Sum(); 

this
.modifyBSTUtil(node, S); 

} 


// Driver Function 

public
static
void
main(String[] args) 

{ 

BinarySearchTree tree = 
new
BinarySearchTree(); 


/* Let us create following BST 

50 

/ \ 

30 70 

/ \ / \ 

20 40 60 80 */


tree.insert(
50
); 

tree.insert(
30
); 

tree.insert(
20
); 

tree.insert(
40
); 

tree.insert(
70
); 

tree.insert(
60
); 

tree.insert(
80
); 


tree.modifyBST(tree.root); 


// print inoder tarversal of the modified BST 

tree.inorder(); 

} 
} 

// This code is contributed by Kamal Rawal 