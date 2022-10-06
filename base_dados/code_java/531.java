
// Java program to Find the repeating 
// and missing elements 

import
java.io.*; 

class
GFG { 


static
void
printTwoElements(
int
arr[], 
int
size) 

{ 

int
i; 

System.out.print(
"The repeating element is "
); 


for
(i = 
0
; i < size; i++) { 

int
abs_val = Math.abs(arr[i]); 

if
(arr[abs_val - 
1
] > 
0
) 

arr[abs_val - 
1
] = -arr[abs_val - 
1
]; 

else

System.out.println(abs_val); 

} 


System.out.print(
"And the missing element is "
); 

for
(i = 
0
; i < size; i++) { 

if
(arr[i] > 
0
) 

System.out.println(i + 
1
); 

} 

} 


// Driver code 

public
static
void
main(String[] args) 

{ 

int
arr[] = { 
7
, 
3
, 
4
, 
5
, 
5
, 
6
, 
2
}; 

int
n = arr.length; 

printTwoElements(arr, n); 

} 
} 

// This code is contributed by Gitanjali 