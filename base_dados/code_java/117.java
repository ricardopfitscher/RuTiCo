
// java program to find maximum 
// equilibrium sum. 
import
java.io.*; 

class
GFG { 


// Function to find maximum 

// equilibrium sum. 

static
int
findMaxSum(
int
[]arr, 
int
n) 

{ 

int
res = Integer.MIN_VALUE; 


for
(
int
i = 
0
; i < n; i++) 

{ 

int
prefix_sum = arr[i]; 


for
(
int
j = 
0
; j < i; j++) 

prefix_sum += arr[j]; 


int
suffix_sum = arr[i]; 


for
(
int
j = n - 
1
; j > i; j--) 

suffix_sum += arr[j]; 


if
(prefix_sum == suffix_sum) 

res = Math.max(res, prefix_sum); 

} 


return
res; 

} 


// Driver Code 

public
static
void
main (String[] args) 

{ 

int
arr[] = {-
2
, 
5
, 
3
, 
1
, 
2
, 
6
, -
4
, 
2
}; 

int
n = arr.length; 

System.out.println(findMaxSum(arr, n)); 

} 
} 

// This code is contributed by anuj_67. 