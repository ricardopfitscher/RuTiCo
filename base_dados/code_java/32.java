
// A simple Java program to rearrange contents of arr[] 
// such that arr[j] becomes j if arr[i] is j 
class
RearrangeArray { 

// A simple method to rearrange 'arr[0..n-1]' so that 'arr[j]' 

// becomes 'i' if 'arr[i]' is 'j' 

void
rearrangeNaive(
int
arr[], 
int
n) 

{ 

// Create an auxiliary array of same size 

int
temp[] = 
new
int
[n]; 

int
i; 


// Store result in temp[] 

for
(i = 
0
; i < n; i++) 

temp[arr[i]] = i; 


// Copy temp back to arr[] 

for
(i = 
0
; i < n; i++) 

arr[i] = temp[i]; 

} 


// A utility function to print contents of arr[0..n-1] 

void
printArray(
int
arr[], 
int
n) 

{ 

int
i; 

for
(i = 
0
; i < n; i++) { 

System.out.print(arr[i] + 
" "
); 

} 

System.out.println(
""
); 

} 


// Driver program to test above functions 

public
static
void
main(String[] args) 

{ 

RearrangeArray arrange = 
new
RearrangeArray(); 

int
arr[] = { 
1
, 
3
, 
0
, 
2
}; 

int
n = arr.length; 


System.out.println(
"Given array is "
); 

arrange.printArray(arr, n); 


arrange.rearrangeNaive(arr, n); 


System.out.println(
"Modified array is "
); 

arrange.printArray(arr, n); 

} 
} 