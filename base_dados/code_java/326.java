
// Java program to find maximum pair sum whose 
// difference is less than K 

import
java.io.*; 
import
java.util.*; 

class
GFG { 


// method to return maximum sum we can get by 

// finding less than K difference pair 

static
int
maxSumPairWithDifferenceLessThanK(
int
arr[], 

int
N, 
int
K) 

{ 


// Sort input array in ascending order. 

Arrays.sort(arr); 


// dp[i] denotes the maximum disjoint pair sum 

// we can achieve using first i elements 

int
dp[] = 
new
int
[N]; 


// if no element then dp value will be 0 

dp[
0
] = 
0
; 


for
(
int
i = 
1
; i < N; i++) 

{ 

// first give previous value to dp[i] i.e. 

// no pairing with (i-1)th element 

dp[i] = dp[i-
1
]; 


// if current and previous element can form a pair 

if
(arr[i] - arr[i-
1
] < K) 

{ 


// update dp[i] by choosing maximum between 

// pairing and not pairing 

if
(i >= 
2
) 

dp[i] = Math.max(dp[i], dp[i-
2
] + arr[i] + 

arr[i-
1
]); 

else

dp[i] = Math.max(dp[i], arr[i] + arr[i-
1
]); 

} 

} 


// last index will have the result 

return
dp[N - 
1
]; 

} 


// Driver code to test above methods 

public
static
void
main (String[] args) { 


int
arr[] = {
3
, 
5
, 
10
, 
15
, 
17
, 
12
, 
9
}; 

int
N = arr.length; 

int
K = 
4
; 


System.out.println ( maxSumPairWithDifferenceLessThanK( 

arr, N, K)); 


} 
} 

//This code is contributed by vt_m. 