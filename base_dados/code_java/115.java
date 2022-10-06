
// Java Program to find max subarray 
// sum excluding some elements 
import
java.io.*; 

class
GFG { 


// Function to check the element 

// present in array B 

static
boolean
isPresent(
int
B[], 

int
m, 

int
x) 

{ 

for
(
int
i = 
0
; i < m; i++) 

if
(B[i] == x) 

return
true
; 


return
false
; 

} 


// Utility function for findMaxSubarraySum() 

// with the following parameters 

// A => Array A, 

// B => Array B, 

// n => Number of elements in Array A, 

// m => Number of elements in Array B 

static
int
findMaxSubarraySumUtil(
int
A[], 
int
B[], 

int
n, 
int
m) 

{ 


// set max_so_far to INT_MIN 

int
max_so_far = -
2147483648
, curr_max = 
0
; 


for
(
int
i = 
0
; i < n; i++) { 


// if the element is present in B, 

// set current max to 0 and move to 

// the next element 

if
(isPresent(B, m, A[i])) { 

curr_max = 
0
; 

continue
; 

} 


// Proceed as in Kadane's Algorithm 

curr_max = Math.max(A[i], curr_max + A[i]); 

max_so_far = Math.max(max_so_far, curr_max); 

} 

return
max_so_far; 

} 


// Wrapper for findMaxSubarraySumUtil() 

static
void
findMaxSubarraySum(
int
A[], 
int
B[], 

int
n, 
int
m) 

{ 

int
maxSubarraySum = findMaxSubarraySumUtil(A, B, 

n, m); 


// This case will occour when all 

// elements of A are are present 

// in B, thus no subarray can be formed 

if
(maxSubarraySum == -
2147483648
) { 

System.out.println(
"Maximum Subarray Sum"

+ 
" "
+ 
"can't be found"
); 


} 

else
{ 

System.out.println(
"The Maximum Subarray Sum = "

+ maxSubarraySum); 

} 

} 


// Driver code 

public
static
void
main(String[] args) 

{ 


int
A[] = { 
3
, 
4
, 
5
, -
4
, 
6
}; 

int
B[] = { 
1
, 
8
, 
5
}; 


int
n = A.length; 

int
m = B.length; 


// Calling Function 

findMaxSubarraySum(A, B, n, m); 

} 
} 

// This code is contributed by Ajit. 