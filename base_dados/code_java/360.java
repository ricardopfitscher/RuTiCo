
// Java program for calculating LISS 
// using dynamic programming 

public
class
LisTree 
{ 

/* A binary tree node has data, pointer 

to left child and a pointer to right 

child */

static
class
node 

{ 

int
data, liss; 

node left, right; 


public
node(
int
data) 

{ 

this
.data = data; 

this
.liss = 
0
; 

} 

} 


// A memoization function returns size 

// of the largest independent set in 

// a given binary tree 

static
int
liss(node root) 

{ 

if
(root == 
null
) 

return
0
; 

if
(root.liss != 
0
) 

return
root.liss; 

if
(root.left == 
null
&& root.right == 
null
) 

return
root.liss = 
1
; 


// Calculate size excluding the 

// current node 

int
liss_excl = liss(root.left) + liss(root.right); 


// Calculate size including the 

// current node 

int
liss_incl = 
1
; 

if
(root.left != 
null
) 

{ 

liss_incl += (liss(root.left.left) + liss(root.left.right)); 

} 

if
(root.right != 
null
) 

{ 

liss_incl += (liss(root.right.left) + liss(root.right.right)); 

} 


// Maximum of two sizes is LISS, 

// store it for future uses. 

return
root.liss = Math.max(liss_excl, liss_incl); 

} 


public
static
void
main(String[] args) 

{ 

// Let us construct the tree given 

// in the above diagram 


node root = 
new
node(
20
); 

root.left = 
new
node(
8
); 

root.left.left = 
new
node(
4
); 

root.left.right = 
new
node(
12
); 

root.left.right.left = 
new
node(
10
); 

root.left.right.right = 
new
node(
14
); 

root.right = 
new
node(
22
); 

root.right.right = 
new
node(
25
); 

System.out.println(
"Size of the Largest Independent Set is "
+ liss(root)); 

} 
} 

// This code is contributed by Rishabh Mahrsee 