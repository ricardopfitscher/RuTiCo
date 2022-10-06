
// Java program to find Maximum path sum 
// start any column in row '0' and ends 
// up to any column in row 'n-1' 
import
java.util.*; 

class
GFG { 


static
int
N = 
4
; 


// function find maximum sum path 

static
int
MaximumPath(
int
Mat[][]) 

{ 

int
result = 
0
; 


// creat 2D matrix to store the sum 

// of the path 

int
dp[][] = 
new
int
[N][N + 
2
]; 


// initialize all dp matrix as '0' 

for
(
int
[] rows : dp) 

Arrays.fill(rows, 
0
); 


// copy all element of first column into 

// 'dp' first column 

for
(
int
i = 
0
; i < N; i++) 

dp[
0
][i + 
1
] = Mat[
0
][i]; 


for
(
int
i = 
1
; i < N; i++) 

for
(
int
j = 
1
; j <= N; j++) 

dp[i][j] = Math.max(dp[i - 
1
][j - 
1
], 

Math.max(dp[i - 
1
][j], 

dp[i - 
1
][j + 
1
])) + 

Mat[i][j - 
1
]; 


// Find maximum path sum that end ups 

// at any column of last row 'N-1' 

for
(
int
i = 
0
; i <= N; i++) 

result = Math.max(result, dp[N - 
1
][i]); 


// return maximum sum path 

return
result; 

} 


// driver code 

public
static
void
main(String arg[]) 

{ 

int
Mat[][] = { { 
4
, 
2
, 
3
, 
4
}, 

{ 
2
, 
9
, 
1
, 
10
}, 

{ 
15
, 
1
, 
3
, 
0
}, 

{ 
16
, 
92
, 
41
, 
44
} }; 


System.out.println(MaximumPath(Mat)); 

} 
} 

// This code is contributed by Anant Agarwal. 