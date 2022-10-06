
// Java Program to find the "GFG" subsequence 
// in the given string 

public
class
GFG { 


static
int
max = 
100
; 


// Print the count of "GFG" subsequence 

// in the string 

static
void
countSubsequence(String s, 
int
n) 

{ 

int
cntG = 
0
, cntF = 
0
, result = 
0
, C=
0
; 


// Traversing the given string 

for
(
int
i = 
0
; i < n; i++) { 

switch
(s.charAt(i)) { 


// If the character is 'G', 

// increment the count of 'G', 

// increase the result and 

// update the array. 

case
'G'
: 

cntG++; 

result+=C; 

break
; 


// If the character is 'F', 

// increment the count of 'F' 

// and update the array. 

case
'F'
: 

cntF++; 

C+=cntG; 

break
; 


// Ignore other character. 

default
: 

continue
; 

} 

} 


System.out.println(result); 

} 


// Driver code 

public
static
void
main(String args[]) { 

String s= 
"GFGFG"
; 

int
n = s.length(); 

countSubsequence(s, n); 

} 
} 

// This code is contributed by Sam007 