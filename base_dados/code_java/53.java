
// Java program to find out k maximum 
// non-overlapping sub-array sums. 

class
GFG { 


// Method to compute k maximum 

// sub-array sums. 

static
void
kmax(
int
arr[], 
int
k, 
int
n) { 


// In each iteration it will give 

// the ith maximum subarray sum. 

for
(
int
c = 
0
; c < k; c++) 

{ 

// Kadane's algorithm. 

int
max_so_far = Integer.MIN_VALUE; 

int
max_here = 
0
; 


// compute starting and ending 

// index of each of the sub-array. 

int
start = 
0
, end = 
0
, s = 
0
; 

for
(
int
i = 
0
; i < n; i++) 

{ 

max_here += arr[i]; 

if
(max_so_far < max_here) 

{ 

max_so_far = max_here; 

start = s; 

end = i; 

} 

if
(max_here < 
0
) 

{ 

max_here = 
0
; 

s = i + 
1
; 

} 

} 


// Print out the result. 

System.out.println(
"Maximum non-overlapping sub-arraysum"
+ 

(c + 
1
) + 
": "
+ max_so_far + 

", starting index: "
+ start + 

", ending index: "
+ end + 
"."
); 


// Replace all elements of the maximum subarray 

// by -infinity. Hence these places cannot form 

// maximum sum subarray again. 

for
(
int
l = start; l <= end; l++) 

arr[l] = Integer.MIN_VALUE; 

} 

System.out.println(); 

} 


// Driver Program 

public
static
void
main(String[] args) 

{ 

// Test case 1 

int
arr1[] = {
4
, 
1
, 
1
, -
1
, -
3
, -
5
, 

6
, 
2
, -
6
, -
2
}; 

int
k1 = 
3
; 

int
n1 = arr1.length; 


// Function calling 

kmax(arr1, k1, n1); 


// Test case 2 

int
arr2[] = {
5
, 
1
, 
2
, -
6
, 
2
, -
1
, 
3
, 
1
}; 

int
k2 = 
2
; 

int
n2 = arr2.length; 


// Function calling 

kmax(arr2, k2, n2); 

} 
} 

// This code is contributed by Nirmal Patel 