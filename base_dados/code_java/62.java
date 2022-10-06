
// Java program to count the number of 
// indexes in range L R such that 
// Ai = Ai+1 
class
GFG { 


// function that answers every query 

// in O(r-l) 

static
int
answer_query(
int
a[], 
int
n, 

int
l, 
int
r) 

{ 


// traverse from l to r and count 

// the required indexes 

int
count = 
0
; 

for
(
int
i = l; i < r; i++) 

if
(a[i] == a[i + 
1
]) 

count += 
1
; 


return
count; 

} 


// Driver Code 

public
static
void
main(String[] args) 

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
n = a.length; 


// 1-st query 

int
L, R; 

L = 
1
; 

R = 
8
; 


System.out.println( 

answer_query(a, n, L, R)); 


// 2nd query 

L = 
0
; 

R = 
4
; 

System.out.println( 

answer_query(a, n, L, R)); 

} 
} 

// This code is contribute by 
// Smitha Dinesh Semwal 