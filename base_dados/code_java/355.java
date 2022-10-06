
// Java program to count of ways to place 1 x 4 tiles 
// on n x 4 grid 
import
java.io.*; 

class
Grid 
{ 

// Function that count the number of ways to place 1 x 4 tiles 

// on n x 4 grid. 

static
int
count(
int
n) 

{ 

// Create a table to store results of sub-problems 

// dp[i] stores count of ways for i x 4 grid. 

int
[] dp = 
new
int
[n+
1
]; 

dp[
0
] = 
0
; 

// Fill the table from d[1] to dp[n] 

for
(
int
i=
1
;i<=n;i++) 

{ 

// Base cases 

if
(i >= 
1
&& i <= 
3
) 

dp[i] = 
1
; 

else
if
(i==
4
) 

dp[i] = 
2
; 


else

{ 

// dp(i-1) : Place first tile horizontally 

// dp(i-4) : Place first tile vertically 

// which means 3 more tiles have 

// to be placed vertically. 

dp[i] = dp[i-
1
] + dp[i-
4
]; 

} 

} 

return
dp[n]; 

} 


// Driver program 

public
static
void
main (String[] args) 

{ 

int
n = 
5
; 

System.out.println(
"Count of ways is: "
+ count(n)); 

} 
} 

// Contributed by Pramod Kumar 