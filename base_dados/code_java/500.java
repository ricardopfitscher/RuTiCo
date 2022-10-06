
// Java program to find minimum cost 
// to reduce array size to 1, 
import
java.lang.*; 

public
class
GFG { 


// function to calculate the 

// minimum cost 

static
int
cost(
int
[]a, 
int
n) 

{ 

int
min = a[
0
]; 


// find the minimum using 

// for loop 

for
(
int
i = 
1
; i< a.length; i++) 

{ 

if
(a[i] < min) 

min = a[i]; 

} 


// Minimum cost is n-1 multiplied 

// with minimum element. 

return
(n - 
1
) * min; 

} 


// driver program to test the 

// above function. 

static
public
void
main (String[] args) 

{ 


int
[]a = { 
4
, 
3
, 
2
}; 

int
n = a.length; 


System.out.println(cost(a, n)); 

} 
} 

// This code is contributed by parashar. 