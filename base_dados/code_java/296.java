
// A O(n) solution that uses 
// table fact[] to calculate 
// the Permutation Coefficient 
import
java .io.*; 

public
class
GFG { 


// Returns value of Permutation 

// Coefficient P(n, k) 

static
int
permutationCoeff(
int
n, 

int
k) 

{ 

int
[]fact = 
new
int
[n+
1
]; 


// base case 

fact[
0
] = 
1
; 


// Caculate value 

// factorials up to n 

for
(
int
i = 
1
; i <= n; i++) 

fact[i] = i * fact[i - 
1
]; 


// P(n,k) = n! / (n - k)! 

return
fact[n] / fact[n - k]; 

} 


// Driver Code 

static
public
void
main (String[] args) 

{ 

int
n = 
10
, k = 
2
; 

System.out.println(
"Value of"

+ 
" P( "
+ n + 
", "
+ k + 
") is "

+ permutationCoeff(n, k) ); 

} 
} 

// This code is contributed by anuj_67. 