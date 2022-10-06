
// Java program to do level order 
// traversal line by line 
import
java.util.LinkedList; 
import
java.util.Queue; 

public
class
GFG { 

static
class
Node { 

int
data; 

Node left; 

Node right; 


Node(
int
data) { 

this
.data = data; 

left = 
null
; 

right = 
null
; 

} 

} 


// Prints level order traversal line 

// by line using two queues. 

static
void
levelOrder(Node root) { 

if
(root == 
null
) 

return
; 


Queue<Node> q = 
new
LinkedList<>(); 


// Pushing root node into the queue. 

q.add(root); 


// Pushing delimiter into the queue. 

q.add(
null
); 


// Executing loop till queue becomes 

// empty 

while
(!q.isEmpty()) { 


Node curr = q.poll(); 


// condition to check the 

// occurence of next level 

if
(curr == 
null
) { 

if
(!q.isEmpty()) { 

q.add(
null
); 

System.out.println(); 

} 

} 
else
{ 

// Pushing left child current node 

if
(curr.left != 
null
) 

q.add(curr.left); 


// Pushing right child current node 

if
(curr.right != 
null
) 

q.add(curr.right); 


System.out.print(curr.data + 
" "
); 

} 

} 

} 


// Driver function 

public
static
void
main(String[] args) { 


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

root.left.left = 
new
Node(
4
); 

root.left.right = 
new
Node(
5
); 

root.right.right = 
new
Node(
6
); 


levelOrder(root); 

} 
} 

// This code is Contributed by Rishabh Jindal 