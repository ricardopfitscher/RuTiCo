
// Java Program to find GCD of a number in a given Range 
// using segment Trees 
import
java.io.*; 

public
class
Main 
{ 

private
static
int
[] st; 
// Array to store segment tree 


/* Function to construct segment tree from given array. 

This function allocates memory for segment tree and 

calls constructSTUtil() to fill the allocated memory */

public
static
int
[] constructSegmentTree(
int
[] arr) 

{ 

int
height = (
int
)Math.ceil(Math.log(arr.length)/Math.log(
2
)); 

int
size = 
2
*(
int
)Math.pow(
2
, height)-
1
; 

st = 
new
int
[size]; 

constructST(arr, 
0
, arr.length-
1
, 
0
); 

return
st; 

} 


// A recursive function that constructs Segment 

// Tree for array[ss..se]. si is index of current 

// node in segment tree st 

public
static
int
constructST(
int
[] arr, 
int
ss, 

int
se, 
int
si) 

{ 

if
(ss==se) 

{ 

st[si] = arr[ss]; 

return
st[si]; 

} 

int
mid = ss+(se-ss)/
2
; 

st[si] = gcd(constructST(arr, ss, mid, si*
2
+
1
), 

constructST(arr, mid+
1
, se, si*
2
+
2
)); 

return
st[si]; 

} 


// Function to find gcd of 2 numbers. 

private
static
int
gcd(
int
a, 
int
b) 

{ 

if
(a < b) 

{ 

// If b greater than a swap a and b 

int
temp = b; 

b = a; 

a = temp; 

} 


if
(b==
0
) 

return
a; 

return
gcd(b,a%b); 

} 


//Finding The gcd of given Range 

public
static
int
findRangeGcd(
int
ss, 
int
se, 
int
[] arr) 

{ 

int
n = arr.length; 


if
(ss<
0
|| se > n-
1
|| ss>se) 

throw
new
IllegalArgumentException(
"Invalid arguments"
); 


return
findGcd(
0
, n-
1
, ss, se, 
0
); 

} 


/* A recursive function to get gcd of given 

range of array indexes. The following are parameters for 

this function. 


st --> Pointer to segment tree 

si --> Index of current node in the segment tree. Initially 

0 is passed as root is always at index 0 

ss & se --> Starting and ending indexes of the segment 

represented by current node, i.e., st[si] 

qs & qe --> Starting and ending indexes of query range */

public
static
int
findGcd(
int
ss, 
int
se, 
int
qs, 
int
qe, 
int
si) 

{ 

if
(ss>qe || se < qs) 

return
0
; 


if
(qs<=ss && qe>=se) 

return
st[si]; 


int
mid = ss+(se-ss)/
2
; 


return
gcd(findGcd(ss, mid, qs, qe, si*
2
+
1
), 

findGcd(mid+
1
, se, qs, qe, si*
2
+
2
)); 

} 


// Driver Code 

public
static
void
main(String[] args)
throws
IOException 

{ 

int
[] a = {
2
, 
3
, 
6
, 
9
, 
5
}; 


constructSegmentTree(a); 


int
l = 
1
; 
// Starting index of range. 

int
r = 
3
; 
//Last index of range. 

System.out.print(
"GCD of the given range is: "
); 

System.out.print(findRangeGcd(l, r, a)); 

} 
}