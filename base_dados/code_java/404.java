
// Java program to convert BTT to DLL using 
// simple inorder traversal 

public
class
BinaryTreeToDLL 
{ 

static
class
node 

{ 

int
data; 

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


static
node prev; 


// Changes left pointers to work as previous 

// pointers in converted DLL The function 

// simply does inorder traversal of Binary 

// Tree and updates left pointer using 

// previously visited node 

static
void
fixPrevptr(node root) 

{ 

if
(root == 
null
) 

return
; 


fixPrevptr(root.left); 

root.left = prev; 

prev = root; 

fixPrevptr(root.right); 


} 


// Changes right pointers to work 

// as next pointers in converted DLL 

static
node fixNextptr(node root) 

{ 

// Find the right most node in 

// BT or last node in DLL 

while
(root.right != 
null
) 

root = root.right; 


// Start from the rightmost node, traverse 

// back using left pointers. While traversing, 

// change right pointer of nodes 

while
(root != 
null
&& root.left != 
null
) 

{ 

node left = root.left; 

left.right = root; 

root = root.left; 

} 


// The leftmost node is head of linked list, return it 

return
root; 

} 


static
node BTTtoDLL(node root) 

{ 

prev = 
null
; 


// Set the previous pointer 

fixPrevptr(root); 


// Set the next pointer and return head of DLL 

return
fixNextptr(root); 

} 


// Traverses the DLL from left tor right 

static
void
printlist(node root) 

{ 

while
(root != 
null
) 

{ 

System.out.print(root.data + 
" "
); 

root = root.right; 

} 

} 


// Standard Inorder traversal of tree 

static
void
inorder(node root) 

{ 

if
(root == 
null
) 

return
; 

inorder(root.left); 

System.out.print(root.data + 
" "
); 

inorder(root.right); 

} 


public
static
void
main(String[] args) 

{ 

// Let us create the tree shown in above diagram 

node root = 
new
node(
10
); 

root.left = 
new
node(
12
); 

root.right = 
new
node(
15
); 

root.left.left = 
new
node(
25
); 

root.left.right = 
new
node(
30
); 

root.right.left = 
new
node(
36
); 


System.out.println(
"Inorder Tree Traversal"
); 

inorder(root); 


node head = BTTtoDLL(root); 


System.out.println(
"\nDLL Traversal"
); 

printlist(head); 

} 
} 

// This code is contributed by Rishabh Mahrsee 