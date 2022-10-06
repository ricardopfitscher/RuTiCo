
// Java program to find largest pair sum in a given array 

class
Test 
{ 

static
int
arr[] = 
new
int
[]{
12
, 
34
, 
10
, 
6
, 
40
}; 


/* Method to return largest pair sum. Assumes that 

there are at-least two elements in arr[] */

static
int
findLargestSumPair() 

{ 

// Initialize first and second largest element 

int
first, second; 

if
(arr[
0
] > arr[
1
]) 

{ 

first = arr[
0
]; 

second = arr[
1
]; 

} 

else

{ 

first = arr[
1
]; 

second = arr[
0
]; 

} 


// Traverse remaining array and find first and second largest 

// elements in overall array 

for
(
int
i = 
2
; i<arr.length; i ++) 

{ 

/* If current element is greater than first then update both 

first and second */

if
(arr[i] > first) 

{ 

second = first; 

first = arr[i]; 

} 


/* If arr[i] is in between first and second then update second */

else
if
(arr[i] > second && arr[i] != first) 

second = arr[i]; 

} 

return
(first + second); 

} 

// Driver method to test the above function 

public
static
void
main(String[] args) 

{ 


System.out.println(
"Max Pair Sum is "
+ findLargestSumPair()); 


} 
} 