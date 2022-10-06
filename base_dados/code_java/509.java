
// Java program to print a string with 
// no adjacent duplicates by doing 
// minimum changes to original string 
import
java.util.*; 
import
java.lang.*; 

public
class
GfG{ 


// Function to print simple string 

public
static
String noAdjacentDup(String s1) 

{ 

int
n = s1.length(); 

char
[] s = s1.toCharArray(); 

for
(
int
i = 
1
; i < n; i++) 

{ 

// If any two adjacent 

// characters are equal 

if
(s[i] == s[i - 
1
]) 

{ 

// Initialize it to 'a' 

s[i] = 
'a'
; 


// Traverse the loop until it 

// is different from the left 

// and right letter. 

while
(s[i] == s[i - 
1
] || 

(i + 
1
< n && s[i] == s[i + 
1
])) 

s[i]++; 


i++; 

} 

} 

return
(
new
String(s)); 

} 


// Driver function 

public
static
void
main(String argc[]){ 


String s = 
"geeksforgeeks"
; 

System.out.println(noAdjacentDup(s)); 


} 

} 

/* This code is contributed by Sagar Shukla */