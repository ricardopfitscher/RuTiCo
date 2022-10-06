
// Java program to minimize the 
// cost of array minimization 
import
java.util.Arrays; 

public
class
GFG { 

// Returns minimum possible 
// sum in array B[] 

static
int
minSum(
int
[] A, 
int
n) { 

int
min_val = Arrays.stream(A).min().getAsInt(); 

return
(min_val * (n - 
1
)); 

} 


// Driver Code 

static
public
void
main(String[] args) { 

int
[] A = {
3
, 
6
, 
2
, 
8
, 
7
, 
5
}; 

int
n = A.length; 

System.out.println((minSum(A, n))); 


} 
} 
// This code is contributed by Rajput-Ji 