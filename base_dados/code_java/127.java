
/* Program to check for majority element in a sorted array */
import
java.io.*; 

class
Majority { 


/* If x is present in arr[low...high] then returns the index of 

first occurrence of x, otherwise returns -1 */

static
int
_binarySearch(
int
arr[], 
int
low, 
int
high, 
int
x) 

{ 

if
(high >= low) 

{ 

int
mid = (low + high)/
2
; 
/*low + (high - low)/2;*/


/* Check if arr[mid] is the first occurrence of x. 

arr[mid] is first occurrence if x is one of the following 

is true: 

(i) mid == 0 and arr[mid] == x 

(ii) arr[mid-1] < x and arr[mid] == x 

*/

if
( (mid == 
0
|| x > arr[mid-
1
]) && (arr[mid] == x) ) 

return
mid; 

else
if
(x > arr[mid]) 

return
_binarySearch(arr, (mid + 
1
), high, x); 

else

return
_binarySearch(arr, low, (mid -
1
), x); 

} 


return
-
1
; 

} 



/* This function returns true if the x is present more than n/2 

times in arr[] of size n */

static
boolean
isMajority(
int
arr[], 
int
n, 
int
x) 

{ 

/* Find the index of first occurrence of x in arr[] */

int
i = _binarySearch(arr, 
0
, n-
1
, x); 


/* If element is not present at all, return false*/

if
(i == -
1
) 

return
false
; 


/* check if the element is present more than n/2 times */

if
(((i + n/
2
) <= (n -
1
)) && arr[i + n/
2
] == x) 

return
true
; 

else

return
false
; 

} 


/*Driver function to check for above functions*/

public
static
void
main (String[] args) { 


int
arr[] = {
1
, 
2
, 
3
, 
3
, 
3
, 
3
, 
10
}; 

int
n = arr.length; 

int
x = 
3
; 

if
(isMajority(arr, n, x)==
true
) 

System.out.println(x + 
" appears more than "
+ 

n/
2
+ 
" times in arr[]"
); 

else

System.out.println(x + 
" does not appear more than "
+ 

n/
2
+ 
" times in arr[]"
); 

} 
} 
/*This code is contributed by Devesh Agrawal*/