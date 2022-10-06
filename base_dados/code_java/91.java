
import
java.util.Arrays; 

// Java program to test whether an array 
// can be sorted by swapping adjacent 
// elements using boolean array 

class
GFG { 


// Return true if array can be 

// sorted otherwise false 

static
boolean
sortedAfterSwap(
int
A[], 

boolean
B[], 
int
n) 

{ 

int
i, j; 


// Check bool array B and sorts 

// elements for continuos sequence of 1 

for
(i = 
0
; i < n - 
1
; i++) { 

if
(B[i]) { 

j = i; 

while
(B[j]) { 

j++; 

} 

// Sort array A from i to j 

Arrays.sort(A, i, 
1
+ j); 

i = j; 

} 

} 


// Check if array is sorted or not 

for
(i = 
0
; i < n; i++) { 

if
(A[i] != i + 
1
) { 

return
false
; 

} 

} 


return
true
; 

} 


// Driver program to test sortedAfterSwap() 

public
static
void
main(String[] args) 

{ 

int
A[] = { 
1
, 
2
, 
5
, 
3
, 
4
, 
6
}; 

boolean
B[] = { 
false
, 
true
, 
true
, 
true
, 
false
}; 

int
n = A.length; 


if
(sortedAfterSwap(A, B, n)) { 

System.out.println(
"A can be sorted"
); 

} 

else
{ 

System.out.println(
"A can not be sorted"
); 

} 

} 
} 