
// Java program to count number 
// of strings of n characters with 
import
java.io.*; 

class
GFG 
{ 

// n is total number of characters. 
// bCount and cCount are counts of 'b' 
// and 'c' respectively. 
static
int
countStr(
int
n, 

int
bCount, 

int
cCount) 
{ 

// Base cases 

if
(bCount < 
0
|| cCount < 
0
) 
return
0
; 

if
(n == 
0
) 
return
1
; 

if
(bCount == 
0
&& cCount == 
0
) 
return
1
; 


// Three cases, we choose, a or b or c 

// In all three cases n decreases by 1. 

int
res = countStr(n - 
1
, bCount, cCount); 

res += countStr(n - 
1
, bCount - 
1
, cCount); 

res += countStr(n - 
1
, bCount, cCount - 
1
); 


return
res; 
} 

// Driver code 
public
static
void
main (String[] args) 
{ 

int
n = 
3
; 
// Total number of characters 

System.out.println(countStr(n, 
1
, 
2
)); 
} 
} 

// This code is contributed by akt_mit 