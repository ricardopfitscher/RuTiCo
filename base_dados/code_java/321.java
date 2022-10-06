
// Java program to find the maximum 
// sum such that no three are 
// consecutive using recursion. 
import
java.util.Arrays; 

class
GFG 
{ 

static
int
arr[] = {
100
, 
1000
, 
100
, 
1000
, 
1
}; 
static
int
sum[] = 
new
int
[
10000
]; 

// Returns maximum subsequence 
// sum such that no three 
// elements are consecutive 
static
int
maxSumWO3Consec(
int
n) 
{ 

if
(sum[n] != -
1
) 

return
sum[n]; 


//Base cases (process first three elements) 


if
(n == 
0
) 

return
sum[n] = 
0
; 


if
(n == 
1
) 

return
sum[n] = arr[
0
]; 


if
(n == 
2
) 

return
sum[n] = arr[
1
] + arr[
0
]; 


// Process rest of the elements 

// We have three cases 

return
sum[n] = Math.max(Math.max(maxSumWO3Consec(n - 
1
), 

maxSumWO3Consec(n - 
2
) + arr[n - 
1
]), 

arr[n - 
2
] + arr[n - 
1
] + maxSumWO3Consec(n - 
3
)); 


} 

// Driver code 
public
static
void
main(String[] args) 
{ 

int
n = arr.length; 

Arrays.fill(sum, -
1
); 

System.out.println(maxSumWO3Consec(n)); 
} 
} 

// This code is contributed by Rajput-Ji 