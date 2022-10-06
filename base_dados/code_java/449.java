
// Java program to check if a given array is sorted 
// or not. 

class
GFG { 

// Function that returns true if array is Inorder 
// traversal of any Binary Search Tree or not. 

static
boolean
isInorder(
int
[] arr, 
int
n) { 

// Array has one or no element 

if
(n == 
0
|| n == 
1
) { 

return
true
; 

} 


for
(
int
i = 
1
; i < n; i++) 
// Unsorted pair found 

{ 

if
(arr[i - 
1
] > arr[i]) { 

return
false
; 

} 

} 


// No unsorted pair found 

return
true
; 

} 
// Drivers code 


public
static
void
main(String[] args) { 

int
arr[] = {
19
, 
23
, 
25
, 
30
, 
45
}; 

int
n = arr.length; 

if
(isInorder(arr, n)) { 

System.out.println(
"Yes"
); 

} 
else
{ 

System.out.println(
"Non"
); 

} 

} 
} 
//This code is contributed by 29AjayKumar 