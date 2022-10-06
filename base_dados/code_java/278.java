
// A Simple Java program to find pairs with distance 
// equal to English alphabet distance 
class
Test { 


// Method to count pairs 

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

for
(
int
j = i + 
1
; j < n; j++) 


// Increment count if characters 

// are at same distance 

if
(Math.abs(str.charAt(i) - str.charAt(j)) == 

Math.abs(i - j)) 

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