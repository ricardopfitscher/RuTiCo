
// Java implementation to count pairs from two 
// BSTs whose sum is equal to a given value x 
import
java.util.Stack; 
public
class
GFG { 


// structure of a node of BST 

static
class
Node { 

int
data; 

Node left, right; 


// constructor 

public
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


static
Node root1; 

static
Node root2; 

// function to count pairs from two BSTs 

// whose sum is equal to a given value x 

static
int
countPairs(Node root1, Node root2, 

int
x) 

{ 

// if either of the tree is empty 

if
(root1 == 
null
|| root2 == 
null
) 

return
0
; 


// stack 'st1' used for the inorder 

// traversal of BST 1 

// stack 'st2' used for the reverse 

// inorder traversal of BST 2 

//stack<Node*> st1, st2; 

Stack<Node> st1 = 
new
Stack<>(); 

Stack<Node> st2 = 
new
Stack<>(); 

Node top1, top2; 


int
count = 
0
; 


// the loop will break when either of two 

// traversals gets completed 

while
(
true
) { 


// to find next node in inorder 

// traversal of BST 1 

while
(root1 != 
null
) { 

st1.push(root1); 

root1 = root1.left; 

} 


// to find next node in reverse 

// inorder traversal of BST 2 

while
(root2 != 
null
) { 

st2.push(root2); 

root2 = root2.right; 

} 


// if either gets empty then corresponding 

// tree traversal is completed 

if
(st1.empty() || st2.empty()) 

break
; 


top1 = st1.peek(); 

top2 = st2.peek(); 


// if the sum of the node's is equal to 'x' 

if
((top1.data + top2.data) == x) { 

// increment count 

count++; 


// pop nodes from the respective stacks 

st1.pop(); 

st2.pop(); 


// insert next possible node in the 

// respective stacks 

root1 = top1.right; 

root2 = top2.left; 

} 


// move to next possible node in the 

// inoder traversal of BST 1 

else
if
((top1.data + top2.data) < x) { 

st1.pop(); 

root1 = top1.right; 

} 


// move to next possible node in the 

// reverse inoder traversal of BST 2 

else
{ 

st2.pop(); 

root2 = top2.left; 

} 

} 


// required count of pairs 

return
count; 

} 


// Driver program to test above 

public
static
void
main(String args[]) 

{ 

// formation of BST 1 

root1 = 
new
Node(
5
); 
/* 5 */

root1.left = 
new
Node(
3
); 
/* / \ */

root1.right = 
new
Node(
7
); 
/* 3 7 */

root1.left.left = 
new
Node(
2
); 
/* / \ / \ */

root1.left.right = 
new
Node(
4
); 
/* 2 4 6 8 */

root1.right.left = 
new
Node(
6
); 

root1.right.right = 
new
Node(
8
); 


// formation of BST 2 

root2 = 
new
Node(
10
); 
/* 10 */

root2.left = 
new
Node(
6
); 
/* / \ */

root2.right = 
new
Node(
15
); 
/* 6 15 */

root2.left.left = 
new
Node(
3
); 
/* / \ / \ */

root2.left.right = 
new
Node(
8
); 
/* 3 8 11 18 */

root2.right.left = 
new
Node(
11
); 

root2.right.right = 
new
Node(
18
); 


int
x = 
16
; 

System.out.println(
"Pairs = "

+ countPairs(root1, root2, x)); 

} 
} 
// This code is contributed by Sumit Ghosh 