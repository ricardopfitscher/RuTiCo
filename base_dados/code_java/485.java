
// Java program to find possibility to sort 
// by multiple subarray reverse operation 
import
java.util.*; 
class
GFG { 


static
boolean
ifPossible(
int
arr[], 
int
n) 

{ 


// making the copy of the original array 

int
copy[] = Arrays.copyOf(arr, arr.length); 


// sorting the copied array 

Arrays.sort(copy); 


for
(
int
i = 
0
; i < n; i++) { 


// checking mirror image of elements of 

// sorted copy array and equivalent element 

// of original array 

if
(!(arr[i] == copy[i]) && !(arr[n - 
1
- i] == copy[i])) 

return
false
; 

} 


return
true
; 

} 


// driver code 

public
static
void
main(String[] args) 

{ 

int
arr[] = { 
1
, 
7
, 
6
, 
4
, 
5
, 
3
, 
2
, 
8
}; 

int
n = arr.length; 

if
(ifPossible(arr, n)) 

System.out.println(
"Yes"
); 

else

System.out.println(
"No"
); 

} 
} 