
// Java program to find averages of all levels 
// in a binary tree. 
import
java.util.*; 
class
GfG { 

/* A binary tree node has data, pointer to 
left child and a pointer to right child */
static
class
Node { 

int
val; 

Node left, right; 
} 

/* Function to print the average value of the 
nodes on each level */
static
void
averageOfLevels(Node root) 
{ 

//vector<float> res; 


// Traversing level by level 

Queue<Node> q = 
new
LinkedList<Node> (); 

q.add(root); 

int
sum = 
0
, count = 
0
; 


while
(!q.isEmpty()) { 


// Compute sum of nodes and 

// count of nodes in current 

// level. 

sum = 
0
; 

count = 
0
; 

Queue<Node> temp = 
new
LinkedList<Node> (); 

while
(!q.isEmpty()) { 

Node n = q.peek(); 

q.remove(); 

sum += n.val; 

count++; 

if
(n.left != 
null
) 

temp.add(n.left); 

if
(n.right != 
null
) 

temp.add(n.right); 

} 

q = temp; 

System.out.print((sum * 
1.0
/ count) + 
" "
); 

} 
} 

/* Helper function that allocates a 
new node with the given data and 
NULL left and right pointers. */
static
Node newNode(
int
data) 
{ 

Node temp = 
new
Node(); 

temp.val = data; 

temp.left = 
null
; 

temp.right = 
null
; 

return
temp; 
} 

// Driver code 
public
static
void
main(String[] args) 
{ 

/* Let us construct a Binary Tree 

4 

/ \ 

2 9 

/ \ \ 

3 5 7 */


Node root = 
null
; 

root = newNode(
4
); 

root.left = newNode(
2
); 

root.right = newNode(
9
); 

root.left.left = newNode(
3
); 

root.left.right = newNode(
5
); 

root.right.right = newNode(
7
); 

System.out.println(
"Averages of levels : "
); 

System.out.print(
"["
); 

averageOfLevels(root); 

System.out.println(
"]"
); 
} 
} 