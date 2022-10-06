
// Java Program to find max subarray 
// sum excluding some elements 
import
java.util.*; 

class
GFG 
{ 


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
max_so_far = Integer.MIN_VALUE, curr_max = 
0
; 


for
(
int
i = 
0
; i < n; i++) 

{ 


// if the element is present in B, 

// set current max to 0 and move to 

// the next element 

if
(Arrays.binarySearch(B, A[i]) >= 
0
) 

{ 

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

// sort array B to apply Binary Search 

Arrays.sort(B); 


int
maxSubarraySum = findMaxSubarraySumUtil(A, B, 

n, m); 


// This case will occour when all elements 

// of A are present in B, thus no subarray 

// can be formed 

if
(maxSubarraySum == Integer.MIN_VALUE) 

{ 

System.out.println(
"Maximum subarray sum cant be found"
); 

} 

else

{ 

System.out.println(
"The Maximum subarray sum = "

+ maxSubarraySum); 

} 

} 


// Driver Code 

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


// Calling fucntion 

findMaxSubarraySum(A, B, n, m); 

} 
} 

// This code has been contributed by 29AjayKumar 