
// Java program to find all 
// elements in array which 
// have at-least two greater 
// elements itself. 
import
java.util.*; 
import
java.io.*; 

class
GFG 
{ 

static
void
findElements(
int
arr[], 

int
n) 
{ 

// Pick elements one by one 

// and count greater elements. 

// If count is more than 2, 

// print that element. 

for
(
int
i = 
0
; i < n; i++) 

{ 

int
count = 
0
; 


for
(
int
j = 
0
; j < n; j++) 

if
(arr[j] > arr[i]) 

count++; 


if
(count >= 
2
) 

System.out.print(arr[i] + 
" "
); 

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
2
, -
6
,
3
, 
5
, 
1
}; 

int
n = arr.length; 

findElements(arr, n); 
} 
} 

// This code is contributed by Sahil_Bansall 