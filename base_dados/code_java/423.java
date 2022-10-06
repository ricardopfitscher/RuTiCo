
/* Java program to check if all three given 
traversals are of the same tree */
import
java.util.*; 
class
GfG { 

static
int
preIndex = 
0
; 

// A Binary Tree Node 
static
class
Node 
{ 

int
data; 

Node left, right; 
} 

// Utility function to create a new tree node 
static
Node newNode(
int
data) 
{ 

Node temp = 
new
Node(); 

temp.data = data; 

temp.left = 
null
; 

temp.right = 
null
; 

return
temp; 
} 

/* Function to find index of value in arr[start...end] 
The function assumes that value is present in in[] */
static
int
search(
int
arr[], 
int
strt, 
int
end, 
int
value) 
{ 

for
(
int
i = strt; i <= end; i++) 

{ 

if
(arr[i] == value) 

return
i; 

} 

return
-
1
; 
} 

/* Recursive function to construct binary tree 
of size len from Inorder traversal in[] and 
Preorder traversal pre[]. Initial values 
of inStrt and inEnd should be 0 and len -1. 
The function doesn't do any error checking for 
cases where inorder and preorder do not form a 
tree */
static
Node buildTree(
int
in[], 
int
pre[], 
int
inStrt, 
int
inEnd) 
{ 


if
(inStrt > inEnd) 

return
null
; 


/* Pick current node from Preorder traversal 

using preIndex and increment preIndex */

Node tNode = newNode(pre[preIndex++]); 


/* If this node has no children then return */

if
(inStrt == inEnd) 

return
tNode; 


/* Else find the index of this node in 

Inorder traversal */

int
inIndex = search(in, inStrt, inEnd, tNode.data); 


/* Using index in Inorder traversal, 

construct left and right subtress */

tNode.left = buildTree(in, pre, inStrt, inIndex-
1
); 

tNode.right = buildTree(in, pre, inIndex+
1
, inEnd); 


return
tNode; 
} 

/* function to compare Postorder traversal 
on constructed tree and given Postorder */
static
int
checkPostorder(Node node, 
int
postOrder[], 
int
index) 
{ 

if
(node == 
null
) 

return
index; 


/* first recur on left child */

index = checkPostorder(node.left,postOrder,index); 


/* now recur on right child */

index = checkPostorder(node.right,postOrder,index); 


/* Compare if data at current index in 

both Postorder traversals are same */

if
(node.data == postOrder[index]) 

index++; 

else

return
-
1
; 


return
index; 
} 

// Driver program to test above functions 
public
static
void
main(String[] args) 
{ 

int
inOrder[] = {
4
, 
2
, 
5
, 
1
, 
3
}; 

int
preOrder[] = {
1
, 
2
, 
4
, 
5
, 
3
}; 

int
postOrder[] = {
4
, 
5
, 
2
, 
3
, 
1
}; 


int
len = inOrder.length; 


// build tree from given 

// Inorder and Preorder traversals 

Node root = buildTree(inOrder, preOrder, 
0
, len - 
1
); 


// compare postorder traversal on constructed 

// tree with given Postorder traversal 

int
index = checkPostorder(root,postOrder,
0
); 


// If both postorder traversals are same 

if
(index == len) 

System.out.println(
"Yes"
); 

else

System.out.println(
"No"
); 

} 
} 