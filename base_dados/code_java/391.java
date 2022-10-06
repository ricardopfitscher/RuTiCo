
// Java program to reverse alternate levels of a tree 
class
Sol 
{ 

static
class
Node 
{ 

char
key; 

Node left, right; 
}; 

static
void
preorder( Node root1, Node root2, 
int
lvl) 
{ 

// Base cases 

if
(root1 == 
null
|| root2==
null
) 

return
; 


// Swap subtrees if level is even 

if
(lvl % 
2
== 
0
) 

{ 

char
t = root1.key; 

root1.key = root2.key; 

root2.key = t; 

} 


// Recur for left and right subtrees (Note : left of root1 

// is passed and right of root2 in first call and opposite 

// in second call. 

preorder(root1.left, root2.right, lvl+
1
); 

preorder(root1.right, root2.left, lvl+
1
); 
} 

// This function calls preorder() for left and right children 
// of root 
static
void
reverseAlternate( Node root) 
{ 

preorder(root.left, root.right, 
0
); 
} 

// Inorder traversal (used to print initial and 
// modified trees) 
static
void
printInorder( Node root) 
{ 

if
(root == 
null
) 

return
; 

printInorder(root.left); 

System.out.print( root.key + 
" "
); 

printInorder(root.right); 
} 

// A utility function to create a new node 
static
Node newNode(
int
key) 
{ 

Node temp = 
new
Node(); 

temp.left = temp.right = 
null
; 

temp.key = (
char
)key; 

return
temp; 
} 

// Driver program to test above functions 
public
static
void
main(String args[]) 
{ 

Node root = newNode(
'a'
); 

root.left = newNode(
'b'
); 

root.right = newNode(
'c'
); 

root.left.left = newNode(
'd'
); 

root.left.right = newNode(
'e'
); 

root.right.left = newNode(
'f'
); 

root.right.right = newNode(
'g'
); 

root.left.left.left = newNode(
'h'
); 

root.left.left.right = newNode(
'i'
); 

root.left.right.left = newNode(
'j'
); 

root.left.right.right = newNode(
'k'
); 

root.right.left.left = newNode(
'l'
); 

root.right.left.right = newNode(
'm'
); 

root.right.right.left = newNode(
'n'
); 

root.right.right.right = newNode(
'o'
); 


System.out.print(
"Inorder Traversal of given tree\n"
); 

printInorder(root); 


reverseAlternate(root); 


System.out.print(
"\n\nInorder Traversal of modified tree\n"
); 

printInorder(root); 

} 
} 

// This code is contributed by Arnab Kundu 