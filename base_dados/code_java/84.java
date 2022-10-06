
// A Simple Java program to find longest common 
// subarray of two binary arrays with same sum 

class
Test 
{ 

static
int
arr1[] = 
new
int
[]{
0
, 
1
, 
0
, 
1
, 
1
, 
1
, 
1
}; 

static
int
arr2[] = 
new
int
[]{
1
, 
1
, 
1
, 
1
, 
1
, 
0
, 
1
}; 


// Returns length of the longest common sum in arr1[] 

// and arr2[]. Both are of same size n. 

static
int
longestCommonSum(
int
n) 

{ 

// Initialize result 

int
maxLen = 
0
; 


// One by one pick all possible starting points 

// of subarrays 

for
(
int
i=
0
; i<n; i++) 

{ 

// Initialize sums of current subarrays 

int
sum1 = 
0
, sum2 = 
0
; 


// Conider all points for starting with arr[i] 

for
(
int
j=i; j<n; j++) 

{ 

// Update sums 

sum1 += arr1[j]; 

sum2 += arr2[j]; 


// If sums are same and current length is 

// more than maxLen, update maxLen 

if
(sum1 == sum2) 

{ 

int
len = j-i+
1
; 

if
(len > maxLen) 

maxLen = len; 

} 

} 

} 

return
maxLen; 

} 


// Driver method to test the above function 

public
static
void
main(String[] args) 

{ 

System.out.print(
"Length of the longest common span with same sum is "
); 

System.out.println(longestCommonSum(arr1.length)); 

} 
} 