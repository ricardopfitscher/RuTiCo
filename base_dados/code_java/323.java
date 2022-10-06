
// JAVA Code for Maximum length subsequence 
// with difference between adjacent elements 
// as either 0 or 1 
import
java.util.*; 

class
GFG { 


// function to find maximum length subsequence 

// with difference between adjacent elements as 

// either 0 or 1 

public
static
int
maxLenSub(
int
arr[], 
int
n) 

{ 

int
mls[] = 
new
int
[n], max = 
0
; 


// Initialize mls[] values for all indexes 

for
(
int
i = 
0
; i < n; i++) 

mls[i] = 
1
; 


// Compute optimized maximum length 

// subsequence values in bottom up manner 

for
(
int
i = 
1
; i < n; i++) 

for
(
int
j = 
0
; j < i; j++) 

if
(Math.abs(arr[i] - arr[j]) <= 
1

&& mls[i] < mls[j] + 
1
) 

mls[i] = mls[j] + 
1
; 


// Store maximum of all 'mls' values in 'max' 

for
(
int
i = 
0
; i < n; i++) 

if
(max < mls[i]) 

max = mls[i]; 


// required maximum length subsequence 

return
max; 

} 


/* Driver program to test above function */

public
static
void
main(String[] args) 

{ 

int
arr[] = {
2
, 
5
, 
6
, 
3
, 
7
, 
6
, 
5
, 
8
}; 

int
n = arr.length; 

System.out.println(
"Maximum length subsequence = "
+ 

maxLenSub(arr, n)); 


} 
} 

// This code is contributed by Arnav Kr. Mandal. 