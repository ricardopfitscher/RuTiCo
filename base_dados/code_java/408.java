
/* Java program to convert left-right to 
down-right representation of binary tree */
class
GFG 
{ 

// A Binary Tree Node 
static
class
node 
{ 

int
key; 

node left, right; 

node(
int
key) 

{ 

this
.key = key; 

this
.left = 
null
; 

this
.right = 
null
; 

} 
} 

// An Iterative level order traversal 
// based function to convert left-right 
// to down-right representation. 
static
void
convert(node root) 
{ 

// Base Case 

if
(root == 
null
) 
return
; 


// Recursively convert left 

// an right subtrees 

convert(root.left); 

convert(root.right); 


// If left child is NULL, make right 

// child as left as it is the first child. 

if
(root.left == 
null
) 

root.left = root.right; 


// If left child is NOT NULL, then make 

// right child as right of left child 

else

root.left.right = root.right; 


// Set root's right as NULL 

root.right = 
null
; 
} 

// A utility function to traverse a 
// tree stored in down-right form. 
static
void
downRightTraversal(node root) 
{ 

if
(root != 
null
) 

{ 

System.out.print(root.key + 
" "
); 

downRightTraversal(root.right); 

downRightTraversal(root.left); 

} 
} 

// Utility function to create 
// a new tree node 
static
node newNode(
int
key) 
{ 

node temp = 
new
node(
0
); 

temp.key = key; 

temp.left = 
null
; 

temp.right = 
null
; 

return
temp; 
} 

// Driver Code 
public
static
void
main(String[] args) 
{ 

// Let us create binary tree 

// shown in above diagram 

/* 

1 

/ \ 

2 3 

/ \ 

4 5 

/ / \ 

6 7 8 

*/

node root = 
new
node(
1
); 

root.left = newNode(
2
); 

root.right = newNode(
3
); 

root.right.left = newNode(
4
); 

root.right.right = newNode(
5
); 

root.right.left.left = newNode(
6
); 

root.right.right.left = newNode(
7
); 

root.right.right.right = newNode(
8
); 


convert(root); 


System.out.println(
"Traversal of the tree "
+ 

"converted to down-right form"
); 

downRightTraversal(root); 
} 
} 

// This code is contributed 
// by Prerna Saini 