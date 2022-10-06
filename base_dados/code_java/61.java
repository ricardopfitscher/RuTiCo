
// Java program to Count elements which 
// divides all numbers in range L-R 
import
java.io.*; 

class
GFG 
{ 

// function to count element 
// Time complexity O(n^2) worst case 
static
int
answerQuery(
int
a[], 
int
n, 

int
l, 
int
r) 
{ 

// answer for query 

int
count = 
0
; 


// 0 based index 

l = l - 
1
; 


// iterate for all elements 

for
(
int
i = l; i < r; i++) 

{ 

int
element = a[i]; 

int
divisors = 
0
; 


// check if the element divides 

// all numbers in range 

for
(
int
j = l; j < r; j++) 

{ 

// no of elements 

if
(a[j] % a[i] == 
0
) 

divisors++; 

else

break
; 

} 


// if all elements are divisible by a[i] 

if
(divisors == (r - l)) 

count++; 

} 


// answer for every query 

return
count; 
} 

// Driver Code 
public
static
void
main (String[] args) 
{ 

int
a[] = { 
1
, 
2
, 
3
, 
5
}; 

int
n = a.length; 


int
l = 
1
, r = 
4
; 

System.out.println( answerQuery(a, n, l, r)); 


l = 
2
; r = 
4
; 

System.out.println( answerQuery(a, n, l, r)); 
} 
} 

// This code is contributed by anuj_67.. 