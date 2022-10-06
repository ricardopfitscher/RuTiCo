
// Java implementation of 
// above algorithm 
import
java.io.*; 
import
java.util.*; 

public
class
GFG { 


static
int
MaxSumDifference(Integer []a, 
int
n) 

{ 


// final sequence stored in the vector 

List<Integer> finalSequence = 

new
ArrayList<Integer>(); 


// sort the original array 

// so that we can retrieve 

// the large elements from 

// the end of array elements 

Arrays.sort(a); 


// In this loop first we will insert 

// one smallest element not entered 

// till that time in final sequence 

// and then enter a highest element 

// (not entered till that time) in 

// final sequence so that we 

// have large difference value. This 

// process is repeated till all array 

// has completely entered in sequence. 

// Here, we have loop till n/2 because 

// we are inserting two elements at a 

// time in loop. 

for
(
int
i = 
0
; i < n / 
2
; ++i) { 

finalSequence.add(a[i]); 

finalSequence.add(a[n - i - 
1
]); 

} 


// variable to store the 

// maximum sum of absolute 

// difference 

int
MaximumSum = 
0
; 


// In this loop absolute difference 

// of elements for the final sequence 

// is calculated. 

for
(
int
i = 
0
; i < n - 
1
; ++i) { 

MaximumSum = MaximumSum + 

Math.abs(finalSequence.get(i) 

- finalSequence.get(i + 
1
)); 

} 


// absolute difference of last element 

// and 1st element 

MaximumSum = MaximumSum + 

Math.abs(finalSequence.get(n - 
1
) 

- finalSequence.get(
0
)); 


// return the value 

return
MaximumSum; 

} 


// Driver Code 

public
static
void
main(String args[]) 

{ 

Integer []a = { 
1
, 
2
, 
4
, 
8
}; 

int
n = a.length; 


System.out.print(MaxSumDifference(a, n)); 

} 
} 

// This code is contributed by 
// Manish Shaw (manishshaw1) 