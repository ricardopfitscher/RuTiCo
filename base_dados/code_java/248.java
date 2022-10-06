
// Java implementation to find product of 
// digits of elements at k-th level 

class
GFG 
{ 

// Function to find product of digits 

// of elements at k-th level 

static
int
productAtKthLevel(String tree, 
int
k) 

{ 

int
level = -
1
; 


// Initialize result 

int
product = 
1
; 


int
n = tree.length(); 


for
(
int
i = 
0
; i < n; i++) 

{ 

// increasing level number 

if
(tree.charAt(i) == 
'('
) 

level++; 


// decreasing level number 

else
if
(tree.charAt(i) == 
')'
) 

level--; 


else

{ 

// check if current level is 

// the desired level or not 

if
(level == k) 

product *= (tree.charAt(i) - 
'0'
); 

} 

} 


// required product 

return
product; 

} 


// Driver program 

public
static
void
main(String[] args) 

{ 

String tree = 
"(0(5(6()())(4()(9()())))(7(1()())(3()())))"
; 

int
k = 
2
; 

System.out.println(productAtKthLevel(tree, k)); 

} 
} 

// This code is contributed 
// by Smitha Dinesh Semwal. 