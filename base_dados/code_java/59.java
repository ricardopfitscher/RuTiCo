
// JAVA Code to find total count of an element 
// in a range 

class
GFG { 


// Returns count of element in arr[left-1..right-1] 

public
static
int
findFrequency(
int
arr[], 
int
n, 

int
left, 
int
right, 

int
element) 

{ 

int
count = 
0
; 

for
(
int
i = left - 
1
; i < right; ++i) 

if
(arr[i] == element) 

++count; 

return
count; 

} 


/* Driver program to test above function */

public
static
void
main(String[] args) 

{ 

int
arr[] = {
2
, 
8
, 
6
, 
9
, 
8
, 
6
, 
8
, 
2
, 
11
}; 

int
n = arr.length; 


// Print frequency of 2 from position 1 to 6 

System.out.println(
"Frequency of 2 from 1 to 6 = "
+ 

findFrequency(arr, n, 
1
, 
6
, 
2
)); 


// Print frequency of 8 from position 4 to 9 

System.out.println(
"Frequency of 8 from 4 to 9 = "
+ 

findFrequency(arr, n, 
4
, 
9
, 
8
)); 


} 

} 
// This code is contributed by Arnav Kr. Mandal. 