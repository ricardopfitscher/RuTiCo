
// Java program to find the all full nodes in 
// a given binary tree 
public
class
FullNodes { 


// Traverses given tree in Inorder fashion and 

// prints all nodes that have both children as 

// non-empty. 

public
static
void
findFullNode(Node root) 

{ 

if
(root != 
null
) 

{ 

findFullNode(root.left); 

if
(root.left != 
null
&& root.right != 
null
) 

System.out.print(root.data+
" "
); 

findFullNode(root.right); 

} 

} 


public
static
void
main(String args[]) { 

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

root.right.left = 
new
Node(
5
); 

root.right.right = 
new
Node(
6
); 

root.right.left.right = 
new
Node(
7
); 

root.right.right.right = 
new
Node(
8
); 

root.right.left.right.left = 
new
Node(
9
); 

findFullNode(root); 

} 
} 

/* A binary tree node */
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

left=right=
null
; 

this
.data=data; 

} 
}; 
//This code is contributed by Gaurav Tiwari 