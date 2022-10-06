
// java code to segregate even odd 
// numbers in an array 
public
class
GFG { 


// Function to segregate even 

// odd numbers 

static
void
arrayEvenAndOdd( 

int
arr[], 
int
n) 

{ 


int
i = -
1
, j = 
0
; 

while
(j != n) { 

if
(arr[j] % 
2
== 
0
) 

{ 

i++; 


// Swapping even and 

// odd numbers 

int
temp = arr[i]; 

arr[i] = arr[j]; 

arr[j] = temp; 

} 

j++; 

} 


// Printing segregated array 

for
(
int
k = 
0
; k < n; k++) 

System.out.print(arr[k] + 
" "
); 

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
3
, 
2
, 
4
, 
7
, 

6
, 
9
, 
10
}; 

int
n = arr.length; 

arrayEvenAndOdd(arr, n); 

} 
} 

// This code is contributed by Sam007 