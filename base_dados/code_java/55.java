
// Java program to find smallest and second smallest elements 
import
java.io.*; 

class
SecondSmallest 
{ 

/* Function to print first smallest and second smallest 

elements */

static
void
print2Smallest(
int
arr[]) 

{ 

int
first, second, arr_size = arr.length; 


/* There should be atleast two elements */

if
(arr_size < 
2
) 

{ 

System.out.println(
" Invalid Input "
); 

return
; 

} 


first = second = Integer.MAX_VALUE; 

for
(
int
i = 
0
; i < arr_size ; i ++) 

{ 

/* If current element is smaller than first 

then update both first and second */

if
(arr[i] < first) 

{ 

second = first; 

first = arr[i]; 

} 


/* If arr[i] is in between first and second 

then update second */

else
if
(arr[i] < second && arr[i] != first) 

second = arr[i]; 

} 

if
(second == Integer.MAX_VALUE) 

System.out.println(
"There is no second"
+ 

"smallest element"
); 

else

System.out.println(
"The smallest element is "
+ 

first + 
" and second Smallest"
+ 

" element is "
+ second); 

} 


/* Driver program to test above functions */

public
static
void
main (String[] args) 

{ 

int
arr[] = {
12
, 
13
, 
1
, 
10
, 
34
, 
1
}; 

print2Smallest(arr); 

} 
} 
/*This code is contributed by Devesh Agrawal*/