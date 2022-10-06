
// Java implementation to find the character in 
// first string that is present at minimum index 
// in second string 

public
class
GFG 
{ 

// method to find the minimum index character 

static
void
printMinIndexChar(String str, String patt) 

{ 

// to store the index of character having 

// minimum index 

int
minIndex = Integer.MAX_VALUE; 


// lengths of the two strings 

int
m = str.length(); 

int
n = patt.length(); 


// traverse 'patt' 

for
(
int
i = 
0
; i < n; i++) { 


// for each character of 'patt' traverse 'str' 

for
(
int
j = 
0
; j < m; j++) { 


// if patt.charAt(i)is found in 'str', check if 

// it has the minimum index or not. If yes, 

// then update 'minIndex' and break 

if
(patt.charAt(i)== str.charAt(j) && j < minIndex) { 

minIndex = j; 

break
; 

} 

} 

} 


// print the minimum index character 

if
(minIndex != Integer.MAX_VALUE) 

System.out.println(
"Minimum Index Character = "
+ 

str.charAt(minIndex)); 


// if no character of 'patt' is present in 'str' 

else

System.out.println(
"No character present"
); 

} 


// Driver Method 

public
static
void
main(String[] args) 

{ 

String str = 
"geeksforgeeks"
; 

String patt = 
"set"
; 

printMinIndexChar(str, patt); 

} 
} 