
// A O(n) time and O(1) extra 
// space solution to calculate 
// the Permutation Coefficient 
import
java.io.*; 

class
GFG 
{ 

static
int
PermutationCoeff(
int
n, 

int
k) 

{ 

int
Fn = 
1
, Fk = 
1
; 


// Compute n! and (n-k)! 

for
(
int
i = 
1
; i <= n; i++) 

{ 

Fn *= i; 

if
(i == n - k) 

Fk = Fn; 

} 

int
coeff = Fn / Fk; 

return
coeff; 

} 


// Driver Code 

public
static
void
main(String args[]) 

{ 

int
n = 
10
, k = 
2
; 

System.out.println(
"Value of P( "
+ n + 
","
+ 

k +
") is "
+ 

PermutationCoeff(n, k) ); 

} 
} 

// This code is contributed by Nikita Tiwari. 