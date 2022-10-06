
// A simple Java program to 
//count pairs with difference k 
import
java.util.*; 
import
java.io.*; 

class
GFG { 


static
int
countPairsWithDiffK(
int
arr[], 

int
n, 
int
k) 

{ 

int
count = 
0
; 


// Pick all elements one by one 

for
(
int
i = 
0
; i < n; i++) 

{ 

// See if there is a pair 

// of this picked element 

for
(
int
j = i + 
1
; j < n; j++) 

if
(arr[i] - arr[j] == k || 

arr[j] - arr[i] == k) 

count++; 

} 

return
count; 

} 


// Driver code 

public
static
void
main(String args[]) 

{ 

int
arr[] = { 
1
, 
5
, 
3
, 
4
, 
2
}; 

int
n = arr.length; 

int
k = 
3
; 

System.out.println(
"Count of pairs with given diff is "

+ countPairsWithDiffK(arr, n, k)); 

} 
} 

// This code is contributed 
// by Sahil_Bansall 