
// Java program to Rearrange positive and negative 
// numbers in a array 
class
GFG { 


/* Function to print an array */

static
void
printArray(
int
A[], 
int
size) 

{ 

for
(
int
i = 
0
; i < size; i++) 

System.out.print(A[i] + 
" "
); 

System.out.println(
""
); 

; 

} 


/* Function to reverse an array. An array can be 
reversed in O(n) time and O(1) space. */

static
void
reverse(
int
arr[], 
int
l, 
int
r) 

{ 

if
(l < r) { 

arr = swap(arr, l, r); 

reverse(arr, ++l, --r); 

} 

} 


// Merges two subarrays of arr[]. 

// First subarray is arr[l..m] 

// Second subarray is arr[m+1..r] 

static
void
merge(
int
arr[], 
int
l, 
int
m, 
int
r) 

{ 

int
i = l; 
// Initial index of 1st subarray 

int
j = m + 
1
; 
// Initial index of IInd 


while
(i <= m && arr[i] < 
0
) 

i++; 


// arr[i..m] is positive 


while
(j <= r && arr[j] < 
0
) 

j++; 


// arr[j..r] is positive 


// reverse positive part of 

// left sub-array (arr[i..m]) 

reverse(arr, i, m); 


// reverse negative part of 

// right sub-array (arr[m+1..j-1]) 

reverse(arr, m + 
1
, j - 
1
); 


// reverse arr[i..j-1] 

reverse(arr, i, j - 
1
); 

} 


// Function to Rearrange positive and negative 

// numbers in a array 

static
void
RearrangePosNeg(
int
arr[], 
int
l, 
int
r) 

{ 

if
(l < r) { 

// Same as (l+r)/2, but avoids overflow for 

// large l and h 

int
m = l + (r - l) / 
2
; 


// Sort first and second halves 

RearrangePosNeg(arr, l, m); 

RearrangePosNeg(arr, m + 
1
, r); 


merge(arr, l, m, r); 

} 

} 

static
int
[] swap(
int
[] arr, 
int
i, 
int
j) 

{ 

int
temp = arr[i]; 

arr[i] = arr[j]; 

arr[j] = temp; 

return
arr; 

} 


/* Driver code*/

public
static
void
main(String[] args) 

{ 

int
arr[] = { -
12
, 
11
, -
13
, -
5
, 
6
, -
7
, 
5
, -
3
, -
6
}; 

int
arr_size = arr.length; 


RearrangePosNeg(arr, 
0
, arr_size - 
1
); 


printArray(arr, arr_size); 

} 
} 

// This code has been contributed by 29AjayKumar 