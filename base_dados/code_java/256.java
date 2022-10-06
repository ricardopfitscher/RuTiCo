
// Java program to count words whose ith letter 
// is either (i-1)th, ith, or (i+1)th letter 
// of given word. 
public
class
GFG { 


// Return the count of words. 

static
int
countWords(String str, 
int
len) 

{ 

int
count = 
1
; 


// If word contain single letter, return 1. 

if
(len == 
1
) 

return
count; 


// Checking for first letter. 

if
(str.charAt(
0
) == str.charAt(
1
)) 

count *= 
1
; 

else

count *= 
2
; 


// Traversing the string and multiplying 

// for combinations. 

for
(
int
j = 
1
; j < len - 
1
; j++) 

{ 

// If all three letters are same. 

if
(str.charAt(j) == str.charAt(j - 
1
) && 

str.charAt(j) == str.charAt(j + 
1
)) 

count *= 
1
; 


// If two letter are distinct. 

else
if
(str.charAt(j) == str.charAt(j - 
1
)|| 

str.charAt(j) == str.charAt(j + 
1
) || 

str.charAt(j - 
1
) == str.charAt(j + 
1
)) 

count *= 
2
; 


// If all three letter are distinct. 

else

count *= 
3
; 

} 


// Checking for last letter. 

if
(str.charAt(len - 
1
) == str.charAt(len - 
2
)) 

count *= 
1
; 

else

count *= 
2
; 


return
count; 

} 


// Driven Program 

public
static
void
main(String args[]) 

{ 

String str = 
"abc"
; 

int
len = str.length(); 


System.out.println(countWords(str, len)); 

} 
} 
// This code is contributed by Sumit Ghosh 