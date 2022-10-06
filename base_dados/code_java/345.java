
// Java program to write characters in 
// minimum time by inserting, removing 
// and copying operation 

public
class
GFG{ 


// method returns minimum time to write 

// 'N' characters 

static
int
minTimeForWritingChars(
int
N, 
int
insert, 

int
remove, 
int
copy) 

{ 

if
(N == 
0
) 

return
0
; 

if
(N == 
1
) 

return
insert; 


// declare dp array and initialize with zero 

int
dp[] = 
new
int
[N + 
1
]; 



// loop for 'N' number of times 

for
(
int
i = 
1
; i <= N; i++) 

{ 

/* if current char count is even then 

choose minimum from result for (i-1) 

chars and time for insertion and 

result for half of chars and time 

for copy */

if
(i % 
2
== 
0
) 

dp[i] = Math.min(dp[i-
1
] + insert, dp[i/
2
] + copy); 


/* if current char count is odd then 

choose minimum from 

result for (i-1) chars and time for 

insertion and 

result for half of chars and time for 

copy and one extra character deletion*/

else

dp[i] = Math.min(dp[i-
1
] + insert, 

dp[(i+
1
)/
2
] + copy + remove); 

} 

return
dp[N]; 

} 


// Driver code to test above methods 

public
static
void
main(String []args) 

{ 

int
N = 
9
; 

int
insert = 
1
, remove = 
2
, copy = 
1
; 

System.out.println(minTimeForWritingChars(N, insert,remove, copy)); 

} 

// This code is contributed by Ryuga 
} 