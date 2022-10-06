
// Java program to calculate max_difference between 
// the sum of two subarrays of length k and N - k 
import
java.util.*; 

class
GFG 
{ 

// Function to calculate max_difference 
static
int
maxDifference(
int
arr[], 
int
N, 
int
k) 
{ 

int
M, S = 
0
, S1 = 
0
, max_difference = 
0
; 


// Sum of the array 

for
(
int
i = 
0
; i < N; i++) 

S += arr[i]; 

int
temp; 


// Sort the array in descending order 

for
(
int
i = 
0
; i < N; i++) 

{ 

for
(
int
j = i + 
1
; j < N; j++) 

{ 

if
(arr[i] < arr[j]) 

{ 

temp = arr[i]; 

arr[i] = arr[j]; 

arr[j] = temp; 

} 

} 

} 


M = Math.max(k, N - k); 

for
(
int
i = 
0
; i < M; i++) 

S1 += arr[i]; 


// Calculating max_difference 

max_difference = S1 - (S - S1); 

return
max_difference; 
} 

// Driver Code 
public
static
void
main(String args[]) 
{ 

int
arr[] = { 
8
, 
4
, 
5
, 
2
, 
10
}; 

int
N = arr.length; 

int
k = 
2
; 

System.out.println(maxDifference(arr, N, k)); 
} 
} 

// This code is contributed by 
// Surendra_Gangwar 