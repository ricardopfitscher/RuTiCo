
// Java program to find if given array 
// exists as a subsequece in BST 
import
java.util.*; 

class
GFG 
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

//structure of int class 
static
class
INT 
{ 

int
a; 
} 

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
Node insert( Node root, 
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

// function to check if given sorted 
// sub-sequence exist in BST index -. 
// iterator for given sorted sub-sequence 
// seq[] -. given sorted sub-sequence 
static
void
seqExistUtil( Node ptr, 
int
seq[], INT index) 
{ 

if
(ptr == 
null
) 

return
; 


// We traverse left subtree 

// first in Inorder 

seqExistUtil(ptr.left, seq, index); 


// If current node matches 

// with se[index] then move 

// forward in sub-sequence 

if
(ptr.data == seq[index.a]) 

index.a++; 


// We traverse left subtree 

// in the end in Inorder 

seqExistUtil(ptr.right, seq, index); 
} 

// A wrapper over seqExistUtil. 
// It returns true if seq[0..n-1] 
// exists in tree. 
static
boolean
seqExist( Node root, 
int
seq[], 
int
n) 
{ 

// Initialize index in seq[] 

INT index = 
new
INT(); 


index.a = 
0
; 


// Do an inorder traversal and find if all 

// elements of seq[] were present 

seqExistUtil(root, seq, index); 


// index would become n if all 

// elements of seq[] were present 

return
(index.a == n); 
} 

// Driver code 
public
static
void
main(String args[]) 
{ 

Node root = 
null
; 

root = insert(root, 
8
); 

root = insert(root, 
10
); 

root = insert(root, 
3
); 

root = insert(root, 
6
); 

root = insert(root, 
1
); 

root = insert(root, 
4
); 

root = insert(root, 
7
); 

root = insert(root, 
14
); 

root = insert(root, 
13
); 


int
seq[] = {
4
, 
6
, 
8
, 
14
}; 

int
n = seq.length; 


if
(seqExist(root, seq, n)) 

System.out.println(
"Yes"
); 

else

System.out.println(
"No"
); 
} 
} 

// This code is contributed by Arnab Kundu 