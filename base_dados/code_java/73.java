
// Java program to find Minimum 
// number of jumps to reach end 
class
GFG 
{ 
// Returns Minimum number 
// of jumps to reach end 
static
int
minJumps(
int
arr[], 

int
n) 
{ 

// jumps[0] will 

// hold the result 

int
[] jumps = 
new
int
[n]; 

int
min; 


// Minimum number of jumps 

// needed to reach last 

// element from last elements 

// itself is always 0 

jumps[n - 
1
] = 
0
; 



// Start from the second 

// element, move from right 

// to left and construct the 

// jumps[] array where jumps[i] 

// represents minimum number of 

// jumps needed to reach arr[m-1] 

// from arr[i] 

for
(
int
i = n - 
2
; i >= 
0
; i--) 

{ 

// If arr[i] is 0 then arr[n-1] 

// can't be reached from here 

if
(arr[i] == 
0
) 

jumps[i] = Integer.MAX_VALUE; 


// If we can direcly reach to 

// the end point from here then 

// jumps[i] is 1 

else
if
(arr[i] >= n - i - 
1
) 

jumps[i] = 
1
; 


// Otherwise, to find out 

// the minimum number of 

// jumps needed to reach 

// arr[n-1], check all the 

// points reachable from 

// here and jumps[] value 

// for those points 

else

{ 

// initialize min value 

min = Integer.MAX_VALUE; 


// following loop checks 

// with all reachable points 

// and takes the minimum 

for
(
int
j = i + 
1
; j < n && 

j <= arr[i] + i; j++) 

{ 

if
(min > jumps[j]) 

min = jumps[j]; 

} 


// Handle overflow 

if
(min != Integer.MAX_VALUE) 

jumps[i] = min + 
1
; 

else

jumps[i] = min; 
// or Integer.MAX_VALUE 

} 

} 


return
jumps[
0
]; 
} 

// Driver Code 
public
static
void
main(String[] args) 
{ 

int
[] arr = {
1
, 
3
, 
6
, 
1
, 
0
, 
9
}; 

int
size = arr.length; 

System.out.println(
"Minimum number of"
+ 

" jumps to reach end is "
+ 

minJumps(arr, size)); 

} 
} 

// This code is contributed by mits. 