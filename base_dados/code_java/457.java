
// Java program to find number of pairs 
// and minimal possible value 
import
java.util.*; 

class
GFG { 


// function for finding pairs and min value 

static
void
pairs(
int
arr[], 
int
n, 
int
k) 

{ 

// initialize smallest and count 

int
smallest = Integer.MAX_VALUE; 

int
count=
0
; 


// iterate over all pairs 

for
(
int
i=
0
; i<n; i++) 

for
(
int
j=i+
1
; j<n; j++) 

{ 

// is abs value is smaller than 

// smallest update smallest and 

// reset count to 1 

if
( Math.abs(arr[i] + arr[j] - k) < 

smallest ) 

{ 

smallest = Math.abs(arr[i] + arr[j] 

- k); 

count = 
1
; 

} 


// if abs value is equal to smallest 

// increment count value 

else
if
(Math.abs(arr[i] + arr[j] - k) 

== smallest) 

count++; 

} 


// print result 

System.out.println(
"Minimal Value = "
+ 

smallest); 

System.out.println(
"Total Pairs = "
+ 

count); 

} 


/* Driver program to test above function */

public
static
void
main(String[] args) 

{ 

int
arr[] = {
3
, 
5
, 
7
, 
5
, 
1
, 
9
, 
9
}; 

int
k = 
12
; 

int
n = arr.length; 

pairs(arr, n, k); 

} 
} 
// This code is contributed by Arnav Kr. Mandal. 