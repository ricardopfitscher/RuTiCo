
// Java program to find the 
// maximum value of i*arr[i] 
import
java.util.*; 

class
GFG { 


static
int
maxSum(
int
arr[], 
int
n) 

{ 

// Sort the array 

Arrays.sort(arr); 


// Finding the sum of arr[i]*i 

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

sum += (arr[i] * i); 


return
sum; 

} 


// Driven Program 

public
static
void
main(String[] args) 

{ 

int
arr[] = { 
3
, 
5
, 
6
, 
1
}; 

int
n = arr.length; 


System.out.println(maxSum(arr, n)); 


} 
} 
// This code is contributed by Prerna Saini 