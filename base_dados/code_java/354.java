
// Java implementation to count number 
// of ways to tile a floor of size 
// n x m using 1 x m tiles 
import
java.io.*; 

class
GFG { 

// function to count the total number of ways 

static
int
countWays(
int
n, 
int
m) 

{ 

// table to store values 

// of subproblems 

int
count[] = 
new
int
[n + 
1
]; 

count[
0
] = 
0
; 


// Fill the table upto value n 

int
i; 

for
(i = 
1
; i <= n; i++) { 

// recurrence relation 

if
(i > m) 

count[i] = count[i - 
1
] + count[i - m]; 


// base cases 

else
if
(i < m) 

count[i] = 
1
; 


// i = = m 

else

count[i] = 
2
; 

} 


// required number of ways 

return
count[n]; 

} 


// Driver program 

public
static
void
main(String[] args) 

{ 

int
n = 
7
; 

int
m = 
4
; 

System.out.println(
"Number of ways = "

+ countWays(n, m)); 

} 
} 

// This code is contributed by vt_m. 