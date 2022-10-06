
// Space efficient Java program to count all 
// substrings with same first and last characters. 
public
class
GFG { 


static
int
countSubstringWithEqualEnds(String s) 

{ 

int
result = 
0
; 

int
n = s.length(); 


// Iterating through all substrings in 

// way so that we can find first and last 

// character easily 

for
(
int
i = 
0
; i < n; i++) 

for
(
int
j = i; j < n; j++) 

if
(s.charAt(i) == s.charAt(j)) 

result++; 


return
result; 

} 


// Driver function 

public
static
void
main(String args[]) 

{ 

String s = 
"abcab"
; 

System.out.println(countSubstringWithEqualEnds(s)); 

} 
} 
// This code is contributed by Sumit Ghosh 