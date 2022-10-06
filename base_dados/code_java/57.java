
class
MaximumSum 
{ 

/*Function to return max sum such that no two elements 

are adjacent */

int
FindMaxSum(
int
arr[], 
int
n) 

{ 

int
incl = arr[
0
]; 

int
excl = 
0
; 

int
excl_new; 

int
i; 


for
(i = 
1
; i < n; i++) 

{ 

/* current max excluding i */

excl_new = (incl > excl) ? incl : excl; 


/* current max including i */

incl = excl + arr[i]; 

excl = excl_new; 

} 


/* return max of incl and excl */

return
((incl > excl) ? incl : excl); 

} 


// Driver program to test above functions 

public
static
void
main(String[] args) 

{ 

MaximumSum sum = 
new
MaximumSum(); 

int
arr[] = 
new
int
[]{
5
, 
5
, 
10
, 
100
, 
10
, 
5
}; 

System.out.println(sum.FindMaxSum(arr, arr.length)); 

} 
} 

// This code has been contributed by Mayank Jaiswal 