
// Java program to find pairs with given sum such 
// that one element of pair exists in one BST and 
// other in other BST. 
import
java.util.*; 
class
solution 
{ 

// A binary Tree node 
static
class
Node 
{ 

int
data; 

Node left, right; 
}; 

// A utility function to create a new BST node 
// with key as given num 
static
Node newNode(
int
num) 
{ 

Node temp = 
new
Node(); 

temp.data = num; 

temp.left = temp.right = 
null
; 

return
temp; 
} 

// A utility function to insert a given key to BST 
static
Node insert(Node root, 
int
key) 
{ 

if
(root == 
null
) 

return
newNode(key); 

if
(root.data > key) 

root.left = insert(root.left, key); 

else

root.right = insert(root.right, key); 

return
root; 
} 

// store storeInorder traversal in auxiliary array 
static
void
storeInorder(Node ptr, Vector<Integer> vect) 
{ 

if
(ptr==
null
) 

return
; 

storeInorder(ptr.left, vect); 

vect.add(ptr.data); 

storeInorder(ptr.right, vect); 
} 

// Function to find pair for given sum in different bst 
// vect1.get() -. stores storeInorder traversal of first bst 
// vect2.get() -. stores storeInorder traversal of second bst 
static
void
pairSumUtil(Vector<Integer> vect1, Vector<Integer> vect2, 

int
sum) 
{ 

// Initialize two indexes to two different corners 

// of two Vectors. 

int
left = 
0
; 

int
right = vect2.size() - 
1
; 


// find pair by moving two corners. 

while
(left < vect1.size() && right >= 
0
) 

{ 

// If we found a pair 

if
(vect1.get(left) + vect2.get(right) == sum) 

{ 

System.out.print( 
"("
+vect1.get(left) + 
", "
+ vect2.get(right) + 
"), "
); 

left++; 

right--; 

} 


// If sum is more, move to higher value in 

// first Vector. 

else
if
(vect1.get(left) + vect2.get(right) < sum) 

left++; 


// If sum is less, move to lower value in 

// second Vector. 

else

right--; 

} 
} 

// Prints all pairs with given "sum" such that one 
// element of pair is in tree with root1 and other 
// node is in tree with root2. 
static
void
pairSum(Node root1, Node root2, 
int
sum) 
{ 

// Store inorder traversals of two BSTs in two 

// Vectors. 

Vector<Integer> vect1= 
new
Vector<Integer>(), vect2= 
new
Vector<Integer>(); 

storeInorder(root1, vect1); 

storeInorder(root2, vect2); 


// Now the problem reduces to finding a pair 

// with given sum such that one element is in 

// vect1 and other is in vect2. 

pairSumUtil(vect1, vect2, sum); 
} 

// Driver program to run the case 
public
static
void
main(String args[]) 
{ 

// first BST 

Node root1 = 
null
; 

root1 = insert(root1, 
8
); 

root1 = insert(root1, 
10
); 

root1 = insert(root1, 
3
); 

root1 = insert(root1, 
6
); 

root1 = insert(root1, 
1
); 

root1 = insert(root1, 
5
); 

root1 = insert(root1, 
7
); 

root1 = insert(root1, 
14
); 

root1 = insert(root1, 
13
); 


// second BST 

Node root2 = 
null
; 

root2 = insert(root2, 
5
); 

root2 = insert(root2, 
18
); 

root2 = insert(root2, 
2
); 

root2 = insert(root2, 
1
); 

root2 = insert(root2, 
3
); 

root2 = insert(root2, 
4
); 


int
sum = 
10
; 

pairSum(root1, root2, sum); 
} 
} 
//contributed by Arnab Kundu 