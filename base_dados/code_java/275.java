
// Java implementation to find the character in 
// first string that is present at minimum index 
// in second string 

import
java.util.HashMap; 

public
class
GFG 
{ 

// method to find the minimum index character 

static
void
printMinIndexChar(String str, String patt) 

{ 

// map to store the first index of each character of 'str' 

HashMap<Character, Integer> hm = 
new
HashMap<>(); 


// to store the index of character having 

// minimum index 

int
minIndex = Integer.MAX_VALUE; 


// lengths of the two strings 

int
m = str.length(); 

int
n = patt.length(); 


// store the first index of each character of 'str' 

for
(
int
i = 
0
; i < m; i++) 

if
(!hm.containsKey(str.charAt(i))) 

hm.put(str.charAt(i),i); 


// traverse the string 'patt' 

for
(
int
i = 
0
; i < n; i++) 

// if patt[i] is found in 'um', check if 

// it has the minimum index or not accordingly 

// update 'minIndex' 

if
(hm.containsKey(patt.charAt(i)) && 

hm.get(patt.charAt(i)) < minIndex) 

minIndex = hm.get(patt.charAt(i)); 


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