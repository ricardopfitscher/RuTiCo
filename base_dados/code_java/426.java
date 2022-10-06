
//A Java program to check if a given binary tree is complete or not 

import
java.util.LinkedList; 
import
java.util.Queue; 

public
class
CompleteBTree 
{ 

/* A binary tree node has data, a pointer to left child 

and a pointer to right child */

static
class
Node 

{ 

int
data; 

Node left; 

Node right; 


// Constructor 

Node(
int
d) 

{ 

data = d; 

left = 
null
; 

right = 
null
; 

} 

} 


/* Given a binary tree, return true if the tree is complete 

else false */

static
boolean
isCompleteBT(Node root) 

{ 

// Base Case: An empty tree is complete Binary Tree 

if
(root == 
null
) 

return
true
; 


// Create an empty queue 

Queue<Node> queue =
new
LinkedList<>(); 


// Create a flag variable which will be set true 

// when a non full node is seen 

boolean
flag = 
false
; 


// Do level order traversal using queue. 

queue.add(root); 

while
(!queue.isEmpty()) 

{ 

Node temp_node = queue.remove(); 


/* Check if left child is present*/

if
(temp_node.left != 
null
) 

{ 

// If we have seen a non full node, and we see a node 

// with non-empty left child, then the given tree is not 

// a complete Binary Tree 

if
(flag == 
true
) 

return
false
; 


// Enqueue Left Child 

queue.add(temp_node.left); 

} 

// If this a non-full node, set the flag as true 

else

flag = 
true
; 


/* Check if right child is present*/

if
(temp_node.right != 
null
) 

{ 

// If we have seen a non full node, and we see a node 

// with non-empty right child, then the given tree is not 

// a complete Binary Tree 

if
(flag == 
true
) 

return
false
; 


// Enqueue Right Child 

queue.add(temp_node.right); 


} 

// If this a non-full node, set the flag as true 

else

flag = 
true
; 

} 

// If we reach here, then the tree is complete Binary Tree 

return
true
; 

} 


/* Driver program to test above functions*/

public
static
void
main(String[] args) 

{ 


/* Let us construct the following Binary Tree which 

is not a complete Binary Tree 

1 

/ \ 

2 3 

/ \ \ 

4 5 6 

*/


Node root = 
new
Node(
1
); 

root.left = 
new
Node(
2
); 

root.right = 
new
Node(
3
); 

root.left.left = 
new
Node(
4
); 

root.left.right = 
new
Node(
5
); 

root.right.right = 
new
Node(
6
); 


if
(isCompleteBT(root) == 
true
) 

System.out.println(
"Complete Binary Tree"
); 

else

System.out.println(
"NOT Complete Binary Tree"
); 

} 

} 
//This code is contributed by Sumit Ghosh 