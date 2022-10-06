
// Java program to check if successive 
// pair of numbers in the stack are 
// consecutive or not 
import
java.util.*; 
class
GfG { 

// Function to check if elements are 
// pairwise consecutive in stack 
static
boolean
pairWiseConsecutive(Stack<Integer> s) 
{ 

// Transfer elements of s to aux. 

Stack<Integer> aux = 
new
Stack<Integer> (); 

while
(!s.isEmpty()) { 

aux.push(s.peek()); 

s.pop(); 

} 


// Traverse aux and see if 

// elements are pairwise 

// consecutive or not. We also 

// need to make sure that original 

// content is retained. 

boolean
result = 
true
; 

while
(aux.size() > 
1
) { 


// Fetch current top two 

// elements of aux and check 

// if they are consecutive. 

int
x = aux.peek(); 

aux.pop(); 

int
y = aux.peek(); 

aux.pop(); 

if
(Math.abs(x - y) != 
1
) 

result = 
false
; 


// Push the elements to original 

// stack. 

s.push(x); 

s.push(y); 

} 


if
(aux.size() == 
1
) 

s.push(aux.peek()); 


return
result; 
} 

// Driver program 
public
static
void
main(String[] args) 
{ 

Stack<Integer> s = 
new
Stack<Integer> (); 

s.push(
4
); 

s.push(
5
); 

s.push(-
2
); 

s.push(-
3
); 

s.push(
11
); 

s.push(
10
); 

s.push(
5
); 

s.push(
6
); 

s.push(
20
); 


if
(pairWiseConsecutive(s)) 

System.out.println(
"Yes"
); 

else

System.out.println(
"No"
); 


System.out.println(
"Stack content (from top) after function call"
); 

while
(s.isEmpty() == 
false
) 

{ 

System.out.print(s.peek() + 
" "
); 

s.pop(); 

} 

} 
} 