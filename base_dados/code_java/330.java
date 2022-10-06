
// A simple recursive JAVA program to find 
// maximum sum by recursively breaking a 
// number in 3 parts. 
import
java.io.*; 

class
GFG { 


// Function to find the maximum sum 

static
int
breakSum(
int
n) 

{ 

// base conditions 

if
(n==
0
|| n == 
1
) 

return
n; 


// recursively break the number and return 

// what maximum you can get 

return
Math.max((breakSum(n/
2
) + breakSum(n/
3
) + 

breakSum(n/
4
)), n); 

} 


// Driver program to test the above function 

public
static
void
main (String[] args) { 

int
n = 
12
; 

System.out.println(breakSum(n)); 

} 
} 
// This code is contributed by Amit Kumar 