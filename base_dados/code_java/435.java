
// Recursive Java program to print odd level nodes 
class
GfG { 

static
class
Node { 

int
data; 

Node left, right; 
} 

static
void
printOddNodes(Node root, 
boolean
isOdd) 
{ 

// If empty tree 

if
(root == 
null
) 

return
; 


// If current node is of odd level 

if
(isOdd == 
true
) 

System.out.print(root.data + 
" "
); 


// Recur for children with isOdd 

// switched. 

printOddNodes(root.left, !isOdd); 

printOddNodes(root.right, !isOdd); 
} 

// Utility method to create a node 
static
Node newNode(
int
data) 
{ 

Node node = 
new
Node(); 

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

// Driver code 
public
static
void
main(String[] args) 
{ 

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

printOddNodes(root, 
true
); 

} 
} 