
// An otpimized Java program to find pairs with distance 
// equal to English alphabet distance 

class
Test { 

static
final
int
MAX_CHAR = 
26
; 


// Method to count pairs with distance 

// equal to English alphabet distance 

static
int
countPairs(String str) 

{ 

int
result = 
0
; 

int
n = str.length(); 


for
(
int
i = 
0
; i < n; i++) 


// This loop runs at most 26 times 

for
(
int
j = 
1
; (i + j) < n && j <= MAX_CHAR; j++) 

if
((Math.abs(str.charAt(i + j) - str.charAt(i)) == j)) 

result++; 


return
result; 

} 


// Driver method 

public
static
void
main(String args[]) 

{ 

String str = 
"geeksforgeeks"
; 

System.out.println(countPairs(str)); 

} 
} 