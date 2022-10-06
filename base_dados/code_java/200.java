
// Java program to count number of distinct instance 
// where second highest number lie 
// before highest number in all subarrays. 
import
java.util.*; 

class
GFG 
{ 

static
int
MAXN = 
100005
; 

static
class
pair 
{ 

int
first, second; 

public
pair(
int
first, 
int
second) 

{ 

this
.first = first; 

this
.second = second; 

} 
} 
// Finding the next greater element of the array. 
static
void
makeNext(
int
arr[], 
int
n, 
int
nextBig[]) 
{ 

Stack<pair> s = 
new
Stack<>(); 


for
(
int
i = n - 
1
; i >= 
0
; i--) 

{ 


nextBig[i] = i; 

while
(!s.empty() && s.peek().first < arr[i]) 

s.pop(); 


if
(!s.empty()) 

nextBig[i] = s.peek().second; 


s.push(
new
pair(arr[i], i)); 

} 
} 

// Finding the previous greater element of the array. 
static
void
makePrev(
int
arr[], 
int
n, 
int
prevBig[]) 
{ 

Stack<pair> s = 
new
Stack<>(); 

for
(
int
i = 
0
; i < n; i++) 

{ 


prevBig[i] = -
1
; 

while
(!s.empty() && s.peek().first < arr[i]) 

s.pop(); 


if
(!s.empty()) 

prevBig[i] = s.peek().second; 


s.push(
new
pair(arr[i], i)); 

} 
} 

// Wrapper Function 
static
int
wrapper(
int
arr[], 
int
n) 
{ 

int
[]nextBig = 
new
int
[MAXN]; 

int
[]prevBig = 
new
int
[MAXN]; 

int
[]maxi = 
new
int
[MAXN]; 

int
ans = 
0
; 


// Finding previous largest element 

makePrev(arr, n, prevBig); 


// Finding next largest element 

makeNext(arr, n, nextBig); 


for
(
int
i = 
0
; i < n; i++) 

if
(nextBig[i] != i) 

maxi[nextBig[i] - i] = Math.max(maxi[nextBig[i] - i], 

i - prevBig[i]); 


for
(
int
i = 
0
; i < n; i++) 

ans += maxi[i]; 


return
ans; 
} 

// Driver code 
public
static
void
main(String[] args) 
{ 


int
arr[] = { 
1
, 
3
, 
2
, 
4
}; 

int
n = arr.length; 


System.out.println(wrapper(arr, n)); 

} 
} 

// This code is contributed by Princi Singh 