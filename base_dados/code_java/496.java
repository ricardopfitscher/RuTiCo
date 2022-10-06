
// Java program to divide n integers 
// in two groups such that absolute 
// difference of their sum is minimum 
import
java.io.*; 
import
java.util.*; 

class
GFG 
{ 

// To print vector along size 

static
void
printVector(Vector<Integer> v) 

{ 

// Print vector size 

System.out.println(v.size()); 


// Print vector elements 

for
(
int
i = 
0
; i < v.size(); i++) 

System.out.print(v.get(i) + 
" "
); 


System.out.println(); 

} 


// To divide n in two groups such that 

// absolute difference of their sum is 

// minimum 

static
void
findTwoGroup(
int
n) 

{ 

// Find sum of all elements upto n 

int
sum = n * (n + 
1
) / 
2
; 


// Sum of elements of group1 

int
group1Sum = sum / 
2
; 


Vector<Integer> group1 = 
new
Vector<Integer>(); 

Vector<Integer> group2 = 
new
Vector<Integer>(); 


for
(
int
i = n; i > 
0
; i--) { 


// If sum is greater then or equal 

// to 0 include i in group1 

// otherwise include in group2 

if
(group1Sum - i >= 
0
) { 


group1.add(i); 


// Decrease sum of group1 

group1Sum -= i; 

} 

else
{ 

group2.add(i); 

} 

} 


// Print both the groups 

printVector(group1); 

printVector(group2); 

} 


// Driver code 

public
static
void
main (String[] args) 

{ 

int
n = 
5
; 

findTwoGroup(n); 

} 
} 

// This code is contributed by Gitanjali. 