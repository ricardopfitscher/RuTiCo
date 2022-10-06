
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
arr_size) 

{ 

int
inv_count = 
0
; 

int
l, r, min_sum, sum, min_l, min_r; 


/* Array should have at least two elements*/

if
(arr_size < 
2
) 

{ 

System.out.println(
"Invalid Input"
); 

return
; 

} 


/* Initialization of values */

min_l = 
0
; 

min_r = 
1
; 

min_sum = arr[
0
] + arr[
1
]; 


for
(l = 
0
; l < arr_size - 
1
; l++) 

{ 

for
(r = l+
1
; r < arr_size; r++) 

{ 

sum = arr[l] + arr[r]; 

if
(Math.abs(min_sum) > Math.abs(sum)) 

{ 

min_sum = sum; 

min_l = l; 

min_r = r; 

} 

} 

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

minAbsSumPair(arr, 
6
); 

} 

} 