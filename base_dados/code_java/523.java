
import
java.util.*; 
import
java.lang.*; 
class
Main 
{ 

static
void
minAbsSumPair(
int
arr[], 
int
n) 

{ 

// Variables to keep track of current sum and minimum sum 

int
sum, min_sum = 
999999
; 


// left and right index variables 

int
l = 
0
, r = n-
1
; 


// variable to keep track of the left and right pair for min_sum 

int
min_l = l, min_r = n-
1
; 


/* Array should have at least two elements*/

if
(n < 
2
) 

{ 

System.out.println(
"Invalid Input"
); 

return
; 

} 


/* Sort the elements */

sort(arr, l, r); 


while
(l < r) 

{ 

sum = arr[l] + arr[r]; 


/*If abs(sum) is less then update the result items*/

if
(Math.abs(sum) < Math.abs(min_sum)) 

{ 

min_sum = sum; 

min_l = l; 

min_r = r; 

} 

if
(sum < 
0
) 

l++; 

else

r--; 

} 



System.out.println(
" The two elements whose "
+ 

"sum is minimum are "
+ 

arr[min_l]+ 
" and "
+arr[min_r]); 

} 


// main function 

public
static
void
main (String[] args) 

{ 

int
arr[] = {
1
, 
60
, -
10
, 
70
, -
80
, 
85
}; 

int
n = arr.length; 

minAbsSumPair(arr, n); 

} 


/* Functions for QuickSort */


/* This function takes last element as pivot, 

places the pivot element at its correct 

position in sorted array, and places all 

smaller (smaller than pivot) to left of 

pivot and all greater elements to right 

of pivot */

static
int
partition(
int
arr[], 
int
low, 
int
high) 

{ 

int
pivot = arr[high]; 

int
i = (low-
1
); 
// index of smaller element 

for
(
int
j=low; j<high; j++) 

{ 

// If current element is smaller than or 

// equal to pivot 

if
(arr[j] <= pivot) 

{ 

i++; 


// swap arr[i] and arr[j] 

int
temp = arr[i]; 

arr[i] = arr[j]; 

arr[j] = temp; 

} 

} 


// swap arr[i+1] and arr[high] (or pivot) 

int
temp = arr[i+
1
]; 

arr[i+
1
] = arr[high]; 

arr[high] = temp; 


return
i+
1
; 

} 



/* The main function that implements QuickSort() 

arr[] --> Array to be sorted, 

low --> Starting index, 

high --> Ending index */

static
void
sort(
int
arr[], 
int
low, 
int
high) 

{ 

if
(low < high) 

{ 

/* pi is partitioning index, arr[pi] is 

now at right place */

int
pi = partition(arr, low, high); 


// Recursively sort elements before 

// partition and after partition 

sort(arr, low, pi-
1
); 

sort(arr, pi+
1
, high); 

} 

} 
} 