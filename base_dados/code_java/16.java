
// Java implementation to rearrange the 
// array elements after modification 
class
GFG { 


// function which pushes all 

// zeros to end of an array. 

static
void
pushZerosToEnd(
int
arr[], 
int
n) 

{ 

// Count of non-zero elements 

int
count = 
0
; 


// Traverse the array. If element 

// encountered is non-zero, then 

// replace the element at index 

// 'count' with this element 

for
(
int
i = 
0
; i < n; i++) 

if
(arr[i] != 
0
) 


// here count is incremented 

arr[count++] = arr[i]; 


// Now all non-zero elements 

// have been shifted to front and 

// 'count' is set as index of first 0. 

// Make all elements 0 from count to end. 

while
(count < n) 

arr[count++] = 
0
; 

} 


// function to rearrange the array 

// elements after modification 

static
void
modifyAndRearrangeArr(
int
arr[], 
int
n) 

{ 

// if 'arr[]' contains a single element 

// only 

if
(n == 
1
) 

return
; 


// traverse the array 

for
(
int
i = 
0
; i < n - 
1
; i++) { 


// if true, perform the required modification 

if
((arr[i] != 
0
) && (arr[i] == arr[i + 
1
])) 

{ 


// double current index value 

arr[i] = 
2
* arr[i]; 


// put 0 in the next index 

arr[i + 
1
] = 
0
; 


// increment by 1 so as to move two 

// indexes ahead during loop iteration 

i++; 

} 

} 


// push all the zeros at 

// the end of 'arr[]' 

pushZerosToEnd(arr, n); 

} 


// function to print the array elements 

static
void
printArray(
int
arr[], 
int
n) 

{ 

for
(
int
i = 
0
; i < n; i++) 

System.out.print(arr[i] + 
" "
); 

System.out.println(); 

} 


// Driver program to test above 

public
static
void
main(String[] args) 

{ 

int
arr[] = { 
0
, 
2
, 
2
, 
2
, 
0
, 
6
, 
6
, 
0
, 
0
, 
8
}; 

int
n = arr.length; 


System.out.print(
"Original array: "
); 

printArray(arr, n); 


modifyAndRearrangeArr(arr, n); 


System.out.print(
"Modified array: "
); 

printArray(arr, n); 

} 
} 

// This code is contributed 
// by prerna saini 