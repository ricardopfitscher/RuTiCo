
// Java implementation to check if the given array 
// can represent Level Order Traversal of Binary 
// Search Tree 
import
java.util.*; 

class
Solution 
{ 

// to store details of a node like 
// node's data, 'min' and 'max' to obtain the 
// range of values where node's left and 
// right child's should lie 
static
class
NodeDetails 
{ 

int
data; 

int
min, max; 
}; 

// function to check if the given array 
// can represent Level Order Traversal 
// of Binary Search Tree 
static
boolean
levelOrderIsOfBST(
int
arr[], 
int
n) 
{ 

// if tree is empty 

if
(n == 
0
) 

return
true
; 


// queue to store NodeDetails 

Queue<NodeDetails> q = 
new
LinkedList<NodeDetails>(); 


// index variable to access array elements 

int
i = 
0
; 


// node details for the 

// root of the BST 

NodeDetails newNode=
new
NodeDetails(); 

newNode.data = arr[i++]; 

newNode.min = Integer.MIN_VALUE; 

newNode.max = Integer.MAX_VALUE; 

q.add(newNode); 


// until there are no more elements 

// in arr[] or queue is not empty 

while
(i != n && q.size() > 
0
) 

{ 

// extracting NodeDetails of a 

// node from the queue 

NodeDetails temp = q.peek(); 

q.remove(); 

newNode = 
new
NodeDetails(); 


// check whether there are more elements 

// in the arr[] and arr[i] can be left child 

// of 'temp.data' or not 

if
(i < n && (arr[i] < (
int
)temp.data && 

arr[i] > (
int
)temp.min)) 

{ 

// Create NodeDetails for newNode 

/// and add it to the queue 

newNode.data = arr[i++]; 

newNode.min = temp.min; 

newNode.max = temp.data; 

q.add(newNode); 

} 


newNode=
new
NodeDetails(); 


// check whether there are more elements 

// in the arr[] and arr[i] can be right child 

// of 'temp.data' or not 

if
(i < n && (arr[i] > (
int
)temp.data && 

arr[i] < (
int
)temp.max)) 

{ 

// Create NodeDetails for newNode 

/// and add it to the queue 

newNode.data = arr[i++]; 

newNode.min = temp.data; 

newNode.max = temp.max; 

q.add(newNode); 

} 

} 


// given array represents level 

// order traversal of BST 

if
(i == n) 

return
true
; 


// given array do not represent 

// level order traversal of BST 

return
false
; 
} 

// Driver code 
public
static
void
main(String args[]) 
{ 

int
arr[] = {
7
, 
4
, 
12
, 
3
, 
6
, 
8
, 
1
, 
5
, 
10
}; 

int
n = arr.length; 

if
(levelOrderIsOfBST(arr, n)) 

System.out.print( 
"Yes"
); 

else

System.out.print( 
"No"
); 

} 
} 

// This code is contributed by Arnab Kundu 