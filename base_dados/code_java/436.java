
// Iterative Java program to print odd level nodes 
import
java.util.*; 
class
GfG { 

static
class
Node { 

int
data; 

Node left, right; 
} 

// Iterative method to do level order traversal line by line 
static
void
printOddNodes(Node root) 
{ 

// Base Case 

if
(root == 
null
) 
return
; 


// Create an empty queue for level 

// order tarversal 

Queue<Node> q = 
new
LinkedList<Node> (); 


// Enqueue root and initialize level as odd 

q.add(root); 

boolean
isOdd = 
true
; 


while
(
true
) 

{ 

// nodeCount (queue size) indicates 

// number of nodes at current level. 

int
nodeCount = q.size(); 

if
(nodeCount == 
0
) 

break
; 


// Dequeue all nodes of current level 

// and Enqueue all nodes of next level 

while
(nodeCount > 
0
) 

{ 

Node node = q.peek(); 

if
(isOdd == 
true
) 

System.out.print(node.data + 
" "
); 

q.remove(); 

if
(node.left != 
null
) 

q.add(node.left); 

if
(node.right != 
null
) 

q.add(node.right); 

nodeCount--; 

} 


isOdd = !isOdd; 

} 
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

printOddNodes(root); 
} 
} 