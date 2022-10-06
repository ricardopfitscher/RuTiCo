
// Java program to see if there is a root to leaf path 
// with given sequence. 
public
class
CheckForPath { 


// function to check given sequence of root to leaf path exist 

// in tree or not. 

// index represents current element in sequence of rooth to 

// leaf path 

public
static
boolean
existPath(Node root, 
int
arr[], 
int
index) 

{ 

// If root is NULL, then there must not be any element 

// in array. 

if
(root==
null
) 

{ 

return
arr.length==
0
; 

} 


// If this node is a leaf and matches with last entry 

// of array. 

if
((root.left==
null
&& root.right==
null
) && (root.data==arr[index] 

&& root.data==arr[arr.length-
1
])) 

{ 

return
true
; 

} 


// If current node is equal to arr[index] this means 

// that till this level path has been matched and 

// remaining path can be either in left subtree or 

// right subtree. 

return
(index<arr.length && (root.data==arr[index] && 

(existPath(root.left,arr,index+
1
) || 

existPath(root.right, arr, index+
1
)))); 

} 


public
static
void
main(String args[]) { 

// arr[] is sequence of root to leaf path 

int
arr[] = {
5
, 
8
, 
6
, 
7
}; 

Node root=
new
Node(
5
); 

root.left=
new
Node(
3
); 

root.right=
new
Node(
8
); 

root.left.left = 
new
Node(
2
); 

root.left.right = 
new
Node(
4
); 

root.left.left.left = 
new
Node(
1
); 

root.right.left = 
new
Node(
6
); 

root.right.left.right = 
new
Node(
7
); 


if
(existPath(root, arr, 
0
)) 

{ 

System.out.print(
"Path Exists"
); 

} 

else

{ 

System.out.print(
"Path does not Exist"
); 

} 

} 
} 

/* A binary tree node has data, pointer to left child 
and a pointer to right child */
class
Node 
{ 

int
data; 

Node left, right; 

Node(
int
data) 

{ 

this
.data=data; 

left=right=
null
; 

} 
}; 

// This code is contributed by Gaurav Tiwari 