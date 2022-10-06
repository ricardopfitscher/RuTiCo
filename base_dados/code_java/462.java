
// Java program to find maximum number of 
// thieves caught 
import
java.util.*; 
import
java.io.*; 

class
GFG 
{ 

// Returns maximum number of thieves 

// that can be caught. 

static
int
policeThief(
char
arr[], 
int
n, 
int
k) 

{ 

int
res = 
0
; 

ArrayList<Integer> thi = 
new
ArrayList<Integer>(); 

ArrayList<Integer> pol = 
new
ArrayList<Integer>(); 


// store indices in the ArrayList 

for
(
int
i = 
0
; i < n; i++) { 

if
(arr[i] == 
'P'
) 

pol.add(i); 

else
if
(arr[i] == 
'T'
) 

thi.add(i); 

} 


// track lowest current indices of 

// thief: thi[l], police: pol[r] 

int
l = 
0
, r = 
0
; 

while
(l < thi.size() && r < pol.size()) { 


// can be caught 

if
(Math.abs(thi.get(l) - pol.get(r)) <= k) { 

res++; 

l++; 

r++; 

} 


// increment the minimum index 

else
if
(thi.get(l) < pol.get(r)) 

l++; 

else

r++; 

} 

return
res; 

} 


// Driver program 

public
static
void
main(String args[]) 

{ 

int
k, n; 

char
arr1[] =
new
char
[] { 
'P'
, 
'T'
, 
'T'
, 

'P'
, 
'T'
}; 

k = 
2
; 

n = arr1.length; 

System.out.println(
"Maximum thieves caught: "

+policeThief(arr1, n, k)); 


char
arr2[] =
new
char
[] { 
'T'
, 
'T'
, 
'P'
, 
'P'
, 

'T'
, 
'P'
}; 

k = 
2
; 

n = arr2.length; 

System.out.println(
"Maximum thieves caught: "

+policeThief(arr2, n, k)); 


char
arr3[] = 
new
char
[]{ 
'P'
, 
'T'
, 
'P'
, 
'T'
, 

'T'
, 
'P'
}; 

k = 
3
; 

n = arr3.length; 

System.out.println(
"Maximum thieves caught: "

+policeThief(arr3, n, k)); 

} 
} 

/* This code is contributed by Danish kaleem */