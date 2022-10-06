
// Java program to find 
// lexicographically 
// maximum value after 
// k swaps. 
import
java.io.*; 

class
GFG 
{ 

static
void
SwapInts(
int
array[], 

int
position1, 

int
position2) 

{ 

// Swaps elements 

// in an array. 


// Copy the first 

// position's element 

int
temp = array[position1]; 


// Assign to the 

// second element 

array[position1] = array[position2]; 


// Assign to the 

// first element 

array[position2] = temp; 

} 


// Function which 

// modifies the array 

static
void
KSwapMaximum(
int
[]arr, 

int
n, 
int
k) 

{ 

for
(
int
i = 
0
; 

i < n - 
1
&& k > 
0
; ++i) 

{ 


// Here, indexPositionition 

// is set where we want to 

// put the current largest 

// integer 

int
indexPosition = i; 

for
(
int
j = i + 
1
; j < n; ++j) 

{ 


// If we exceed the 

// Max swaps then 

// break the loop 

if
(k <= j - i) 

break
; 


// Find the maximum value 

// from i+1 to max k or n 

// which will replace 

// arr[indexPosition] 

if
(arr[j] > arr[indexPosition]) 

indexPosition = j; 

} 


// Swap the elements from 

// Maximum indexPosition 

// we found till now to 

// the ith index 

for
(
int
j = indexPosition; j > i; --j) 

SwapInts(arr, j, j - 
1
); 


// Updates k after swapping 

// indexPosition-i elements 

k -= indexPosition - i; 

} 

} 


// Driver code 

public
static
void
main(String args[]) 

{ 

int
[]arr = { 
3
, 
5
, 
4
, 
1
, 
2
}; 

int
n = arr.length; 

int
k = 
3
; 


KSwapMaximum(arr, n, k); 


// Print the final Array 

for
(
int
i = 
0
; i < n; ++i) 

System.out.print(arr[i] + 
" "
); 

} 
} 

// This code is contributed by 
// Manish Shaw(manishshaw1) 