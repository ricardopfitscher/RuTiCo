
// Java code to find number of subsequences of 
// "ab" in the string S which is repeated K times. 

import
java.io.*; 

class
GFG { 


static
int
countOccurrences(String s, 
int
K) 

{ 

int
n = s.length(); 

int
C = 
0
, c1 = 
0
, c2 = 
0
; 

for
(
int
i = 
0
; i < n; i++) { 

if
(s.charAt(i) == 
'a'
) 

c1++; 
// Count of 'a's 

if
(s.charAt(i) == 
'b'
) { 

c2++; 
// Count of 'b's 


// occurrence of "ab"s 

// in string S 

C += c1; 

} 

} 


// Add following two : 

// 1) K * (Occurrences of "ab" in single string) 

// 2) a is from one string and b is from other. 

return
C * K + (K * (K - 
1
) / 
2
) * c1 * c2; 

} 


// Driver code 

public
static
void
main(String[] args) 

{ 

String S = 
"abcb"
; 

int
k = 
2
; 


System.out.println(countOccurrences(S, k)); 

} 
} 

// This code is contributed by vt_m. 