
// Java implementation of program to find 
// the maximum length that can be removed 
import
java.util.ArrayList; 

public
class
GFG 
{ 

// User defined class Pair 

static
class
Pair{ 

char
first; 

int
second; 

Pair(
char
first, 
int
second){ 

this
.first = first; 

this
.second = second; 

} 

} 


/* Function to find the length of longest 

sub-string that can me make removed 

arr --> pair type of array whose first 

field store character in string 

and second field stores 

corresponding index of that character*/

static
int
longestNull(String str) 

{ 

ArrayList<Pair> arr = 
new
ArrayList<>(); 


// store {'@',-1} in arr , here this value 

// will work as base index 

arr.add(
new
Pair(
'@'
, -
1
)); 


int
maxlen = 
0
; 
// Initialize result 


// one by one iterate characters of string 

for
(
int
i = 
0
; i < str.length(); ++i) 

{ 

// make pair of char and index , then 

// store them into arr 

arr.add(
new
Pair(str.charAt(i), i)); 


// now if last three elements of arr[] 

// are making sub-string "100" or not 

while
(arr.size() >= 
3
&& 

arr.get(arr.size()-
3
).first==
'1'
&& 

arr.get(arr.size()-
2
).first==
'0'
&& 

arr.get(arr.size()-
1
).first==
'0'
) 

{ 

// if above condition is true then 

// delete sub-string "100" from arr[] 

arr.remove(arr.size() - 
3
); 

arr.remove(arr.size() - 
2
); 

arr.remove(arr.size() - 
1
); 

} 


// index of current last element in arr[] 

int
tmp = arr.get(arr.size() - 
1
).second; 


// This is important, here 'i' is the index 

// of current character inserted into arr[] 

// and 'tmp' is the index of last element 

// in arr[] after continuous deletion of 

// sub-string "100" from arr[] till we make 

// it null, difference of these to 'i-tmp' 

// gives the length of current sub-string 

// that can be make null by continuous 

// deletion of sub-string "100" 

maxlen = Math.max(maxlen, i - tmp); 

} 


return
maxlen; 

} 


// Driver program to run the case 

public
static
void
main(String args[]) 

{ 

System.out.println(longestNull(
"1011100000100"
)); 

} 
} 
// This code is contributed by Sumit Ghosh 