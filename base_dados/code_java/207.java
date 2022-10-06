
//Java program to find the maximum depth of nested 
// parenthesis in a given expression 

class
GFG { 
// function takes a string and returns the 
// maximum depth nested parenthesis 


static
int
maxDepth(String S) { 

int
current_max = 
0
; 
// current count 

int
max = 
0
; 
// overall maximum count 

int
n = S.length(); 


// Traverse the input string 

for
(
int
i = 
0
; i < n; i++) { 

if
(S.charAt(i) == 
'('
) { 

current_max++; 


// update max if required 

if
(current_max > max) { 

max = current_max; 

} 

} 
else
if
(S.charAt(i) == 
')'
) { 

if
(current_max > 
0
) { 

current_max--; 

} 
else
{ 

return
-
1
; 

} 

} 

} 


// finally check for unbalanced string 

if
(current_max != 
0
) { 

return
-
1
; 

} 


return
max; 

} 

// Driver program 

public
static
void
main(String[] args) { 

String s = 
"( ((X)) (((Y))) )"
; 

System.out.println(maxDepth(s)); 

} 
} 