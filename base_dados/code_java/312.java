
// Java program to find remaining 
// chocolates after k iterations 
class
GFG 
{ 
// A O(n) C++ program to count 
// even length binary sequences 
// such that the sum of first 
// and second half bits is same 

// Returns the count of 
// even length sequences 
static
int
countSeq(
int
n) 
{ 

int
nCr = 
1
, res = 
1
; 


// Calculate SUM ((nCr)^2) 

for
(
int
r = 
1
; r <= n ; r++) 

{ 

// Compute nCr using nC(r-1) 

// nCr/nC(r-1) = (n+1-r)/r; 

nCr = (nCr * (n + 
1
- r)) / r; 


res += nCr * nCr; 

} 


return
res; 
} 

// Driver code 
public
static
void
main(String args[]) 
{ 

int
n = 
2
; 

System.out.print(
"Count of sequences is "
); 

System.out.println(countSeq(n)); 
} 
} 

// This code is contributed 
// by Shivi_Aggarwal 