
/* Java Program to check whether valid 
expression is redundant or not*/
import
java.util.Stack; 
public
class
GFG { 
// Function to check redundant brackets in a 
// balanced expression 


static
boolean
checkRedundancy(String s) { 

// create a stack of characters 

Stack<Character> st = 
new
Stack<>(); 

char
[] str = s.toCharArray(); 

// Iterate through the given expression 

for
(
char
ch : str) { 


// if current character is close parenthesis ')' 

if
(ch == 
')'
) { 

char
top = st.peek(); 

st.pop(); 


// If immediate pop have open parenthesis '(' 

// duplicate brackets found 

boolean
flag = 
true
; 


while
(top != 
'('
) { 


// Check for operators in expression 

if
(top == 
'+'
|| top == 
'-'

|| top == 
'*'
|| top == 
'/'
) { 

flag = 
false
; 

} 


// Fetch top element of stack 

top = st.peek(); 

st.pop(); 

} 


// If operators not found 

if
(flag == 
true
) { 

return
true
; 

} 

} 
else
{ 

st.push(ch); 
// push open parenthesis '(', 

} 
// operators and operands to stack 

} 

return
false
; 

} 

// Function to check redundant brackets 

static
void
findRedundant(String str) { 

boolean
ans = checkRedundancy(str); 

if
(ans == 
true
) { 

System.out.println(
"Yes"
); 

} 
else
{ 

System.out.println(
"No"
); 

} 

} 

// Driver code 

public
static
void
main(String[] args) { 

String str = 
"((a+b))"
; 

findRedundant(str); 


str = 
"(a+(b)/c)"
; 

findRedundant(str); 


str = 
"(a+b*(c-d))"
; 

findRedundant(str); 

} 
} 