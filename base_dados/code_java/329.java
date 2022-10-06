
// Java implementation to divide N into 
// maximum number of segments 
// of length a, b and c 
import
java.util.*; 

class
GFG 
{ 


// function to find the maximum 

// number of segments 

static
int
maximumSegments(
int
n, 
int
a, 

int
b, 
int
c) 

{ 

// stores the maximum number of 

// segments each index can have 

int
dp[] = 
new
int
[n + 
10
]; 


// initialize with -1 

Arrays.fill(dp, -
1
); 


// 0th index will have 0 segments 

// base case 

dp[
0
] = 
0
; 


// traverse for all possible 

// segments till n 

for
(
int
i = 
0
; i < n; i++) 

{ 

if
(dp[i] != -
1
) 

{ 


// conditions 

if
(i + a <= n ) 
//avoid buffer overflow 

dp[i + a] = Math.max(dp[i] + 
1
, 

dp[i + a]); 


if
(i + b <= n ) 
//avoid buffer overflow 

dp[i + b] = Math.max(dp[i] + 
1
, 

dp[i + b]); 


if
(i + c <= n ) 
//avoid buffer overflow 

dp[i + c] = Math.max(dp[i] + 
1
, 

dp[i + c]); 

} 

} 

return
dp[n]; 

} 


// Driver code 

public
static
void
main(String arg[]) 

{ 

int
n = 
7
, a = 
5
, b = 
2
, c = 
5
; 

System.out.print(maximumSegments(n, a, b, c)); 

} 
} 

// This code is contributed by Anant Agarwal. 