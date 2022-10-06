
// java program to find maximum 
// element 

class
Main 
{ 

// function to find the 

// maximum element 

static
int
findMaximum(
int
arr[], 
int
low, 
int
high) 

{ 

int
max = arr[low]; 

int
i; 

for
(i = low; i <= high; i++) 

{ 

if
(arr[i] > max) 

max = arr[i]; 

} 

return
max; 

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
30
, 
40
, 
50
, 
60
, 
70
, 
23
, 
20
}; 

int
n = arr.length; 

System.out.println(
"The maximum element is "
+ 

findMaximum(arr, 
0
, n-
1
)); 

} 
} 