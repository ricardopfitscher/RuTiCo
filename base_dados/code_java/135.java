
// Java code to find maximum triplet sum 
import
java.io.*; 

class
GFG { 


static
int
maxTripletSum(
int
arr[], 
int
n) 

{ 

// Initialize sum with INT_MIN 

int
sum = -
1000000
; 


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

for
(
int
k = j + 
1
; k < n; k++) 

if
(sum < arr[i] + arr[j] + arr[k]) 

sum = arr[i] + arr[j] + arr[k]; 

return
sum; 

} 


// Driven code 

public
static
void
main(String args[]) 

{ 

int
arr[] = { 
1
, 
0
, 
8
, 
6
, 
4
, 
2
}; 

int
n = arr.length; 

System.out.println(maxTripletSum(arr, n)); 

} 
} 

// This code is contributed by Nikita Tiwari. 