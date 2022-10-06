
// Java program to find maximum element in the path 
// between two Nodes of Binary Search Tree. 
class
Solution 
{ 

static
class
Node 
{ 

Node left, right; 

int
data; 
} 

// Create and return a pointer of new Node. 
static
Node createNode(
int
x) 
{ 

Node p = 
new
Node(); 

p . data = x; 

p . left = p . right = 
null
; 

return
p; 
} 

// Insert a new Node in Binary Search Tree. 
static
void
insertNode( Node root, 
int
x) 
{ 

Node p = root, q = 
null
; 


while
(p != 
null
) 

{ 

q = p; 

if
(p . data < x) 

p = p . right; 

else

p = p . left; 

} 


if
(q == 
null
) 

p = createNode(x); 

else

{ 

if
(q . data < x) 

q . right = createNode(x); 

else

q . left = createNode(x); 

} 
} 

// Return the maximum element between a Node 
// and its given ancestor. 
static
int
maxelpath(Node q, 
int
x) 
{ 

Node p = q; 


int
mx = -
1
; 


// Traversing the path between ansector and 

// Node and finding maximum element. 

while
(p . data != x) 

{ 

if
(p . data > x) 

{ 

mx = Math.max(mx, p . data); 

p = p . left; 

} 

else

{ 

mx = Math.max(mx, p . data); 

p = p . right; 

} 

} 


return
Math.max(mx, x); 
} 

// Return maximum element in the path between 
// two given Node of BST. 
static
int
maximumElement( Node root, 
int
x, 
int
y) 
{ 

Node p = root; 


// Finding the LCA of Node x and Node y 

while
((x < p . data && y < p . data) || 

(x > p . data && y > p . data)) 

{ 

// Checking if both the Node lie on the 

// left side of the parent p. 

if
(x < p . data && y < p . data) 

p = p . left; 


// Checking if both the Node lie on the 

// right side of the parent p. 

else
if
(x > p . data && y > p . data) 

p = p . right; 

} 


// Return the maximum of maximum elements occur 

// in path from ancestor to both Node. 

return
Math.max(maxelpath(p, x), maxelpath(p, y)); 
} 


// Driver Code 
public
static
void
main(String args[]) 
{ 

int
arr[] = { 
18
, 
36
, 
9
, 
6
, 
12
, 
10
, 
1
, 
8
}; 

int
a = 
1
, b = 
10
; 

int
n =arr.length; 


// Creating the root of Binary Search Tree 

Node root = createNode(arr[
0
]); 


// Inserting Nodes in Binary Search Tree 

for
(
int
i = 
1
; i < n; i++) 

insertNode(root, arr[i]); 


System.out.println( maximumElement(root, a, b) ); 

} 
} 
//contributed by Arnab Kundu 