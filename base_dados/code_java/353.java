
// Java program to count ways to build street 
// under given constraints 
public
class
GFG { 

// function to count ways of building 
// a street of n rows 

static
long
countWays(
int
n) { 

long
dp[][] = 
new
long
[
2
][n + 
1
]; 


// base case 

dp[
0
][
1
] = 
1
; 

dp[
1
][
1
] = 
2
; 


for
(
int
i = 
2
; i <= n; i++) { 


// ways of building houses in both 

// the spots of ith row 

dp[
0
][i] = dp[
0
][i - 
1
] + dp[
1
][i - 
1
]; 


// ways of building an office in one of 

// the two spots of ith row 

dp[
1
][i] = dp[
0
][i - 
1
] * 
2
+ dp[
1
][i - 
1
]; 

} 


// total ways for n rows 

return
dp[
0
][n] + dp[
1
][n]; 

} 

// driver program for checking above function 

public
static
void
main(String[] args) { 


int
n = 
5
; 

System.out.print(
"Total no of ways with n = "
+ n 

+ 
" are: "
+ countWays(n)); 

} 

} 

/*This code is contributed by PrinciRaj1992*/