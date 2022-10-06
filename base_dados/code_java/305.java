
import
java.util.Arrays; 

// Java program to find the largest 
// subset which where each pair 
// is divisible. 
class
GFG { 


// function to find the longest Subsequence 

static
int
largestSubset(
int
[] a, 
int
n) 

{ 

// Sort array in increasing order 

Arrays.sort(a); 


// dp[i] is going to store size of largest 

// divisible subset beginning with a[i]. 

int
[] dp = 
new
int
[n]; 


// Since last element is largest, d[n-1] is 1 

dp[n - 
1
] = 
1
; 


// Fill values for smaller elements. 

for
(
int
i = n - 
2
; i >= 
0
; i--) { 


// Find all multiples of a[i] and consider 

// the multiple that has largest subset 

// beginning with it. 

int
mxm = 
0
; 

for
(
int
j = i + 
1
; j < n; j++) { 

if
(a[j] % a[i] == 
0
) { 

mxm = Math.max(mxm, dp[j]); 

} 

} 


dp[i] = 
1
+ mxm; 

} 


// Return maximum value from dp[] 

return
Arrays.stream(dp).max().getAsInt(); 

} 


// driver code to check the above function 

public
static
void
main(String[] args) 

{ 

int
[] a = { 
1
, 
3
, 
6
, 
13
, 
17
, 
18
}; 

int
n = a.length; 

System.out.println(largestSubset(a, n)); 

} 
} 

/* This JAVA code is contributed by Rajput-Ji*/