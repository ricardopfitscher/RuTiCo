
import
java.util.*; 
// Java program to find the only repeating 
// element in an array where elements are 
// from 1 to n-1. 

class
GFG 
{ 

static
int
findRepeating(
int
arr[], 
int
n) 
{ 

HashSet<Integer> s = 
new
HashSet<Integer>(); 

for
(
int
i = 
0
; i < n; i++) 

{ 

if
(s.contains(arr[i])) 

return
arr[i]; 

s.add(arr[i]); 

} 


// If input is correct, we should 

// never reach here 

return
-
1
; 
} 

// Driver code 
public
static
void
main(String[] args) 
{ 

int
arr[] = { 
9
, 
8
, 
2
, 
6
, 
1
, 
8
, 
5
, 
3
, 
4
, 
7
}; 

int
n = arr.length; 

System.out.println(findRepeating(arr, n));; 
} 
} 

// This code is contributed by Rajput-Ji 