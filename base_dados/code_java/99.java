
// Java program to find intersection of 
// two sorted arrays 

class
FindIntersection 
{ 

/* Function prints Intersection of arr1[] and arr2[] 

m is the number of elements in arr1[] 

n is the number of elements in arr2[] */

static
void
printIntersection(
int
arr1[], 
int
arr2[], 
int
m, 
int
n) 

{ 

int
i = 
0
, j = 
0
; 

while
(i < m && j < n) 

{ 

if
(arr1[i] < arr2[j]) 

i++; 

else
if
(arr2[j] < arr1[i]) 

j++; 

else

{ 

System.out.print(arr2[j++]+
" "
); 

i++; 

} 

} 

} 


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
4
, 
5
, 
6
}; 

int
arr2[] = {
2
, 
3
, 
5
, 
7
}; 

int
m = arr1.length; 

int
n = arr2.length; 

printIntersection(arr1, arr2, m, n); 

} 
} 