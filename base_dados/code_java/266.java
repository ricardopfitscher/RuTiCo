
// Java program to print distinct characters of 
// a string. 
import
java.util.Arrays; 

public
class
GFG { 


static
final
int
MAX_CHAR = 
256
; 


// Function to print distinct characters in 

// given string str[] 

static
void
printDistinct(String str) 

{ 

int
n = str.length(); 


// count[x] is going to store count of 

// character 'x' in str. If x is not present, 

// then it is going to store 0. 

int
[] count = 
new
int
[MAX_CHAR]; 


// index[x] is going to store index of character 

// 'x' in str. If x is not present or x is 

// more than once, then it is going to store a 

// value (for example, length of string) that 

// cannot be a valid index in str[] 

int
[] index = 
new
int
[MAX_CHAR]; 


// Initialize counts of all characters and 

// indexes of distinct characters. 

for
(
int
i = 
0
; i < MAX_CHAR; i++) 

{ 

count[i] = 
0
; 

index[i] = n; 
// A value more than any 

// index in str[] 

} 


// Traverse the input string 

for
(
int
i = 
0
; i < n; i++) 

{ 

// Find current character and increment 

// its count 

char
x = str.charAt(i); 

++count[x]; 


// If this is first occurrence, then set 

// value in index as index of it. 

if
(count[x] == 
1
&& x !=
' '
) 

index[x] = i; 


// If character repeats, then remove it 

// from index[] 

if
(count[x] == 
2
) 

index[x] = n; 

} 


// Since size of index is constant, below 

// operations take constant time. 

Arrays.sort(index); 


for
(
int
i = 
0
; i < MAX_CHAR && index[i] != n; 

i++) 

System.out.print(str.charAt(index[i])); 

} 


// Driver code 

public
static
void
main(String args[]) 

{ 

String str = 
"GeeksforGeeks"
; 

printDistinct(str); 

} 
} 
// This code is contributed by Sumit Ghosh 