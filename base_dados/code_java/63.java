
// Java program to count 
// the number of indexes 
// in range L R such that 
// Ai=Ai+1 

class
GFG { 

public
static
int
N = 
1000
; 

// Array to store count 
// of index from 0 to 
// i that obey condition 
static
int
prefixans[] = 
new
int
[
1000
]; 

// precomputing prefixans[] array 
public
static
void
countIndex(
int
a[], 
int
n) 
{ 


// traverse to compute 

// the prefixans[] array 

for
(
int
i = 
0
; i < n; i++) { 

if
(i + 
1
< n && a[i] == a[i + 
1
]) 

prefixans[i] = 
1
; 


if
(i != 
0
) 

prefixans[i] += prefixans[i - 
1
]; 

} 
} 

// function that answers 
// every query in O(1) 
public
static
int
answer_query(
int
l, 
int
r) 
{ 

if
(l == 
0
) 

return
prefixans[r - 
1
]; 

else

return
prefixans[r - 
1
] - 

prefixans[l - 
1
]; 
} 

// Driver Code 
public
static
void
main(String args[]) 
{ 

int
a[] = {
1
, 
2
, 
2
, 
2
, 
3
, 
3
, 
4
, 
4
, 
4
}; 

int
n = 
9
; 


// pre-computation 

countIndex(a, n); 


int
L, R; 


// 1-st query 

L = 
1
; 

R = 
8
; 


System.out.println(answer_query(L, R)); 


// 2nd query 

L = 
0
; 

R = 
4
; 

System.out.println(answer_query(L, R)); 
} 
} 

// This code is contributed by Jaideep Pyne 