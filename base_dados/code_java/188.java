
// Java program for a linear time 
// solution for stock span problem 
// without using stack 
class
GFG { 


// An efficient method to calculate 

// stock span values implementing the 

// same idea without using stack 

static
void
calculateSpan(
int
A[], 

int
n, 
int
ans[]) 

{ 

// Span value of first element is always 1 

ans[
0
] = 
1
; 


// Calculate span values for rest of the elements 

for
(
int
i = 
1
; i < n; i++) { 

int
counter = 
1
; 

while
((i - counter) >= 
0
&& A[i] > A[i - counter]) { 

counter += ans[i - counter]; 

} 

ans[i] = counter; 

} 

} 


// A utility function to print elements of array 

static
void
printArray(
int
arr[], 
int
n) 

{ 

for
(
int
i = 
0
; i < n; i++) 

System.out.print(arr[i] + 
" "
); 

} 


// Driver code 

public
static
void
main(String[] args) 

{ 

int
price[] = { 
10
, 
4
, 
5
, 
90
, 
120
, 
80
}; 

int
n = price.length; 

int
S[] = 
new
int
[n]; 


// Fill the span values in array S[] 

calculateSpan(price, n, S); 


// print the calculated span values 

printArray(S, n); 

} 
} 

/* This code contributed by PrinciRaj1992 */