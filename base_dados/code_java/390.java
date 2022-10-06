
// Java program to reverse alternate levels of perfect binary tree 
// A binary tree node 
class
Node { 


char
data; 

Node left, right; 


Node(
char
item) { 

data = item; 

left = right = 
null
; 

} 
} 

// class to access index value by reference 
class
Index { 


int
index; 
} 

class
BinaryTree { 


Node root; 

Index index_obj = 
new
Index(); 


// function to store alternate levels in a tree 

void
storeAlternate(Node node, 
char
arr[], Index index, 
int
l) { 

// base case 

if
(node == 
null
) { 

return
; 

} 

// store elements of left subtree 

storeAlternate(node.left, arr, index, l + 
1
); 


// store this node only if level is odd 

if
(l % 
2
!= 
0
) { 

arr[index.index] = node.data; 

index.index++; 

} 


storeAlternate(node.right, arr, index, l + 
1
); 

} 


// Function to modify Binary Tree (All odd level nodes are 

// updated by taking elements from array in inorder fashion) 

void
modifyTree(Node node, 
char
arr[], Index index, 
int
l) { 


// Base case 

if
(node == 
null
) { 

return
; 

} 


// Update nodes in left subtree 

modifyTree(node.left, arr, index, l + 
1
); 


// Update this node only if this is an odd level node 

if
(l % 
2
!= 
0
) { 

node.data = arr[index.index]; 

(index.index)++; 

} 


// Update nodes in right subtree 

modifyTree(node.right, arr, index, l + 
1
); 

} 


// A utility function to reverse an array from index 

// 0 to n-1 

void
reverse(
char
arr[], 
int
n) { 

int
l = 
0
, r = n - 
1
; 

while
(l < r) { 

char
temp = arr[l]; 

arr[l] = arr[r]; 

arr[r] = temp; 

l++; 

r--; 

} 

} 


void
reverseAlternate() { 

reverseAlternate(root); 

} 


// The main function to reverse alternate nodes of a binary tree 

void
reverseAlternate(Node node) { 


// Create an auxiliary array to store nodes of alternate levels 

char
[] arr = 
new
char
[
100
]; 


// First store nodes of alternate levels 

storeAlternate(node, arr, index_obj, 
0
); 


//index_obj.index = 0; 


// Reverse the array 

reverse(arr, index_obj.index); 


// Update tree by taking elements from array 

index_obj.index = 
0
; 

modifyTree(node, arr, index_obj, 
0
); 

} 


void
printInorder() { 

printInorder(root); 

} 


// A utility function to print indorder traversal of a 

// binary tree 

void
printInorder(Node node) { 

if
(node == 
null
) { 

return
; 

} 

printInorder(node.left); 

System.out.print(node.data + 
" "
); 

printInorder(node.right); 

} 


// Driver program to test the above functions 

public
static
void
main(String args[]) { 

BinaryTree tree = 
new
BinaryTree(); 

tree.root = 
new
Node(
'a'
); 

tree.root.left = 
new
Node(
'b'
); 

tree.root.right = 
new
Node(
'c'
); 

tree.root.left.left = 
new
Node(
'd'
); 

tree.root.left.right = 
new
Node(
'e'
); 

tree.root.right.left = 
new
Node(
'f'
); 

tree.root.right.right = 
new
Node(
'g'
); 

tree.root.left.left.left = 
new
Node(
'h'
); 

tree.root.left.left.right = 
new
Node(
'i'
); 

tree.root.left.right.left = 
new
Node(
'j'
); 

tree.root.left.right.right = 
new
Node(
'k'
); 

tree.root.right.left.left = 
new
Node(
'l'
); 

tree.root.right.left.right = 
new
Node(
'm'
); 

tree.root.right.right.left = 
new
Node(
'n'
); 

tree.root.right.right.right = 
new
Node(
'o'
); 

System.out.println(
"Inorder Traversal of given tree"
); 

tree.printInorder(); 


tree.reverseAlternate(); 

System.out.println(
""
); 

System.out.println(
""
); 

System.out.println(
"Inorder Traversal of modified tree"
); 

tree.printInorder(); 

} 
} 

// This code has been contributed by Mayank Jaiswal 