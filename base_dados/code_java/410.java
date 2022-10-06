
// Java program to store sum of nodes in left subtree in every 
// node 
class
GfG { 

// A tree node 
static
class
node 
{ 

int
data; 

node left, right; 
} 

// Function to modify a Binary Tree so that every node 
// stores sum of values in its left child including its 
// own value 
static
int
updatetree(node root) 
{ 

// Base cases 

if
(root == 
null
) 

return
0
; 

if
(root.left == 
null
&& root.right == 
null
) 

return
root.data; 


// Update left and right subtrees 

int
leftsum = updatetree(root.left); 

int
rightsum = updatetree(root.right); 


// Add leftsum to current node 

root.data += leftsum; 


// Return sum of values under root 

return
root.data + rightsum; 
} 

// Utility function to do inorder traversal 
static
void
inorder(node node) 
{ 

if
(node == 
null
) 

return
; 

inorder(node.left); 

System.out.print(node.data + 
" "
); 

inorder(node.right); 
} 

// Utility function to create a new node 
static
node newNode(
int
data) 
{ 

node node = 
new
node(); 

node.data = data; 

node.left = 
null
; 

node.right = 
null
; 

return
(node); 
} 

// Driver program 
public
static
void
main(String[] args) 
{ 

/* Let us construct below tree 

1 

/ \ 

2 3 

/ \ \ 

4 5 6 */

node root = newNode(
1
); 

root.left = newNode(
2
); 

root.right = newNode(
3
); 

root.left.left = newNode(
4
); 

root.left.right = newNode(
5
); 

root.right.right = newNode(
6
); 


updatetree(root); 



System.out.println(
"Inorder traversal of the modified tree is"
); 

inorder(root); 
} 
} 