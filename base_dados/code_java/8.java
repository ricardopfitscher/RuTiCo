
// JAVA implementation of left rotation 
// of an array K number of times 
import
java.util.*; 
import
java.lang.*; 
import
java.io.*; 

class
arr_rot 
{ 

// Function to leftRotate array multiple 

// times 

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

/* To get the starting point of 

rotated array */

int
mod = k % n; 


// Prints the rotated array from 

// start position 

for
(
int
i = 
0
; i < n; ++i) 

System.out.print(arr[(i + mod) % n] 

+ 
" "
); 


System.out.println(); 

} 


// Driver program 

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


k = 
3
; 

leftRotate(arr, n, k); 


k = 
4
; 

leftRotate(arr, n, k); 

} 
} 

// This code is contributed by Sanjal 