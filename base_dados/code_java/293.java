
// A Dynamic Programming based solution that uses table C[][] to 
// calculate the Binomial Coefficient 

class
BinomialCoefficient 
{ 

// Returns value of Binomial Coefficient C(n, k) 

static
int
binomialCoeff(
int
n, 
int
k) 

{ 

int
C[][] = 
new
int
[n+
1
][k+
1
]; 

int
i, j; 


// Calculate value of Binomial Coefficient in bottom up manner 

for
(i = 
0
; i <= n; i++) 

{ 

for
(j = 
0
; j <= min(i, k); j++) 

{ 

// Base Cases 

if
(j == 
0
|| j == i) 

C[i][j] = 
1
; 


// Calculate value using previously stored values 

else

C[i][j] = C[i-
1
][j-
1
] + C[i-
1
][j]; 

} 

} 


return
C[n][k]; 

} 


// A utility function to return minimum of two integers 

static
int
min(
int
a, 
int
b) 

{ 

return
(a<b)? a: b; 

} 


/* Driver program to test above function*/

public
static
void
main(String args[]) 

{ 

int
n = 
5
, k = 
2
; 

System.out.println(
"Value of C("
+n+
","
+k+
") is "
+binomialCoeff(n, k)); 

} 
} 
/*This code is contributed by Rajat Mishra*/