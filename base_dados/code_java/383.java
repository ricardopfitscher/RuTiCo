
// Java program to find n-th node of 
// Postorder Traversal of Binary Tree 
public
class
NthNodePostOrder { 


static
int
flag = 
0
; 


// function to find the N-th node in the postorder 

// traversal of a given binary tree 

public
static
void
NthPostordernode(Node root, 
int
N) 

{ 


if
(root == 
null
) 

return
; 


if
(flag <= N) 

{ 

// left recursion 

NthPostordernode(root.left, N); 

// right recursion 

NthPostordernode(root.right, N); 

flag++; 

// prints the n-th node of preorder traversal 

if
(flag == N) 

System.out.print(root.data); 

} 

} 



public
static
void
main(String args[]) { 

Node root = 
new
Node(
25
); 

root.left = 
new
Node(
20
); 

root.right = 
new
Node(
30
); 

root.left.left = 
new
Node(
18
); 

root.left.right = 
new
Node(
22
); 

root.right.left = 
new
Node(
24
); 

root.right.right = 
new
Node(
32
); 


int
N = 
6
; 


// prints n-th node found 

NthPostordernode(root, N); 

} 
} 

/* A binary tree node structure */
class
Node 
{ 

int
data; 

Node left, right; 

Node(
int
data) 

{ 

this
.data=data; 

} 
}; 
// This code is contributed by Gaurav Tiwari 