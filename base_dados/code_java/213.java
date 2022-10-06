
// Java program to find the difference b/w left and 
// right smaller element of every element in array 
import
java.util.*; 

class
GFG 
{ 


// Function to fill left smaller element for every 

// element of arr[0..n-1]. These values are filled 

// in SE[0..n-1] 

static
void
leftSmaller(
int
arr[], 
int
n, 
int
SE[]) 

{ 

// Create an empty stack 

Stack<Integer> S = 
new
Stack<>(); 


// Traverse all array elements 

// compute nearest smaller elements of every element 

for
(
int
i = 
0
; i < n; i++) 

{ 

// Keep removing top element from S while the top 

// element is greater than or equal to arr[i] 

while
(!S.empty() && S.peek() >= arr[i]) 

{ 

S.pop(); 

} 


// Store the smaller element of current element 

if
(!S.empty()) 

{ 

SE[i] = S.peek(); 

} 

// If all elements in S were greater than arr[i] 

else

{ 

SE[i] = 
0
; 

} 


// Push this element 

S.push(arr[i]); 

} 

} 


// Function returns maximum difference b/w Left & 

// right smaller element 

static
int
findMaxDiff(
int
arr[], 
int
n) 

{ 

int
[] LS = 
new
int
[n]; 
// To store left smaller elements 


// find left smaller element of every element 

leftSmaller(arr, n, LS); 


// find right smaller element of every element 

// first reverse the array and do the same process 

int
[] RRS = 
new
int
[n]; 
// To store right smaller elements in 


// reverse array 

reverse(arr); 

leftSmaller(arr, n, RRS); 


// find maximum absolute difference b/w LS & RRS 

// In the reversed array right smaller for arr[i] is 

// stored at RRS[n-i-1] 

int
result = -
1
; 

for
(
int
i = 
0
; i < n; i++) 

{ 

result = Math.max(result, Math.abs(LS[i] - RRS[n - 
1
- i])); 

} 


// return maximum difference b/w LS & RRS 

return
result; 

} 


static
void
reverse(
int
a[]) 

{ 

int
i, k, n = a.length; 

int
t; 

for
(i = 
0
; i < n / 
2
; i++) 

{ 

t = a[i]; 

a[i] = a[n - i - 
1
]; 

a[n - i - 
1
] = t; 

} 

} 


// Driver code 

public
static
void
main(String args[]) 

{ 

int
arr[] = {
2
, 
4
, 
8
, 
7
, 
7
, 
9
, 
3
}; 

int
n = arr.length; 

System.out.println(
"Maximum diff : "

+ findMaxDiff(arr, n)); 

} 
} 

// This code is contributed by Princi Singh 