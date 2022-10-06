
// Java implementation of brute 
// force solution. 
import
java.util.LinkedHashSet; 

class
GFG 
{ 
// Function to check if the given 
// number has repeated digit or not 
static
int
repeated_digit(
int
n) 
{ 

LinkedHashSet<Integer> s = 
new
LinkedHashSet<>(); 


// Traversing through each digit 

while
(n != 
0
) 

{ 

int
d = n % 
10
; 


// if the digit is present 

// more than once in the 

// number 

if
(s.contains(d)) 

{ 

// return 0 if the number 

// has repeated digit 

return
0
; 

} 

s.add(d); 

n = n / 
10
; 

} 


// return 1 if the number has 

// no repeated digit 

return
1
; 
} 

// Function to find total number 
// in the given range which has 
// no repeated digit 
static
int
calculate(
int
L, 
int
R) 
{ 

int
answer = 
0
; 


// Traversing through the range 

for
(
int
i = L; i < R + 
1
; ++i) 

{ 


// Add 1 to the answer if i has 

// no repeated digit else 0 

answer = answer + repeated_digit(i); 

} 


return
answer; 
} 

// Driver Code 
public
static
void
main(String[] args) 
{ 

int
L = 
1
, R = 
100
; 


// Calling the calculate 

System.out.println(calculate(L, R)); 
} 
} 

// This code is contributed by RAJPUT-JI 