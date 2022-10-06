
// C# program to find maximum equilibrium sum. 
using
System; 

public
class
GFG { 



// Function to find maximum 

// equilibrium sum. 

static
int
findMaxSum(
int
[]arr, 
int
n) 

{ 


// Array to store prefix sum. 

int
[]preSum = 
new
int
[n]; 


// Array to store suffix sum. 

int
[]suffSum = 
new
int
[n]; 


// Variable to store maximum sum. 

int
ans = 
int
.MinValue; 


// Calculate prefix sum. 

preSum[0] = arr[0]; 

for
(
int
i = 1; i < n; i++) 

preSum[i] = preSum[i - 1] + arr[i]; 


// Calculate suffix sum and compare 

// it with prefix sum. Update ans 

// accordingly. 

suffSum[n - 1] = arr[n - 1]; 


if
(preSum[n - 1] == suffSum[n - 1]) 

ans = Math.Max(ans, preSum[n - 1]); 


for
(
int
i = n - 2; i >= 0; i--) 

{ 

suffSum[i] = suffSum[i + 1] + arr[i]; 


if
(suffSum[i] == preSum[i]) 

ans = Math.Max(ans, preSum[i]); 

} 


return
ans; 

} 


// Driver Code 

static
public
void
Main () 

{ 

int
[]arr = { -2, 5, 3, 1, 2, 6, -4, 2 }; 

int
n = arr.Length; 


Console.WriteLine( findMaxSum(arr, n)); 

} 
} 

// This code is contributed by anuj_67 