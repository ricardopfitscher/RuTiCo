
// Java code to find sum of 
// all area rectangle possible 
import
java.io.*; 
import
java.util.Arrays; 

class
GFG 
{ 

// Function to find 

// area of rectangles 

static
int
MaxTotalRectangleArea(
int
[]a, 

int
n) 

{ 


// sorting the array in 

// descending order 

Arrays.sort(a); 


// store the final sum of 

// all the rectangles area 

// possible 

int
sum = 
0
; 

boolean
flag = 
false
; 


// temporary variable to 

// store the length of rectangle 

int
len = 
0
; 


for
(
int
i = 
0
; i < n; i++) 

{ 


// Selecting the length of 

// rectangle so that difference 

// between any two number is 1 

// only. Here length is selected 

// so flag is set 

if
((a[i] == a[i + 
1
] || 

a[i] - a[i + 
1
] == 
1
) && 

!flag) 

{ 

// flag is set means 

// we have got length of 

// rectangle 

flag = 
true
; 


// length is set to 

// a[i+1] so that if 

// a[i] a[i+1] is less 

// than by 1 then also 

// we have the correct 

// choice for length 

len = a[i + 
1
]; 


// incrementing the counter 

// one time more as we have 

// considered a[i+1] element 

// also so. 

i++; 

} 


// Selecting the width of rectangle 

// so that difference between any 

// two number is 1 only. Here width 

// is selected so now flag is again 

// unset for next rectangle 

else
if
((a[i] == a[i + 
1
] || 

a[i] - a[i + 
1
] == 
1
) && 

(flag)) 

{ 

// area is calculated for 

// rectangle 

sum = sum + a[i + 
1
] * len; 


// flag is set false 

// for another rectangle 

// which we can get from 

// elements in array 

flag = 
false
; 


// incrementing the counter 

// one time more as we have 

// considered a[i+1] element 

// also so. 

i++; 

} 

} 


return
sum; 

} 


// Driver code 

public
static
void
main (String args[]) 

{ 

int
[]a = { 
10
, 
10
, 
10
, 
10
, 

11
, 
10
, 
11
, 
10
, 

9
, 
9
, 
8
, 
8
}; 

int
n = a.length; 


System.out.print(MaxTotalRectangleArea(a, n)); 

} 
} 
// This code is contributed by 
// Manish Shaw(manishshaw1) 