
// Java program to flip a binary tree 
import
java.util.*; 
class
GFG 
{ 

// A binary tree node 
static
class
Node 
{ 

int
data; 

Node left, right; 
}; 

// Utility function to create 
// a new Binary Tree Node 

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

// method to flip the binary tree 
static
Node flipBinaryTree(Node root) 
{ 

// Initialization of pointers 

Node curr = root; 

Node next = 
null
; 

Node temp = 
null
; 

Node prev = 
null
; 


// Iterate through all left nodes 

while
(curr != 
null
) 

{ 

next = curr.left; 


// Swapping nodes now, need 

// temp to keep the previous 

// right child 


// Making prev's right 

// as curr's left child 

curr.left = temp; 


// Storing curr's right child 

temp = curr.right; 


// Making prev as curr's 

// right child 

curr.right = prev; 


prev = curr; 

curr = next; 

} 

return
prev; 
} 

// Iterative method to do 
// level order traversal 
// line by line 
static
void
printLevelOrder(Node root) 
{ 

// Base Case 

if
(root == 
null
) 
return
; 


// Create an empty queue for 

// level order traversal 

Queue<Node> q = 
new
LinkedList<Node>(); 


// Enqueue Root and 

// initialize height 

q.add(root); 


while
(
true
) 

{ 

// nodeCount (queue size) 

// indicates number of nodes 

// at current lelvel. 

int
nodeCount = q.size(); 

if
(nodeCount == 
0
) 

break
; 


// Dequeue all nodes of current 

// level and Enqueue all nodes 

// of next level 

while
(nodeCount > 
0
) 

{ 

Node node = q.peek(); 

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

System.out.println(); 

} 
} 

// Driver code 
public
static
void
main(String args[]) 
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

root.right.left = newNode(
4
); 

root.right.right = newNode(
5
); 


System.out.print(
"Level order traversal "
+ 

"of given tree\n"
); 

printLevelOrder(root); 


root = flipBinaryTree(root); 


System.out.print(
"\nLevel order traversal "
+ 

"of the flipped tree\n"
); 

printLevelOrder(root); 
} 
} 

// This code is contributed 
// by Arnab Kundu 