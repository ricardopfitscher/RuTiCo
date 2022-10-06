
// Program to find minimum 
// total offerings required 
import
java.io.*; 

class
GFG 
{ 

// Returns minimum 
// offerings required 
static
int
offeringNumber(
int
n, 

int
templeHeight[]) 
{ 

int
sum = 
0
; 
// Initialize result 


// Go through all 

// temples one by one 

for
(
int
i = 
0
; i < n; ++i) 

{ 

// Go to left while 

// height keeps increasing 

int
left = 
0
, right = 
0
; 

for
(
int
j = i - 
1
; j >= 
0
; --j) 

{ 

if
(templeHeight[j] < 

templeHeight[j + 
1
]) 

++left; 

else

break
; 

} 


// Go to right while 

// height keeps increasing 

for
(
int
j = i + 
1
; j < n; ++j) 

{ 

if
(templeHeight[j] < 

templeHeight[j - 
1
]) 

++right; 

else

break
; 

} 


// This temple should offer 

// maximum of two values 

// to follow the rule. 

sum += Math.max(right, left) + 
1
; 

} 


return
sum; 
} 

// Driver code 
public
static
void
main (String[] args) 
{ 
int
arr1[] = {
1
, 
2
, 
2
}; 
System.out.println(offeringNumber(
3
, arr1)); 
int
arr2[] = {
1
, 
4
, 
3
, 

6
, 
2
, 
1
}; 
System.out.println(offeringNumber(
6
, arr2)); 
} 
} 

// This code is contributed by akt_mit 