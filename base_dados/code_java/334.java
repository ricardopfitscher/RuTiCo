
// Java Program to find the length of 
// substring with maximum difference of 
// zeroes and ones in binary string. 
import
java.util.*; 
import
java.lang.*; 
import
java.io.*; 

class
GFG { 


// Find the length of substring with maximum 

// difference of zeros and ones in binary 

// string 

public
static
int
findLength(String str, 
int
n) 

{ 


int
current_sum = 
0
; 

int
max_sum = 
0
; 


// traverse a binary string from left to right 

for
(
int
i = 
0
; i < n; i++) { 


// add current value to the current_sum 

// according to the Character 

// if it's '0' add 1 else -1 

current_sum += (str.charAt(i) == 
'0'
? 
1
: -
1
); 


if
(current_sum < 
0
) 

current_sum = 
0
; 


// update maxium sum 

max_sum = Math.max(current_sum, max_sum); 

} 

// return -1 if string does not contain any zero 

// that means string contains all ones otherwise max_sum 

return
max_sum == 
0
? -
1
: max_sum; 

} 


public
static
void
main(String[] args) 

{ 

String str = 
"11000010001"
; 

int
n = str.length(); 


System.out.println(findLength(str, n)); 

} 
} 