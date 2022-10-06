
// Java program to count number of strings 
// of n characters with 

class
GFG 
{ 

// n is total number of characters. 

// bCount and cCount are counts of 'b' 

// and 'c' respectively. 


static
int
countStrUtil(
int
[][][] dp, 
int
n, 

int
bCount, 
int
cCount) 

{ 


// Base cases 

if
(bCount < 
0
|| cCount < 
0
) 

{ 

return
0
; 

} 

if
(n == 
0
) 

{ 

return
1
; 

} 

if
(bCount == 
0
&& cCount == 
0
) 

{ 

return
1
; 

} 


// if we had saw this combination previously 

if
(dp[n][bCount][cCount] != -
1
) 

{ 

return
dp[n][bCount][cCount]; 

} 


// Three cases, we choose, a or b or c 

// In all three cases n decreases by 1. 

int
res = countStrUtil(dp, n - 
1
, bCount, cCount); 

res += countStrUtil(dp, n - 
1
, bCount - 
1
, cCount); 

res += countStrUtil(dp, n - 
1
, bCount, cCount - 
1
); 


return
(dp[n][bCount][cCount] = res); 

} 


// A wrapper over countStrUtil() 

static
int
countStr(
int
n, 
int
bCount, 
int
cCount) 

{ 

int
[][][] dp = 
new
int
[n + 
1
][
2
][
3
]; 

for
(
int
i = 
0
; i < n + 
1
; i++) 

{ 

for
(
int
j = 
0
; j < 
2
; j++) 

{ 

for
(
int
k = 
0
; k < 
3
; k++) 

{ 

dp[i][j][k] = -
1
; 

} 

} 

} 

return
countStrUtil(dp, n,bCount,cCount); 

} 


// Driver code 

public
static
void
main(String[] args) 

{ 

int
n = 
3
; 
// Total number of characters 

int
bCount = 
1
, cCount = 
2
; 

System.out.println(countStr(n,bCount,cCount)); 

} 
} 

// This code has been contributed by 29AjayKumar 