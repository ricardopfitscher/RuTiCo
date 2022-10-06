
// Java program to find winner of game 
import
java.io.*; 

class
GFG { 


static
int
winner(
int
a[], 
int
n, 
int
k) 

{ 

// if the number of steps is more then 

// n-1, 

if
(k >= n - 
1
) 

return
n; 


// initially the best is 0 and no of 

// wins is 0. 

int
best = 
0
, times = 
0
; 


// traverse through all the numbers 

for
(
int
i = 
0
; i < n; i++) { 


// if the value of array is more 

// then that of previous best 

if
(a[i] > best) { 


// best is replaced by a[i] 

best = a[i]; 


// if not the first index 

if
(i == 
1
) 


// no of wins is 1 now 

times = 
1
; 

} 


else


// if it wins 

times += 
1
; 


// if any position has more then 

// k wins then return 

if
(times >= k) 

return
best; 

} 


// Maximum element will be winner 

// because we move smaller element 

// at end and repeat the process. 

return
best; 

} 


// driver program to test the above function 

public
static
void
main(String args[]) 

{ 

int
a[] = { 
2
, 
1
, 
3
, 
4
, 
5
}; 

int
n = a.length; 

int
k = 
2
; 


System.out.println(winner(a, n, k)); 

} 
} 

/*This code is contributed by Nikita Tiwari.*/