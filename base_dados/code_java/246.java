
// Java program to calculate number of substring 
// divisible by 6. 
import
java.util.*; 

class
GFG 
{ 


static
int
MAX = 
100002
; 


// Return the number of substring divisible by 6 

// and starting at index i in s[] and previous sum 

// of digits modulo 3 is m. 

static
int
f(
int
i, 
int
m, 
char
s[], 
int
memoize[][]) 

{ 

// End of the string. 

if
(i == s.length) 

{ 

return
0
; 

} 


// If already calculated, return the 

// stored value. 

if
(memoize[i][m] != -
1
) 

{ 

return
memoize[i][m]; 

} 


// Converting into integer. 

int
x = s[i] - 
'0'
; 


// Increment result by 1, if current digit 

// is divisible by 2 and sum of digits is 

// divisible by 3. 

// And recur for next index with new modulo. 

int
ans = ((x + m) % 
3
== 
0
&& x % 
2
== 
0
) ? 
1
+ f(i + 
1
, 

(m + x) % 
3
, s, memoize) : f(i + 
1
, (m + x) % 
3
, s, memoize); 

memoize[i][m] = ans; 

return
memoize[i][m]; 

} 


// Returns substrings divisible by 6. 

static
int
countDivBy6(
char
s[]) 

{ 

int
n = s.length; 


// For storing the value of all states. 

int
[][] memoize = 
new
int
[n + 
1
][
3
]; 

for
(
int
i = 
0
; i < n + 
1
; i++) 

{ 

for
(
int
j = 
0
; j < 
3
; j++) 

{ 

memoize[i][j] = -
1
; 

} 

} 


int
ans = 
0
; 

for
(
int
i = 
0
; i < s.length; i++) 

{ 

// If string contain 0, increment count by 1. 

if
(s[i] == 
'0'
) 

{ 

ans++; 

} 

// Else calculate using recursive function. 

// Pass previous sum modulo 3 as 0. 

else

{ 

ans += f(i, 
0
, s, memoize); 

} 

} 


return
ans; 

} 


// Driven Program 

public
static
void
main(String[] args) 

{ 

char
s[] = 
"4806"
.toCharArray(); 


System.out.println(countDivBy6(s)); 

} 
} 

// This code is contributed by Rajput-Ji 