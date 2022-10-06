
// Java program to covert a ternary 
// expreesion to a tree. 
import
java.util.Queue; 
import
java.util.LinkedList; 

// Class to represent Tree node 
class
Node 
{ 

char
data; 

Node left, right; 


public
Node(
char
item) 

{ 

data = item; 

left = 
null
; 

right = 
null
; 

} 
} 

// Class to covert a ternary expression to a Tree 
class
BinaryTree 
{ 

// Function to convert Ternary Expression to a Binary 

// Tree. It return the root of tree 

Node convertExpression(
char
[] expression, 
int
i) 

{ 

// Base case 

if
(i >= expression.length) 

return
null
; 


// store current character of expression_string 

// [ 'a' to 'z'] 

Node root = 
new
Node(expression[i]); 


// Move ahead in str 

++i; 


// if current character of ternary expression is '?' 

// then we add next character as a left child of 

// current node 

if
(i < expression.length && expression[i]==
'?'
) 

root.left = convertExpression(expression, i+
1
); 


// else we have to add it as a right child of 

// current node expression.at(0) == ':' 

else
if
(i < expression.length) 

root.right = convertExpression(expression, i+
1
); 


return
root; 

} 


// function print tree 

public
void
printTree( Node root) 

{ 

if
(root == 
null
) 

return
; 


System.out.print(root.data +
" "
); 

printTree(root.left); 

printTree(root.right); 

} 

// Driver program to test above function 

public
static
void
main(String args[]) 

{ 

String exp = 
"a?b?c:d:e"
; 

BinaryTree tree = 
new
BinaryTree(); 

char
[] expression=exp.toCharArray(); 

Node root = tree.convertExpression(expression, 
0
); 

tree.printTree(root) ; 

} 
} 

/* This code is contributed by Mr. Somesh Awasthi */