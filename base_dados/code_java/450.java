
// Java code to calculate maximum unique 
// element of every segment of array 
import
java.io.*; 
import
java.util.*; 
class
GFG { 


static
void
find_max(
int
[] A, 
int
N, 
int
K) 

{ 

// Storing counts of first K-1 elements 

// Also storing distinct elements. 

HashMap<Integer, Integer> Count = 
new
HashMap<>(); 

for
(
int
i = 
0
; i < K - 
1
; i++) 

if
(Count.containsKey(A[i])) 

Count.put(A[i], 
1
+ Count.get(A[i])); 

else

Count.put(A[i], 
1
); 


TreeSet<Integer> Myset = 
new
TreeSet<Integer>(); 

for
(Map.Entry x : Count.entrySet()) { 

if
(Integer.parseInt(String.valueOf(x.getValue())) == 
1
) 

Myset.add(Integer.parseInt(String.valueOf(x.getKey()))); 

} 


// Before every iteration of this loop, 

// we maintain that K-1 elements of current 

// window are processed. 

for
(
int
i = K - 
1
; i < N; i++) { 


// Process K-th element of current window 

if
(Count.containsKey(A[i])) 

Count.put(A[i], 
1
+ Count.get(A[i])); 

else

Count.put(A[i], 
1
); 


if
(Integer.parseInt(String.valueOf(Count.get(A[i]))) == 
1
) 

Myset.add(A[i]); 

else

Myset.remove(A[i]); 


// If there are no distinct 

// elements in current window 

if
(Myset.size() == 
0
) 

System.out.println(
"Nothing"
); 


// Set is ordered and last element 

// of set gives us maximum element. 

else

System.out.println(Myset.last()); 


// Remove first element of current 

// window before next iteration. 

int
x = A[i - K + 
1
]; 

Count.put(x, Count.get(x) - 
1
); 


if
(Integer.parseInt(String.valueOf(Count.get(x))) == 
1
) 

Myset.add(x); 

if
(Integer.parseInt(String.valueOf(Count.get(x))) == 
0
) 

Myset.remove(x); 

} 

} 


// Driver code 

public
static
void
main(String args[]) 

{ 

int
[] a = { 
1
, 
2
, 
2
, 
3
, 
3
}; 

int
n = a.length; 

int
k = 
3
; 

find_max(a, n, k); 

} 
} 

// This code is contributed by rachana soma 