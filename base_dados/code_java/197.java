
// Java program to print 
// next greater number 
// of Q queries 
import
java.util.*; 

class
GFG 
{ 
public
static
int
[] query(
int
arr[], 

int
query[]) 
{ 

int
ans[] = 
new
int
[arr.length];
// this array contains 

// the next greatest 

// elements of all the elements 

Stack<Integer> s = 
new
Stack<>(); 

// push the 0th index 

// to the stack 

s.push(arr[
0
]); 

int
j = 
0
; 

//traverse rest 

// of the array 

for
(
int
i = 
1
; i < arr.length; i++) 

{ 

int
next = arr[i]; 


if
(!s.isEmpty()) 

{ 

// get the topmost 

// element in the stack 

int
element = s.pop(); 


/* If the popped element 

is smaller than next, 

then a) store the pair 

b) keep popping while 

elements are smaller and 

stack is not empty */

while
(next > element) 

{ 

ans[j] = next; 

j++; 

if
(s.isEmpty()) 

break
; 

element = s.pop(); 

} 


/* If element is greater 

than next, then 

push the element back */

if
(element > next) 

s.push(element); 

} 

/* push next to stack so 

that we can find next 

greater for it */

s.push(next); 

} 

/* After iterating over the 

loop, the remaining elements 

in stack do not have the next 

greater element, so -1 for them */

while
(!s.isEmpty()) 

{ 

int
element = s.pop(); 

ans[j] = -
1
; 

j++; 

} 


// return the next 

// greatest array 

return
ans; 
} 

// Driver Code 
public
static
void
main(String[] args) 
{ 

int
arr[] = {
3
, 
4
, 
2
, 
7
, 

5
, 
8
, 
10
, 
6
}; 

int
query[] = {
3
, 
6
, 
1
}; 

int
ans[] = query(arr,query); 


// getting output array 

// with next greatest elements 

for
(
int
i = 
0
; i < query.length; i++) 

{ 

// displaying the next greater 

// element for given set of queries 

System.out.print(ans[query[i]] + 
" "
); 

} 
} 
} 

// This code was contributed 
// by Harshit Sood 