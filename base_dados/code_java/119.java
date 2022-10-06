
// C# program to find maximum equilibrium sum. 
using
System.Linq; 
using
System; 

class
GFG { 


static
int
Add(
int
x, 
int
y) { 

return
x + y; 

} 


// Function to find maximum equilibrium 

// sum. 

static
int
findMaxSum(
int
[]arr, 
int
n) 

{ 

int
sum = arr.Aggregate(func:Add); 

int
prefix_sum = 0, 

res = 
int
.MinValue; 


for
(
int
i = 0; i < n; i++) 

{ 

prefix_sum += arr[i]; 


if
(prefix_sum == sum) 

res = Math.Max(res, prefix_sum); 

sum -= arr[i]; 

} 


return
res; 

} 


// Driver Code 

public
static
void
Main() 

{ 

int
[]arr = { -2, 5, 3, 1, 

2, 6, -4, 2 }; 

int
n = arr.Length; 

Console.Write(findMaxSum(arr, n)); 

} 
} 

// This code is contributed by Smitha. 