
// Java program to print distinct characters of a 
// string. 
public
class
GFG { 

static
final
int
NO_OF_CHARS = 
256
; 


/* Print duplicates present in the passed string */

static
void
printDistinct(String str) 

{ 

// Create an array of size 256 and count of 

// every character in it 

int
[] count = 
new
int
[NO_OF_CHARS]; 


/* Count array with frequency of characters */

int
i; 

for
(i = 
0
; i < str.length(); i++) 

if
(str.charAt(i)!=
' '
) 

count[(
int
)str.charAt(i)]++; 

int
n = i; 


// Print characters having count more than 0 

for
(i = 
0
; i < n; i++) 

if
(count[(
int
)str.charAt(i)] == 
1
) 

System.out.print(str.charAt(i)); 

} 


/* Driver program*/

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