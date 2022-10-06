
// Java program to find the only repeating 
// element in an array where elements are 
// from 1 to n-1. 
import
java.io.*; 
import
java.util.*; 

class
GFG 
{ 


static
int
findRepeating(
int
[] arr, 
int
n) 

{ 

// Find array sum and subtract sum 

// first n-1 natural numbers from it 

// to find the result. 


int
sum = 
0
; 

for
(
int
i = 
0
; i < n; i++) 

sum += arr[i]; 

return
sum - (((n - 
1
) * n) / 
2
); 

} 


// Driver code 

public
static
void
main(String args[]) 

{ 

int
[] arr = { 
9
, 
8
, 
2
, 
6
, 
1
, 
8
, 
5
, 
3
, 
4
, 
7
}; 

int
n = arr.length; 

System.out.println(findRepeating(arr, n)); 

} 
} 

// This code is contributed by rachana soma 