
// Java implementation to find 
// the sum of all the parent 
// nodes having child node x 
class
GFG 
{ 
// sum 
static
int
sum = 
0
; 


// Node of a binary tree 
static
class
Node 
{ 

int
data; 

Node left, right; 
}; 

// function to get a new node 
static
Node getNode(
int
data) 
{ 

// allocate memory for the node 

Node newNode = 
new
Node(); 


// put in the data 

newNode.data = data; 

newNode.left = newNode.right = 
null
; 

return
newNode; 
} 

// function to find the sum of all the 
// parent nodes having child node x 
static
void
sumOfParentOfX(Node root, 
int
x) 
{ 

// if root == NULL 

if
(root == 
null
) 

return
; 


// if left or right child 

// of root is 'x', then 

// add the root's data to 'sum' 

if
((root.left != 
null
&& root.left.data == x) || 

(root.right != 
null
&& root.right.data == x)) 

sum += root.data; 


// recursively find the required 

// parent nodes in the left and 

// right subtree 

sumOfParentOfX(root.left, x); 

sumOfParentOfX(root.right, x); 

} 

// utility function to find the 
// sum of all the parent nodes 
// having child node x 
static
int
sumOfParentOfXUtil(Node root, 

int
x) 
{ 

sum = 
0
; 

sumOfParentOfX(root, x); 


// required sum of parent nodes 

return
sum; 
} 

// Driver Code 
public
static
void
main(String args[]) 
{ 

// binary tree formation 

Node root = getNode(
4
); 
// 4 

root.left = getNode(
2
); 
// / \ 

root.right = getNode(
5
); 
// 2 5 

root.left.left = getNode(
7
); 
// / \ / \ 

root.left.right = getNode(
2
); 
// 7 2 2 3 

root.right.left = getNode(
2
); 

root.right.right = getNode(
3
); 


int
x = 
2
; 


System.out.println( 
"Sum = "
+ 

sumOfParentOfXUtil(root, x)); 
} 
} 

// This code is contributed by Arnab Kundu 