
// Java program to Split the array and 
// add the first part to the end 
class
Geeks 
{ 

/* Function to reverse arr[] from index start to end*/
static
void
rvereseArray(
int
arr[], 
int
start, 
int
end) 
{ 

while
(start < end) { 

int
temp = arr[start]; 

arr[start] = arr[end]; 

arr[end] = temp; 

start++; 

end--; 

} 
} 

// Function to print an array 
static
void
printArray(
int
arr[], 
int
size) 
{ 

for
(
int
i = 
0
; i < size; i++) 

System.out.print(arr[i] +
" "
); 
} 

/* Function to left rotate arr[] of size n by k */
static
void
splitArr(
int
arr[], 
int
k, 
int
n) 
{ 

rvereseArray(arr, 
0
, n - 
1
); 

rvereseArray(arr, 
0
, n - k - 
1
); 

rvereseArray(arr, n - k, n - 
1
); 
} 

/* Driver program to test above functions */
public
static
void
main(String args[]) 
{ 

int
arr[] = { 
12
, 
10
, 
5
, 
6
, 
52
, 
36
}; 

int
n = arr.length; 

int
k = 
2
; 


// Function calling 

splitArr(arr, k, n); 

printArray(arr, n); 

} 

} 

// This code is contributed by ankita_saini. 