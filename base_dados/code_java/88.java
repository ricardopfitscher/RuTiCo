
// Java program to sort an array according absolute 
// difference with x. 
import
java.io.*; 
import
java.util.*; 

class
GFG 
{ 


// Function to sort an array according absolute 

// difference with x. 

static
void
rearrange(
int
[] arr, 
int
n, 
int
x) 

{ 

TreeMap<Integer, ArrayList<Integer>> m = 
new
TreeMap<>(); 


// Store values in a map with the difference 

// with X as key 

for
(
int
i = 
0
; i < n; i++) 

{ 

int
diff = Math.abs(x - arr[i]); 

if
(m.containsKey(diff)) 

{ 

ArrayList<Integer> al = m.get(diff); 

al.add(arr[i]); 

m.put(diff, al); 

} 

else

{ 

ArrayList<Integer> al = 
new
ArrayList<>(); 

al.add(arr[i]); 

m.put(diff,al); 

} 

} 


// Update the values of array 

int
index = 
0
; 

for
(Map.Entry entry : m.entrySet()) 

{ 

ArrayList<Integer> al = m.get(entry.getKey()); 

for
(
int
i = 
0
; i < al.size(); i++) 

arr[index++] = al.get(i); 

} 

} 


// Function to print the array 

static
void
printArray(
int
[] arr, 
int
n) 

{ 

for
(
int
i = 
0
; i < n; i++) 

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
[] arr = {
10
, 
5
, 
3
, 
9
,
2
}; 

int
n = arr.length; 

int
x = 
7
; 

rearrange(arr, n, x); 

printArray(arr, n); 

} 
} 

// This code is contributed by rachana soma 