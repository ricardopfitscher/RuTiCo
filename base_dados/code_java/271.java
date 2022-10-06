
// A simple C++ program to count number of 
//substrings starting and ending with 1 

class
CountSubString 
{ 

int
countSubStr(
char
str[],
int
n) 

{ 

int
res = 
0
; 
// Initialize result 


// Pick a starting point 

for
(
int
i = 
0
; i<n; i++) 

{ 

if
(str[i] == 
'1'
) 

{ 

// Search for all possible ending point 

for
(
int
j = i + 
1
; j< n; j++) 

{ 

if
(str[j] == 
'1'
) 

res++; 

} 

} 

} 

return
res; 

} 


// Driver program to test the above function 

public
static
void
main(String[] args) 

{ 

CountSubString count = 
new
CountSubString(); 

String string = 
"00100101"
; 

char
str[] = string.toCharArray(); 

int
n = str.length; 

System.out.println(count.countSubStr(str,n)); 

} 
} 