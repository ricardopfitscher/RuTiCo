
//Java Code to count minimum reversal for 
//making an expression balanced. 

import
java.util.Stack; 

public
class
GFG 
{ 


// Method count minimum reversal for 

//making an expression balanced. 

//Returns -1 if expression cannot be balanced 

static
int
countMinReversals(String expr) 

{ 

int
len = expr.length(); 


// length of expression must be even to make 

// it balanced by using reversals. 

if
(len%
2
!= 
0
) 

return
-
1
; 


// After this loop, stack contains unbalanced 

// part of expression, i.e., expression of the 

// form "}}..}{{..{" 

Stack<Character> s=
new
Stack<>(); 


for
(
int
i=
0
; i<len; i++) 

{ 

char
c = expr.charAt(i); 

if
(c ==
'}'
&& !s.empty()) 

{ 

if
(s.peek()==
'{'
) 

s.pop(); 

else

s.push(c); 

} 

else

s.push(c); 

} 


// Length of the reduced expression 

// red_len = (m+n) 

int
red_len = s.size(); 


// count opening brackets at the end of 

// stack 

int
n = 
0
; 

while
(!s.empty() && s.peek() == 
'{'
) 

{ 

s.pop(); 

n++; 

} 


// return ceil(m/2) + ceil(n/2) which is 

// actually equal to (m+n)/2 + n%2 when 

// m+n is even. 

return
(red_len/
2
+ n%
2
); 

} 


// Driver method 

public
static
void
main(String[] args) 

{ 

String expr = 
"}}{{"
; 


System.out.println(countMinReversals(expr)); 

} 

} 
//This code is contributed by Sumit Ghosh 