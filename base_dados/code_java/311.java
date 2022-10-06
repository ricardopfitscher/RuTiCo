
// A memoization based Java program to 
// count even length binary sequences 
// such that the sum of first and 
// second half bits is same 
import
java.io.*; 

class
GFG { 

// A lookup table to store the results of 
// subproblems 
static
int
lookup[][] = 
new
int
[
1000
][
1000
]; 

// dif is diference between sums of first 
// n bits and last n bits i.e., 
// dif = (Sum of first n bits) - (Sum of last n bits) 
static
int
countSeqUtil(
int
n, 
int
dif) 
{ 

// We can't cover diference of 

// more than n with 2n bits 

if
(Math.abs(dif) > n) 

return
0
; 


// n == 1, i.e., 2 bit long sequences 

if
(n == 
1
&& dif == 
0
) 

return
2
; 

if
(n == 
1
&& Math.abs(dif) == 
1
) 

return
1
; 


// Check if this subbproblem is already 

// solved n is added to dif to make 

// sure index becomes positive 

if
(lookup[n][n+dif] != -
1
) 

return
lookup[n][n+dif]; 


int
res = 
// First bit is 0 & last bit is 1 

countSeqUtil(n-
1
, dif+
1
) + 


// First and last bits are same 

2
*countSeqUtil(n-
1
, dif) + 


// First bit is 1 & last bit is 0 

countSeqUtil(n-
1
, dif-
1
); 


// Store result in lookup table 

// and return the result 

return
lookup[n][n+dif] = res; 
} 

// A Wrapper over countSeqUtil(). It mainly 
// initializes lookup table, then calls 
// countSeqUtil() 
static
int
countSeq(
int
n) 
{ 

// Initialize all entries of lookup 

// table as not filled 

// memset(lookup, -1, sizeof(lookup)); 

for
(
int
k = 
0
; k < lookup.length; k++) 

{ 

for
(
int
j = 
0
; j < lookup.length; j++) 

{ 

lookup[k][j] = -
1
; 

} 

} 


// call countSeqUtil() 

return
countSeqUtil(n, 
0
); 
} 

// Driver program 
public
static
void
main(String[] args) 
{ 

int
n = 
2
; 

System.out.println(
"Count of sequences is "

+ countSeq(
2
)); 
} 
} 

// This code is contributed by Prerna Saini 