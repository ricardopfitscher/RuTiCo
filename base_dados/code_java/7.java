
// A Naive Java program to find 
// maximum sum rotation 
import
java.util.*; 
import
java.io.*; 

class
GFG { 

// Returns maximum value of i*arr[i] 
static
int
maxSum(
int
arr[], 
int
n) 
{ 
// Initialize result 
int
res = Integer.MIN_VALUE; 

// Consider rotation beginning with i 
// for all possible values of i. 
for
(
int
i = 
0
; i < n; i++) 
{ 


// Initialize sum of current rotation 

int
curr_sum = 
0
; 


// Compute sum of all values. We don't 

// actually rotation the array, but compute 

// sum by finding ndexes when arr[i] is 

// first element 

for
(
int
j = 
0
; j < n; j++) 

{ 

int
index = (i + j) % n; 

curr_sum += j * arr[index]; 

} 


// Update result if required 

res = Math.max(res, curr_sum); 
} 

return
res; 
} 

// Driver code 
public
static
void
main(String args[]) 
{ 

int
arr[] = {
8
, 
3
, 
1
, 
2
}; 

int
n = arr.length; 

System.out.println(maxSum(arr, n)); 
} 


} 

// This code is contributed by Sahil_Bansall 