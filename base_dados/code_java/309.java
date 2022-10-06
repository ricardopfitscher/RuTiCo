
// JAVA Code for Newman-Conway Sequence 
import
java.util.*; 

class
GFG { 


// Function to find the n-th element 

static
int
sequence(
int
n) 

{ 

// Declare array to store sequence 

int
f[] = 
new
int
[n + 
1
]; 

f[
0
] = 
0
; 

f[
1
] = 
1
; 

f[
2
] = 
1
; 


int
i; 


for
(i = 
3
; i <= n; i++) 

f[i] = f[f[i - 
1
]] + 

f[i - f[i - 
1
]]; 


return
f[n]; 

} 


/* Driver program to test above function */

public
static
void
main(String[] args) 

{ 

int
n = 
10
; 

System.out.println(sequence(n)); 


} 
} 

// This code is contributed by Arnav Kr. Mandal. 