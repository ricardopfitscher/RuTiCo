
class
Pair{ 

int
a; 

int
b; 


public
Pair(
int
a, 
int
b) { 

this
.a = a; 

this
.b = b; 

} 


// This function assumes that arr[] is sorted in increasing order 

// according the first (or smaller) values in pairs. 

static
int
maxChainLength(Pair arr[], 
int
n) 

{ 

int
i, j, max = 
0
; 

int
mcl[] = 
new
int
[n]; 


/* Initialize MCL (max chain length) values for all indexes */

for
( i = 
0
; i < n; i++ ) 

mcl[i] = 
1
; 


/* Compute optimized chain length values in bottom up manner */

for
( i = 
1
; i < n; i++ ) 

for
( j = 
0
; j < i; j++ ) 

if
( arr[i].a > arr[j].b && mcl[i] < mcl[j] + 
1
) 

mcl[i] = mcl[j] + 
1
; 


// mcl[i] now stores the maximum chain length ending with pair i 


/* Pick maximum of all MCL values */

for
( i = 
0
; i < n; i++ ) 

if
( max < mcl[i] ) 

max = mcl[i]; 


return
max; 

} 


/* Driver program to test above function */

public
static
void
main(String[] args) 

{ 

Pair arr[] = 
new
Pair[] {
new
Pair(
5
,
24
), 
new
Pair(
15
, 
25
), 

new
Pair (
27
, 
40
), 
new
Pair(
50
, 
60
)}; 

System.out.println(
"Length of maximum size chain is "
+ 

maxChainLength(arr, arr.length)); 

} 
} 