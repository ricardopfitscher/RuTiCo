
// Java code for k largest elements in an array 
import
java.util.Arrays; 
import
java.util.Collections; 

class
GFG { 

public
static
void
kLargest(Integer[] arr, 
int
k) 

{ 

// Sort the given array arr in reverse order 

// This method doesn't work with primitive data 

// types. So, instead of int, Integer type 

// array will be used 

Arrays.sort(arr, Collections.reverseOrder()); 


// Print the first kth largest elements 

for
(
int
i = 
0
; i < k; i++) 

System.out.print(arr[i] + 
" "
); 

} 


public
static
void
main(String[] args) 

{ 

Integer arr[] = 
new
Integer[] { 
1
, 
23
, 
12
, 
9
, 

30
, 
2
, 
50
}; 

int
k = 
3
; 

kLargest(arr, k); 

} 
} 
// This code is contributed by Kamal Rawal 