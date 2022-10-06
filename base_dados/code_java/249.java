
// A simple Java program to find max subarray XOR 
class
GFG { 

static
int
maxSubarrayXOR(
int
arr[], 
int
n) 

{ 

int
ans = Integer.MIN_VALUE; 
// Initialize result 


// Pick starting points of subarrays 

for
(
int
i=
0
; i<n; i++) 

{ 

// to store xor of current subarray 

int
curr_xor = 
0
; 


// Pick ending points of subarrays starting with i 

for
(
int
j=i; j<n; j++) 

{ 

curr_xor = curr_xor ^ arr[j]; 

ans = Math.max(ans, curr_xor); 

} 

} 

return
ans; 

} 


// Driver program to test above functions 

public
static
void
main(String args[]) 

{ 

int
arr[] = {
8
, 
1
, 
2
, 
12
}; 

int
n = arr.length; 

System.out.println(
"Max subarray XOR is "
+ 

maxSubarrayXOR(arr, n)); 

} 
} 
//This code is contributed by Sumit Ghosh 