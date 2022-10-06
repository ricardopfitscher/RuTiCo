
// Java program to print 
// equal sum sets of array. 
import
java.io.*; 
import
java.util.*; 

class
GFG 
{ 

// Function to print equal 

// sum sets of array. 

static
void
printEqualSumSets(
int
[]arr, 

int
n) 

{ 

int
i, currSum, sum = 
0
; 


// Finding sum of array elements 

for
(i = 
0
; i < arr.length; i++) 

sum += arr[i]; 


// Check sum is even or odd. 

// If odd then array cannot 

// be partitioned. Print -1 

// and return. 

if
((sum & 
1
) == 
1
) 

{ 

System.out.print(
"-1"
); 

return
; 

} 


// Divide sum by 2 to find 

// sum of two possible subsets. 

int
k = sum >> 
1
; 


// Boolean DP table to store 

// result of states. 

// dp[i,j] = true if there is a 

// subset of elements in first i 

// elements of array that has sum 

// equal to j. 

boolean
[][]dp = 
new
boolean
[n + 
1
][k + 
1
]; 


// If number of elements are zero, 

// then no sum can be obtained. 

for
(i = 
1
; i <= k; i++) 

dp[
0
][i] = 
false
; 


// Sum 0 can be obtained by 

// not selecting any element. 

for
(i = 
0
; i <= n; i++) 

dp[i][
0
] = 
true
; 


// Fill the DP table 

// in bottom up manner. 

for
(i = 
1
; i <= n; i++) 

{ 

for
(currSum = 
1
; 

currSum <= k; 

currSum++) 

{ 


// Excluding current element. 

dp[i][currSum] = dp[i - 
1
][currSum]; 


// Including current element 

if
(arr[i - 
1
] <= currSum) 

dp[i][currSum] = dp[i][currSum] | 

dp[i - 
1
][currSum - arr[i - 
1
]]; 

} 

} 


// Required sets set1 and set2. 

List<Integer> set1 = 
new
ArrayList<Integer>(); 

List<Integer> set2 = 
new
ArrayList<Integer>(); 


// If partition is not possible 

// print -1 and return. 

if
(!dp[n][k]) 

{ 

System.out.print(
"-1\n"
); 

return
; 

} 


// Start from last 

// element in dp table. 

i = n; 

currSum = k; 


while
(i > 
0
&& currSum >= 
0
) 

{ 


// If current element does 

// not contribute to k, then 

// it belongs to set 2. 

if
(dp[i - 
1
][currSum]) 

{ 

i--; 

set2.add(arr[i]); 

} 


// If current element contribute 

// to k then it belongs to set 1. 

else
if
(dp[i - 
1
][currSum - arr[i - 
1
]]) 

{ 

i--; 

currSum -= arr[i]; 

set1.add(arr[i]); 

} 

} 


// Print elements of both the sets. 

System.out.print(
"Set 1 elements: "
); 

for
(i = 
0
; i < set1.size(); i++) 

System.out.print(set1.get(i) + 
" "
); 


System.out.print(
"\nSet 2 elements: "
); 


for
(i = 
0
; i < set2.size(); i++) 

System.out.print(set2.get(i) + 
" "
); 

} 


// Driver Code 

public
static
void
main(String args[]) 

{ 

int
[]arr = 
new
int
[]{ 
5
, 
5
, 
1
, 
11
}; 

int
n = arr.length; 

printEqualSumSets(arr, n); 

} 
} 

// This code is contributed by 
// Manish Shaw(manishshaw1) 