
class
SmallestMissing 
{ 

int
findFirstMissing(
int
array[], 
int
start, 
int
end) 

{ 

if
(start > end) 

return
end + 
1
; 


if
(start != array[start]) 

return
start; 


int
mid = (start + end) / 
2
; 


// Left half has all elements from 0 to mid 

if
(array[mid] == mid) 

return
findFirstMissing(array, mid+
1
, end); 


return
findFirstMissing(array, start, mid); 

} 


// Driver program to test the above function 

public
static
void
main(String[] args) 

{ 

SmallestMissing small = 
new
SmallestMissing(); 

int
arr[] = {
0
, 
1
, 
2
, 
3
, 
4
, 
5
, 
6
, 
7
, 
10
}; 

int
n = arr.length; 

System.out.println(
"First Missing element is : "

+ small.findFirstMissing(arr, 
0
, n - 
1
)); 

} 
} 