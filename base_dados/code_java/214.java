
// Java Program to find Right smaller element of next 
// greater element 
import
java.util.Stack; 
public
class
Main { 

// function find Next greater element 

public
static
void
nextGreater(
int
arr[], 
int
next[], 
char
order) 

{ 

// create empty stack 

Stack<Integer> stack=
new
Stack<>(); 


// Traverse all array elements in reverse order 

// order == 'G' we compute next greater elements of 

// every element 

// order == 'S' we compute right smaller element of 

// every element 

for
(
int
i=arr.length-
1
; i>=
0
; i--) 

{ 

// Keep removing top element from S while the top 

// element is smaller then or equal to arr[i] (if Key is G) 

// element is greater then or equal to arr[i] (if order is S) 

while
(!stack.isEmpty() && ((order==
'G'
)? arr[stack.peek()] <= arr[i]:arr[stack.peek()] >= arr[i])) 

stack.pop(); 


// store the next greater element of current element 

if
(!stack.isEmpty()) 

next[i] = stack.peek(); 


// If all elements in S were smaller than arr[i] 

else

next[i] = -
1
; 


// Push this element 

stack.push(i); 

} 

} 


// Function to find Right smaller element of next greater 

// element 

public
static
void
nextSmallerOfNextGreater(
int
arr[]) 

{ 

int
NG[]=
new
int
[arr.length]; 
// stores indexes of next greater elements 

int
RS[]=
new
int
[arr.length]; 
// stores indexes of right smaller elements 


// Find next greater element 

// Here G indicate next greater element 

nextGreater(arr, NG, 
'G'
); 


// Find right smaller element 

// using same function nextGreater() 

// Here S indicate right smaller elements 

nextGreater(arr, RS, 
'S'
); 


// If NG[i] == -1 then there is no smaller element 

// on right side. We can find Right smaller of next 

// greater by arr[RS[NG[i]]] 

for
(
int
i=
0
; i< arr.length; i++) 

{ 

if
(NG[i] != -
1
&& RS[NG[i]] != -
1
) 

System.out.print(arr[RS[NG[i]]]+
" "
); 

else

System.out.print(
"-1 "
); 

} 

} 


public
static
void
main(String args[]) { 

int
arr[] = {
5
, 
1
, 
9
, 
2
, 
5
, 
1
, 
7
}; 

nextSmallerOfNextGreater(arr); 

} 
} 
//This code is contributed by Gaurav Tiwari 