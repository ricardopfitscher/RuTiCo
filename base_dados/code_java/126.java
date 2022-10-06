
/* Program to check for majority element in a sorted array */
import
java.io.*; 

class
Majority { 


static
boolean
isMajority(
int
arr[], 
int
n, 
int
x) 

{ 

int
i, last_index = 
0
; 


/* get last index according to n (even or odd) */

last_index = (n%
2
==
0
)? n/
2
: n/
2
+
1
; 


/* search for first occurrence of x in arr[]*/

for
(i = 
0
; i < last_index; i++) 

{ 

/* check if x is present and is present more 

than n/2 times */

if
(arr[i] == x && arr[i+n/
2
] == x) 

return
true
; 

} 

return
false
; 

} 


/* Driver function to check for above functions*/

public
static
void
main (String[] args) { 

int
arr[] = {
1
, 
2
, 
3
, 
4
, 
4
, 
4
, 
4
}; 

int
n = arr.length; 

int
x = 
4
; 

if
(isMajority(arr, n, x)==
true
) 

System.out.println(x+
" appears more than "
+ 

n/
2
+
" times in arr[]"
); 

else

System.out.println(x+
" does not appear more than "
+ 

n/
2
+
" times in arr[]"
); 

} 
} 
/*This article is contributed by Devesh Agrawal*/