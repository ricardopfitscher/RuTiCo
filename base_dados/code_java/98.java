
// Java program to find union of two 
// sorted arrays (Handling Duplicates) 
class
FindUnion 
{ 


static
void
UnionArray(
int
arr1[], 

int
arr2[]) 

{ 

// Taking max element present in either array 

int
m = arr1[arr1.length - 
1
]; 

int
n = arr2[arr2.length - 
1
]; 


int
ans = 
0
; 


if
(m > n) 

{ 

ans = m; 

} 

else

ans = n; 


// Finding elements from 1st array 

// (non duplicates only). Using 

// another array for storing union 

// elements of both arrays 

// Assuming max element present 

// in array is not more than 10^7 

int
newtable[] = 
new
int
[ans + 
1
]; 


// First element is always 

// present in final answer 

System.out.print(arr1[
0
] + 
" "
); 


// Incrementing the First element's count 

// in it's corresponding index in newtable 

++newtable[arr1[
0
]]; 


// Starting traversing the first 

// array from 1st index till last 

for
(
int
i = 
1
; i < arr1.length; i++) 

{ 

// Checking whether current element 

// is not equal to it's previous element 

if
(arr1[i] != arr1[i - 
1
]) 

{ 

System.out.print(arr1[i] + 
" "
); 

++newtable[arr1[i]]; 

} 

} 


// Finding only non common 

// elements from 2nd array 

for
(
int
j = 
0
; j < arr2.length; j++) 

{ 

// By checking whether it's already 

// present in newtable or not 

if
(newtable[arr2[j]] == 
0
) 

{ 

System.out.print(arr2[j] + 
" "
); 

++newtable[arr2[j]]; 

} 

} 

} 


// Driver Code 

public
static
void
main(String args[]) 

{ 

int
arr1[] = {
1
, 
2
, 
2
, 
2
, 
3
}; 

int
arr2[] = {
2
, 
3
, 
4
, 
5
}; 


UnionArray(arr1, arr2); 

} 
} 