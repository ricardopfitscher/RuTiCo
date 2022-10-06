
// C# program for iterative post 
// order using two stacks 
using
System; 
using
System.Collections; 
public
class
IterativePostorder { 


public
class
node { 

public
int
data; 

public
node left, right; 


public
node(
int
data) 

{ 

this
.data = data; 

} 

} 


// Two stacks as used in explanation 

static
public
Stack s1, s2; 


static
void
postOrderIterative(node root) 

{ 

// Create two stacks 

s1 = 
new
Stack(); 

s2 = 
new
Stack(); 


if
(root == 
null
) 

return
; 


// Push root to first stack 

s1.Push(root); 


// Run while first stack is not empty 

while
(s1.Count > 0) { 

// Pop an item from s1 and Push it to s2 

node temp = (node)s1.Pop(); 

s2.Push(temp); 


// Push left and right children of 

// removed item to s1 

if
(temp.left != 
null
) 

s1.Push(temp.left); 

if
(temp.right != 
null
) 

s1.Push(temp.right); 

} 


// Print all elements of second stack 

while
(s2.Count > 0) { 

node temp = (node)s2.Pop(); 

Console.Write(temp.data + 
" "
); 

} 

} 


public
static
void
Main(String[] args) 

{ 

// Let us construct the tree 

// shown in above figure 


node root = 
null
; 

root = 
new
node(1); 

root.left = 
new
node(2); 

root.right = 
new
node(3); 

root.left.left = 
new
node(4); 

root.left.right = 
new
node(5); 

root.right.left = 
new
node(6); 

root.right.right = 
new
node(7); 


postOrderIterative(root); 

} 
} 

// This code is contributed by Arnab Kundu 