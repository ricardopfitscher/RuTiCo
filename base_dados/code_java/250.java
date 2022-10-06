
// Java program for a Trie based O(n) solution to 
// find max subarray XOR 
class
GFG 
{ 

// Assumed int size 

static
final
int
INT_SIZE = 
32
; 


// A Trie Node 

static
class
TrieNode 

{ 

int
value; 
// Only used in leaf nodes 

TrieNode[] arr = 
new
TrieNode[
2
]; 

public
TrieNode() { 

value = 
0
; 

arr[
0
] = 
null
; 

arr[
1
] = 
null
; 

} 

} 

static
TrieNode root; 


// Inserts pre_xor to trie with given root 

static
void
insert(
int
pre_xor) 

{ 

TrieNode temp = root; 


// Start from the msb, insert all bits of 

// pre_xor into Trie 

for
(
int
i=INT_SIZE-
1
; i>=
0
; i--) 

{ 

// Find current bit in given prefix 

int
val = (pre_xor & (
1
<<i)) >=
1
? 
1
: 
0
; 


// Create a new node if needed 

if
(temp.arr[val] == 
null
) 

temp.arr[val] = 
new
TrieNode(); 


temp = temp.arr[val]; 

} 


// Store value at leaf node 

temp.value = pre_xor; 

} 


// Finds the maximum XOR ending with last number in 

// prefix XOR 'pre_xor' and returns the XOR of this 

// maximum with pre_xor which is maximum XOR ending 

// with last element of pre_xor. 

static
int
query(
int
pre_xor) 

{ 

TrieNode temp = root; 

for
(
int
i=INT_SIZE-
1
; i>=
0
; i--) 

{ 

// Find current bit in given prefix 

int
val = (pre_xor & (
1
<<i)) >= 
1
? 
1
: 
0
; 


// Traverse Trie, first look for a 

// prefix that has opposite bit 

if
(temp.arr[
1
-val] != 
null
) 

temp = temp.arr[
1
-val]; 


// If there is no prefix with opposite 

// bit, then look for same bit. 

else
if
(temp.arr[val] != 
null
) 

temp = temp.arr[val]; 

} 

return
pre_xor^(temp.value); 

} 


// Returns maximum XOR value of a subarray in 

// arr[0..n-1] 

static
int
maxSubarrayXOR(
int
arr[], 
int
n) 

{ 

// Create a Trie and insert 0 into it 

root = 
new
TrieNode(); 

insert(
0
); 


// Initialize answer and xor of current prefix 

int
result = Integer.MIN_VALUE; 

int
pre_xor =
0
; 


// Traverse all input array element 

for
(
int
i=
0
; i<n; i++) 

{ 

// update current prefix xor and insert it 

// into Trie 

pre_xor = pre_xor^arr[i]; 

insert(pre_xor); 


// Query for current prefix xor in Trie and 

// update result if required 

result = Math.max(result, query(pre_xor)); 


} 

return
result; 

} 


// Driver program to test above functions 

public
static
void
main(String args[]) 

{ 

int
arr[] = {
8
, 
1
, 
2
, 
12
}; 

int
n = arr.length; 

System.out.println(
"Max subarray XOR is "
+ 

maxSubarrayXOR(arr, n)); 

} 
} 
// This code is contributed by Sumit Ghosh 