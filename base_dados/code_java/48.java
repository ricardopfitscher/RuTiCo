
// Sorting based Java program to find 
// all elements in array which have 
// atleast two greater elements itself. 
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

Arrays.sort(arr); 


for
(
int
i = 
0
; i < n - 
2
; i++) 

System.out.print(arr[i] + 
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