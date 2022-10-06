
// Java program to rearrange an 
// array in minimum maximum form 

public
class
Main { 


// Prints max at first position, min at second 

// position second max at third position, second 

// min at fourth position and so on. 

public
static
void
rearrange(
int
arr[], 
int
n) 

{ 

// initialize index of first minimum and first 

// maximum element 

int
max_ele = arr[n - 
1
]; 

int
min_ele = arr[
0
]; 

// traverse array elements 

for
(
int
i = 
0
; i < n; i++) { 

// at even index : we have to put maximum element 

if
(i % 
2
== 
0
) { 

arr[i] = max_ele; 

max_ele -= 
1
; 

} 


// at odd index : we have to put minimum element 

else
{ 

arr[i] = min_ele; 

min_ele += 
1
; 

} 

} 

} 


// Driver code 

public
static
void
main(String args[]) 

{ 

int
arr[] = { 
1
, 
2
, 
3
, 
4
, 
5
, 
6
, 
7
, 
8
, 
9
}; 

int
n = arr.length; 


System.out.println(
"Original Array"
); 

for
(
int
i = 
0
; i < n; i++) 

System.out.print(arr[i] + 
" "
); 


rearrange(arr, n); 


System.out.print(
"\nModified Array\n"
); 

for
(
int
i = 
0
; i < n; i++) 

System.out.print(arr[i] + 
" "
); 

} 
} 