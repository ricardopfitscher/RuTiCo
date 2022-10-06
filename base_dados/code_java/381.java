
// Java program to find inorder successor of a node 
class
Solution 
{ 
// A Binary Tree Node 

static
class
Node 
{ 

int
data; 

Node left, right; 
} 

// Temporary node for case 2 
static
Node temp = 
new
Node(); 

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

temp.left = temp.right = 
null
; 

return
temp; 
} 

// function to find left most node in a tree 
static
Node leftMostNode(Node node) 

{ 

while
(node != 
null
&& node.left != 
null
) 

node = node.left; 

return
node; 
} 

// function to find right most node in a tree 
static
Node rightMostNode(Node node) 

{ 

while
(node != 
null
&& node.right != 
null
) 

node = node.right; 

return
node; 
} 

// recursive function to find the Inorder Scuccessor 
// when the right child of node x is null 
static
Node findInorderRecursive(Node root, Node x ) 

{ 

if
(root==
null
) 

return
null
; 


if
(root==x || (temp = findInorderRecursive(root.left,x))!=
null
|| 

(temp = findInorderRecursive(root.right,x))!=
null
) 

{ 

if
(temp!=
null
) 

{ 

if
(root.left == temp) 

{ 

System.out.print( 
"Inorder Successor of "
+x.data); 

System.out.print( 
" is "
+ root.data + 
"\n"
); 

return
null
; 

} 

} 


return
root; 

} 


return
null
; 
} 

// function to find inorder successor of 
// a node 
static
void
inorderSuccesor(Node root, Node x) 

{ 

// Case1: If right child is not null 

if
(x.right != 
null
) 

{ 

Node inorderSucc = leftMostNode(x.right); 

System.out.print(
"Inorder Successor of "
+x.data+
" is "
); 

System.out.print(inorderSucc.data+
"\n"
); 

} 


// Case2: If right child is null 

if
(x.right == 
null
) 

{ 

int
f = 
0
; 


Node rightMost = rightMostNode(root); 


// case3: If x is the right most node 

if
(rightMost == x) 

System.out.print(
"No inorder successor! Right most node.\n"
); 

else

findInorderRecursive(root, x); 

} 
} 

// Driver program to test above functions 
public
static
void
main(String args[]) 
{ 

// Let's con the binary tree 

// as shown in above diagram 


Node root = newNode(
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


// Case 1 

inorderSuccesor(root, root.right); 


// case 2 

inorderSuccesor(root, root.left.left); 


// case 3 

inorderSuccesor(root, root.right.right); 

} 
} 
//contributed by Arnab Kundu 