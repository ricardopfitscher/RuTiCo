
// Java implementation to replace each node 
// in binary tree with the sum of its inorder 
// predecessor and successor 
import
java.util.*; 
class
Solution 
{ 

// node of a binary tree 
static
class
Node { 

int
data; 

Node left, right; 
} 

//INT class 
static
class
INT 
{ 

int
data; 
} 

// function to get a new node of a binary tree 
static
Node getNode(
int
data) 
{ 

// allocate node 

Node new_node =
new
Node(); 


// put in the data; 

new_node.data = data; 

new_node.left = new_node.right = 
null
; 


return
new_node; 
} 

// function to store the inorder traversal 
// of the binary tree in 'arr' 
static
void
storeInorderTraversal( Node root, 

Vector<Integer> arr) 
{ 

// if root is null 

if
(root==
null
) 

return
; 


// first recur on left child 

storeInorderTraversal(root.left, arr); 


// then store the root's data in 'arr' 

arr.add(root.data); 


// now recur on right child 

storeInorderTraversal(root.right, arr); 
} 

// function to replace each node with the sum of its 
// inorder predecessor and successor 
static
void
replaceNodeWithSum( Node root, 

Vector<Integer> arr, INT i) 
{ 

// if root is null 

if
(root==
null
) 

return
; 


// first recur on left child 

replaceNodeWithSum(root.left, arr, i); 


// replace node's data with the sum of its 

// inorder predecessor and successor 

root.data = arr.get(i.data - 
1
) + arr.get(i.data + 
1
); 


// move 'i' to point to the next 'arr' element 

i.data++; 


// now recur on right child 

replaceNodeWithSum(root.right, arr, i); 
} 

// Utility function to replace each node in binary 
// tree with the sum of its inorder predecessor 
// and successor 
static
void
replaceNodeWithSumUtil( Node root) 
{ 

// if tree is empty 

if
(root==
null
) 

return
; 


Vector<Integer> arr= 
new
Vector<Integer>(); 


// store the value of inorder predecessor 

// for the leftmost leaf 

arr.add(
0
); 


// store the inoder traversal of the tree in 'arr' 

storeInorderTraversal(root, arr); 


// store the value of inorder successor 

// for the rightmost leaf 

arr.add(
0
); 


// replace each node with the required sum 

INT i = 
new
INT(); 


i.data=
1
; 


replaceNodeWithSum(root, arr, i); 
} 

// function to print the preorder traversal 
// of a binary tree 
static
void
preorderTraversal( Node root) 
{ 

// if root is null 

if
(root==
null
) 

return
; 


// first print the data of node 

System.out.print( root.data + 
" "
); 


// then recur on left subtree 

preorderTraversal(root.left); 


// now recur on right subtree 

preorderTraversal(root.right); 
} 

// Driver program to test above 
public
static
void
main(String args[]) 
{ 

// binary tree formation 

Node root = getNode(
1
); 
// 1 

root.left = getNode(
2
); 
// / \ 

root.right = getNode(
3
); 
// 2 3 

root.left.left = getNode(
4
); 
// / \ / \ 

root.left.right = getNode(
5
); 
// 4 5 6 7 

root.right.left = getNode(
6
); 

root.right.right = getNode(
7
); 


System.out.println( 
"Preorder Traversal before tree modification:"
); 

preorderTraversal(root); 


replaceNodeWithSumUtil(root); 


System.out.println(
"\nPreorder Traversal after tree modification:"
); 

preorderTraversal(root); 

} 
} 
//contributed by Arnab Kundu 