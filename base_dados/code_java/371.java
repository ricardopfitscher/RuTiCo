
// Java program to query number of palindromic 
// substrings of a string in a range 
import
java.io.*; 

class
GFG { 

// Function to construct the dp array 

static
void
constructDp(
int
dp[][], String str) 

{ 

int
l = str.length(); 


// declare 2D array isPalin, isPalin[i][j] will 

// be 1 if str(i..j) is palindrome 

int
[][] isPalin = 
new
int
[l + 
1
][l + 
1
]; 


// initialize dp and isPalin array by zeros 

for
(
int
i = 
0
; i <= l; i++) { 

for
(
int
j = 
0
; j <= l; j++) { 

isPalin[i][j] = dp[i][j] = 
0
; 

} 

} 


// loop for starting index of range 

for
(
int
i = l - 
1
; i >= 
0
; i--) { 

// initialize value for one character strings as 1 

isPalin[i][i] = 
1
; 

dp[i][i] = 
1
; 


// loop for ending index of range 

for
(
int
j = i + 
1
; j < l; j++) { 

/* isPalin[i][j] will be 1 if ith and 

jth characters are equal and mid 

substring str(i+1..j-1) is also a 

palindrome */

isPalin[i][j] = (str.charAt(i) == str.charAt(j) && (i + 
1
> j - 
1
|| (isPalin[i + 
1
][j - 
1
]) != 
0
)) ? 
1
: 
0
; 


/* dp[i][j] will be addition of number 

of palindromes from i to j-1 and i+1 

to j subtracting palindromes from i+1 

to j-1 (as counted twice) plus 1 if 

str(i..j) is also a palindrome */

dp[i][j] = dp[i][j - 
1
] + dp[i + 
1
][j] - dp[i + 
1
][j - 
1
] + isPalin[i][j]; 

} 

} 

} 


// method returns count of palindromic substring in range (l, r) 

static
int
countOfPalindromeInRange(
int
dp[][], 
int
l, 
int
r) 

{ 

return
dp[l][r]; 

} 


// driver program 

public
static
void
main(String args[]) 

{ 

int
MAX = 
50
; 

String str = 
"xyaabax"
; 

int
[][] dp = 
new
int
[MAX][MAX]; 

constructDp(dp, str); 


int
l = 
3
; 

int
r = 
5
; 

System.out.println(countOfPalindromeInRange(dp, l, r)); 

} 
} 

// Contributed by Pramod Kumar 