
// Space optimized CPP implementation of 
// longest common substring. 
import
java.io.*; 
import
java.util.*; 

public
class
GFG { 


// Function to find longest 

// common substring. 

static
int
LCSubStr(String X, String Y) 

{ 


// Find length of both the strings. 

int
m = X.length(); 

int
n = Y.length(); 


// Variable to store length of longest 

// common substring. 

int
result = 
0
; 


// Matrix to store result of two 

// consecutive rows at a time. 

int
[][]len = 
new
int
[
2
][n]; 


// Variable to represent which row of 

// matrix is current row. 

int
currRow = 
0
; 


// For a particular value of 

// i and j, len[currRow][j] 

// stores length of longest 

// common substring in string 

// X[0..i] and Y[0..j]. 

for
(
int
i = 
0
; i < m; i++) { 

for
(
int
j = 
0
; j < n; j++) { 

if
(i == 
0
|| j == 
0
) { 

len[currRow][j] = 
0
; 

} 

else
if
(X.charAt(i - 
1
) == 

Y.charAt(j - 
1
)) 

{ 

len[currRow][j] = 

len[(
1
- currRow)][(j - 
1
)] 

+ 
1
; 

result = Math.max(result, 

len[currRow][j]); 

} 

else

{ 

len[currRow][j] = 
0
; 

} 

} 


// Make current row as previous 

// row and previous row as 

// new current row. 

currRow = 
1
- currRow; 

} 


return
result; 

} 


// Driver Code 

public
static
void
main(String args[]) 

{ 

String X = 
"GeeksforGeeks"
; 

String Y = 
"GeeksQuiz"
; 


System.out.print(LCSubStr(X, Y)); 

} 
} 

// This code is contributed by 
// Manish Shaw (manishshaw1) 