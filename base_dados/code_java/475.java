
// Java program to maximize the sum of difference 
// between consecutive elements in circular array 
import
java.io.*; 
import
java.util.Arrays; 

class
MaxSum 
{ 

// Return the maximum Sum of difference between 

// consecutive elements. 

static
int
maxSum(
int
arr[], 
int
n) 

{ 

int
sum = 
0
; 


// Sorting the array. 

Arrays.sort(arr); 


// Subtracting a1, a2, a3,....., a(n/2)-1, 

// an/2 twice and adding a(n/2)+1, a(n/2)+2, 

// a(n/2)+3,....., an - 1, an twice. 

for
(
int
i = 
0
; i < n/
2
; i++) 

{ 

sum -= (
2
* arr[i]); 

sum += (
2
* arr[n - i - 
1
]); 

} 


return
sum; 

} 


// Driver Program 

public
static
void
main (String[] args) 

{ 

int
arr[] = { 
4
, 
2
, 
1
, 
8
}; 

int
n = arr.length; 

System.out.println(maxSum(arr, n)); 

} 
} 
/*This code is contributed by Prakriti Gupta*/