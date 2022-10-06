
// Java program to construct tree from inorder traversal 

/* A binary tree node has data, pointer to left child 

and a pointer to right child */
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


/* Recursive function to construct binary of size len from 

Inorder traversal inorder[]. Initial values of start and end 

should be 0 and len -1. */

Node buildTree(
int
inorder[], 
int
start, 
int
end, Node node) 

{ 

if
(start > end) 

return
null
; 


/* Find index of the maximum element from Binary Tree */

int
i = max(inorder, start, end); 


/* Pick the maximum value and make it root */

node = 
new
Node(inorder[i]); 


/* If this is the only element in inorder[start..end], 

then return it */

if
(start == end) 

return
node; 


/* Using index in Inorder traversal, construct left and 

right subtress */

node.left = buildTree(inorder, start, i - 
1
, node.left); 

node.right = buildTree(inorder, i + 
1
, end, node.right); 


return
node; 

} 


/* UTILITY FUNCTIONS */


/* Function to find index of the maximum value in arr[start...end] */

int
max(
int
arr[], 
int
strt, 
int
end) 

{ 

int
i, max = arr[strt], maxind = strt; 

for
(i = strt + 
1
; i <= end; i++) 

{ 

if
(arr[i] > max) 

{ 

max = arr[i]; 

maxind = i; 

} 

} 

return
maxind; 

} 


/* This funtcion is here just to test buildTree() */

void
printInorder(Node node) 

{ 

if
(node == 
null
) 

return
; 


/* first recur on left child */

printInorder(node.left); 


/* then print the data of node */

System.out.print(node.data + 
" "
); 


/* now recur on right child */

printInorder(node.right); 

} 


public
static
void
main(String args[]) 

{ 

BinaryTree tree = 
new
BinaryTree(); 


/* Assume that inorder traversal of following tree is given 

40 

/ \ 

10 30 

/ \ 

5 28 */

int
inorder[] = 
new
int
[]{
5
, 
10
, 
40
, 
30
, 
28
}; 

int
len = inorder.length; 

Node mynode = tree.buildTree(inorder, 
0
, len - 
1
, tree.root); 


/* Let us test the built tree by printing Inorder traversal */

System.out.println(
"Inorder traversal of the constructed tree is "
); 

tree.printInorder(mynode); 

} 
} 

// This code has been contributed by Mayank Jaiswal 