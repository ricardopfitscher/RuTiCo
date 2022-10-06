
// Program to make all array equal 
import
java.io.*; 
import
java.util.Arrays; 

class
GFG { 

// function for calculating min operations 

static
int
minOps(
int
arr[], 
int
n, 
int
k) 

{ 

// max elements of array 

Arrays.sort(arr); 

int
max = arr[arr.length - 
1
]; 

int
res = 
0
; 


// iterate for all elements 

for
(
int
i = 
0
; i < n; i++) { 


// check if element can make equal to 

// max or not if not then return -1 

if
((max - arr[i]) % k != 
0
) 

return
-
1
; 


// else update res for required operations 

else

res += (max - arr[i]) / k; 

} 


// return result 

return
res; 

} 


// Driver program 

public
static
void
main(String[] args) 

{ 

int
arr[] = { 
21
, 
33
, 
9
, 
45
, 
63
}; 

int
n = arr.length; 

int
k = 
6
; 

System.out.println(minOps(arr, n, k)); 

} 
} 

// This code is contributed by vt_m 