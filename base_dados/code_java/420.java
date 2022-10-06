
// Java program to check if all leaf nodes are at 
// same level of binary tree 
import
java.util.*; 

// User defined node class 
class
Node { 

int
data; 

Node left, right; 


// Constructor to create a new tree node 

Node(
int
key) { 

int
data = key; 

left = right = 
null
; 

} 
} 

class
GFG { 


// return true if all leaf nodes are 

// at same level, else false 

static
boolean
checkLevelLeafNode(Node root) 

{ 

if
(root == 
null
) 

return
true
; 


// create a queue for level order traversal 

Queue<Node> q = 
new
LinkedList<>(); 

q.add(root); 


int
result = Integer.MAX_VALUE; 

int
level = 
0
; 


// traverse until the queue is empty 

while
(q.size() != 
0
) { 

int
size = q.size(); 

level++; 


// traverse for complete level 

while
(size > 
0
) { 

Node temp = q.remove(); 


// check for left child 

if
(temp.left != 
null
) { 

q.add(temp.left); 


// if its leaf node 

if
(temp.left.left == 
null
&& temp.left.right == 
null
) { 


// if it's first leaf node, then update result 

if
(result == Integer.MAX_VALUE) 

result = level; 


// if it's not first leaf node, then compare 

// the level with level of previous leaf node. 

else
if
(result != level) 

return
false
; 

} 

} 


// check for right child 

if
(temp.right != 
null
) { 

q.add(temp.right); 


// if its leaf node 

if
(temp.right.left == 
null
&& temp.right.right == 
null
) { 


// if it's first leaf node, then update result 

if
(result == Integer.MAX_VALUE) 

result = level; 


// if it's not first leaf node, then compare 

// the level with level of previous leaf node. 

else
if
(result != level) 

return
false
; 

} 

} 

size--; 

} 


} 

return
true
; 

} 


// Driver code 

public
static
void
main(String args[]) 

{ 

// construct a tree 

Node root = 
new
Node(
1
); 

root.left = 
new
Node(
2
); 

root.right = 
new
Node(
3
); 

root.left.right = 
new
Node(
4
); 

root.right.left = 
new
Node(
5
); 

root.right.right = 
new
Node(
6
); 


boolean
result = checkLevelLeafNode(root); 

if
(result == 
true
) 

System.out.println(
"All leaf nodes are at same level"
); 

else

System.out.println(
"Leaf nodes not at same level"
); 

} 
} 
// This code is contributed by rachana soma 