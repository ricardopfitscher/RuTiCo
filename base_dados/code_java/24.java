
// Java implementation of 
// left rotation of an 
// array K number of times 

import
java.io.*; 

class
GFG 
{ 

// Function to left rotate 
// an array k times 
static
void
leftRotate(
int
arr[], 

int
n, 
int
k) 
{ 

// Print array after 

// k rotations 

for
(
int
i = k; i < k + n; i++) 

System.out.print(arr[i % n] + 
" "
); 
} 

// Driver Code 
public
static
void
main (String[] args) 
{ 

int
arr[] = {
1
, 
3
, 
5
, 
7
, 
9
}; 

int
n = arr.length; 


int
k = 
2
; 

leftRotate(arr, n, k); 

System.out.println(); 


k = 
3
; 

leftRotate(arr, n, k); 

System.out.println(); 


k = 
4
; 

leftRotate(arr, n, k); 

System.out.println(); 
} 
} 

// This code is contributed by ajit 