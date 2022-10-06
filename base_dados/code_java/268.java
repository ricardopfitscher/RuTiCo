
// Java Program to find all the common characters 
// in n strings 
import
java.util.*; 
import
java.lang.*; 

class
GFG { 


static
int
MAX_CHAR = 
26
; 


public
static
void
commonCharacters(String str[], 

int
n) 

{ 


// primary array for common characters 

// we assume all characters are seen before. 

Boolean[] prim = 
new
Boolean[MAX_CHAR]; 

Arrays.fill(prim, 
new
Boolean(
true
)); 


// for each string 

for
(
int
i = 
0
; i < n; i++) { 


// secondary array for common characters 

// Initially marked false 

Boolean[] sec = 
new
Boolean[MAX_CHAR]; 

Arrays.fill(sec, 
new
Boolean(
false
)); 


// for every character of ith string 

for
(
int
j = 
0
; j < str[i].length(); j++) 

{ 


// if character is present in all 

// strings before, mark it. 

if
(prim[str[i].charAt(j) - 
'a'
]) 

sec[str[i].charAt(j) - 
'a'
] = 
true
; 

} 


// copy whole secondary array into primary 

System.arraycopy(sec, 
0
, prim, 
0
, MAX_CHAR); 

} 


// displaying common characters 

for
(
int
i = 
0
; i < 
26
; i++) 

if
(prim[i]){ 

System.out.print(Character.toChars(i 

+ 
97
)); 

System.out.print(
" "
); 

} 

} 


// Driver code 

public
static
void
main(String[] args) 

{ 

String str[] = { 
"geeksforgeeks"
, 

"gemkstones"
, 

"acknowledges"
, 

"aguelikes"
}; 


int
n = str.length; 

commonCharacters(str, n); 

} 
} 

// This code is contributed by Prasad Kshirsagar 