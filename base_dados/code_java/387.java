
// A recursive java program to print reverse level order traversal 

// A binary tree node 
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

left = right; 

} 
} 

class
BinaryTree 
{ 

Node root; 


/* Function to print REVERSE level order traversal a tree*/

void
reverseLevelOrder(Node node) 

{ 

int
h = height(node); 

int
i; 

for
(i = h; i >= 
1
; i--) 

//THE ONLY LINE DIFFERENT FROM NORMAL LEVEL ORDER 

{ 

printGivenLevel(node, i); 

} 

} 


/* Print nodes at a given level */

void
printGivenLevel(Node node, 
int
level) 

{ 

if
(node == 
null
) 

return
; 

if
(level == 
1
) 

System.out.print(node.data + 
" "
); 

else
if
(level > 
1
) 

{ 

printGivenLevel(node.left, level - 
1
); 

printGivenLevel(node.right, level - 
1
); 

} 

} 


/* Compute the "height" of a tree -- the number of 

nodes along the longest path from the root node 

down to the farthest leaf node.*/

int
height(Node node) 

{ 

if
(node == 
null
) 

return
0
; 

else

{ 

/* compute the height of each subtree */

int
lheight = height(node.left); 

int
rheight = height(node.right); 


/* use the larger one */

if
(lheight > rheight) 

return
(lheight + 
1
); 

else

return
(rheight + 
1
); 

} 

} 


// Driver program to test above functions 

public
static
void
main(String args[]) 

{ 

BinaryTree tree = 
new
BinaryTree(); 


// Let us create trees shown in above diagram 

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


System.out.println(
"Level Order traversal of binary tree is : "
); 

tree.reverseLevelOrder(tree.root); 

} 
} 

// This code has been contributed by Mayank Jaiswal 