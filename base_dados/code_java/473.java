
// Java program to find 
// maximum sum by selecting 
// a element from n arrays 
import
java.io.*; 

class
GFG 
{ 

static
int
M = 
4
; 

static
int
arr[][] = {{
1
, 
7
, 
3
, 
4
}, 

{
4
, 
2
, 
5
, 
1
}, 

{
9
, 
5
, 
1
, 
8
}}; 


static
void
sort(
int
a[][], 

int
row, 
int
n) 

{ 

for
(
int
i = 
0
; i < M - 
1
; i++) 

{ 

if
(a[row][i] > a[row][i + 
1
]) 

{ 

int
temp = a[row][i]; 

a[row][i] = a[row][i + 
1
]; 

a[row][i + 
1
] = temp; 

} 

} 

} 


// To calculate maximum 

// sum by selecting element 

// from each array 

static
int
maximumSum(
int
a[][], 

int
n) 

{ 


// Sort each array 

for
(
int
i = 
0
; i < n; i++) 

sort(a, i, n); 


// Store maximum element 

// of last array 

int
sum = a[n - 
1
][M - 
1
]; 

int
prev = a[n - 
1
][M - 
1
]; 

int
i, j; 


// Selecting maximum element 

// from previoulsy selected 

// element 

for
(i = n - 
2
; i >= 
0
; i--) 

{ 

for
(j = M - 
1
; j >= 
0
; j--) 

{ 

if
(a[i][j] < prev) 

{ 

prev = a[i][j]; 

sum += prev; 

break
; 

} 

} 


// j = -1 means no element 

// is found in a[i] so 

// return 0 

if
(j == -
1
) 

return
0
; 

} 

return
sum; 

} 


// Driver Code 

public
static
void
main(String args[]) 

{ 

int
n = arr.length; 

System.out.print(maximumSum(arr, n)); 

} 
} 

// This code is contributed by 
// Manish Shaw(manishshaw1) 