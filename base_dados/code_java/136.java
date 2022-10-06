
// Java code to find maximum triplet sum 
import
java.io.*; 
import
java.util.*; 


class
GFG { 


// This function assumes that there are 

// at least three elements in arr[]. 

static
int
maxTripletSum(
int
arr[], 
int
n) 

{ 

// sort the given array 

Arrays.sort(arr); 


// After sorting the array. 

// Add last three element 

// of the given array 

return
arr[n - 
1
] + arr[n - 
2
] + arr[n - 
3
]; 

} 


// Driven code 

public
static
void
main(String args[]) 

{ 

int
arr[] = { 
1
, 
0
, 
8
, 
6
, 
4
, 
2
}; 

int
n = arr.length; 

System.out.println(maxTripletSum(arr, n)); 

} 
} 


// This code is contributed by Nikita Tiwari. 