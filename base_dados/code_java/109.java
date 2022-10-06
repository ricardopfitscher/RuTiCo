
// Java program to calculate the 
// product of max element of first 
// array and min element of second array 
import
java.util.*; 
import
java.lang.*; 

class
GfG 
{ 


// Function to calculate the product 

public
static
int
minMaxProduct(
int
arr1[], 

int
arr2[], 

int
n1, 

int
n2) 

{ 


// Initialize max of 

// first array 

int
max = arr1[
0
]; 


// initialize min of 

// second array 

int
min = arr2[
0
]; 


int
i; 

for
(i = 
1
; i < n1 && i < n2; ++i) 

{ 


// To find the maximum 

// element in first array 

if
(arr1[i] > max) 

max = arr1[i]; 


// To find the minimum element 

// in second array 

if
(arr2[i] < min) 

min = arr2[i]; 

} 


// Process remaining elements 

while
(i < n1) 

{ 

if
(arr1[i] > max) 

max = arr1[i]; 

i++; 

} 

while
(i < n2) 

{ 

if
(arr2[i] < min) 

min = arr2[i]; 

i++; 

} 


return
max * min; 

} 


// Driver Code 

public
static
void
main(String argc[]) 

{ 

int
[] arr1= 
new
int
[]{ 
10
, 
2
, 
3
, 

6
, 
4
, 
1
}; 

int
[] arr2 = 
new
int
[]{ 
5
, 
1
, 
4
, 

2
, 
6
, 
9
}; 

int
n1 = 
6
; 

int
n2 = 
6
; 

System.out.println(minMaxProduct(arr1, arr2, 

n1, n2)); 

} 
} 

// This code is contributed by Sagar Shukla 