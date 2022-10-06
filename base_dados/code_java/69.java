
class
MinimumDistance 
{ 

int
minDist(
int
arr[], 
int
n, 
int
x, 
int
y) 

{ 

int
i = 
0
; 

int
min_dist = Integer.MAX_VALUE; 

int
prev=
0
; 


// Find the first occurence of any of the two numbers (x or y) 

// and store the index of this occurence in prev 

for
(i = 
0
; i < n; i++) 

{ 

if
(arr[i] == x || arr[i] == y) 

{ 

prev = i; 

break
; 

} 

} 


// Traverse after the first occurence 

for
(; i < n; i++) 

{ 

if
(arr[i] == x || arr[i] == y) 

{ 

// If the current element matches with any of the two then 

// check if current element and prev element are different 

// Also check if this value is smaller than minimum distance 

// so far 

if
(arr[prev] != arr[i] && (i - prev) < min_dist) 

{ 

min_dist = i - prev; 

prev = i; 

} 

else

prev = i; 

} 

} 


return
min_dist; 

} 


/* Driver program to test above functions */

public
static
void
main(String[] args) { 

MinimumDistance min = 
new
MinimumDistance(); 

int
arr[] = {
3
, 
5
, 
4
, 
2
, 
6
, 
3
, 
0
, 
0
, 
5
, 
4
, 
8
, 
3
}; 

int
n = arr.length; 

int
x = 
3
; 

int
y = 
6
; 


System.out.println(
"Minimum distance between "
+ x + 
" and "
+ y 

+ 
" is "
+ min.minDist(arr, n, x, y)); 

} 
} 