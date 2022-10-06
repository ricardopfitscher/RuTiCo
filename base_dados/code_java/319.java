
/* Dynamic programming Java implementation 
of maximum product of an increasing 
subsequence */
import
java.util.Arrays; 
import
java.util.Collections; 

class
GFG { 


// Returns product of maximum product 

// increasing subsequence. 

static
int
lis(
int
[] arr, 
int
n) 

{ 

int
[] mpis = 
new
int
[n]; 

int
max = Integer.MIN_VALUE; 


/* Initialize MPIS values */

for
(
int
i = 
0
; i < n; i++) 

mpis[i] = arr[i]; 


/* Compute optimized MPIS values 

considering every element as ending 

element of sequence */

for
(
int
i = 
1
; i < n; i++) 

for
(
int
j = 
0
; j < i; j++) 

if
(arr[i] > arr[j] && mpis[i] 

< (mpis[j] * arr[i])) 

mpis[i] = mpis[j] * arr[i]; 


/* Pick maximum of all product values 

using for loop*/

for
(
int
k = 
0
; k < mpis.length; k++) 

{ 

if
(mpis[k] > max) { 

max = mpis[k]; 

} 

} 


return
max; 

} 


// Driver program to test above function 

static
public
void
main(String[] args) 

{ 


int
[] arr = { 
3
, 
100
, 
4
, 
5
, 
150
, 
6
}; 

int
n = arr.length; 


System.out.println(lis(arr, n)); 

} 
} 

// This code is contributed by parashar. 