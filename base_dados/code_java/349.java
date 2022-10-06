
// Java program to print sum of all substring of 
// a number represented as a string 
import
java.util.Arrays; 

class
GFG{ 


// Returns sum of all substring of num 

public
static
int
sumOfSubstrings(String num) 

{ 

int
n = num.length(); 


// allocate memory equal to length of string 

int
sumofdigit[] = 
new
int
[n]; 


// initialize first value with first digit 

sumofdigit[
0
] = num.charAt(
0
)-
'0'
; 

int
res = sumofdigit[
0
]; 


// loop over all digits of string 

for
(
int
i = 
1
; i < n; i++) 

{ 

int
numi = num.charAt(i)-
'0'
; 


// update each sumofdigit from previous value 

sumofdigit[i] = (i+
1
) * numi + 

10
* sumofdigit[i-
1
]; 


// add current value to the result 

res += sumofdigit[i]; 

} 


return
res; 

} 


// Driver code to test above methods 

public
static
void
main(String[] args) 

{ 

String num = 
"1234"
; 


System.out.println(sumOfSubstrings(num)); 


} 
} 
// This code is contributed by Arnav Kr. Mandal. 