
// Java program to find pair with sum closest to x 
import
java.io.*; 
import
java.util.*; 
import
java.lang.Math; 

class
CloseSum { 


// Prints the pair with sum cloest to x 

static
void
printClosest(
int
arr[], 
int
n, 
int
x) 

{ 

int
res_l=
0
, res_r=
0
; 
// To store indexes of result pair 


// Initialize left and right indexes and difference between 

// pair sum and x 

int
l = 
0
, r = n-
1
, diff = Integer.MAX_VALUE; 


// While there are elements between l and r 

while
(r > l) 

{ 

// Check if this pair is closer than the closest pair so far 

if
(Math.abs(arr[l] + arr[r] - x) < diff) 

{ 

res_l = l; 

res_r = r; 

diff = Math.abs(arr[l] + arr[r] - x); 

} 


// If this pair has more sum, move to smaller values. 

if
(arr[l] + arr[r] > x) 

r--; 

else
// Move to larger values 

l++; 

} 


System.out.println(
" The closest pair is "
+arr[res_l]+
" and "
+ arr[res_r]); 
} 



// Driver program to test above function 

public
static
void
main(String[] args) 

{ 

int
arr[] = {
10
, 
22
, 
28
, 
29
, 
30
, 
40
}, x = 
54
; 

int
n = arr.length; 

printClosest(arr, n, x); 

} 
} 
/*This code is contributed by Devesh Agrawal*/