
// Java program to find maximum revenue 
// by placing billboard on the highway 
// with given constarints. 

class
GFG 
{ 

static
int
maxRevenue(
int
m, 
int
[] x, 

int
[] revenue, 

int
n, 
int
t) 
{ 


// Array to store maximum revenue 

// at each miles. 

int
[] maxRev = 
new
int
[m + 
1
]; 

for
(
int
i = 
0
; i < m + 
1
; i++) 

maxRev[i] = 
0
; 


// actual minimum distance between 

// 2 billboards. 

int
nxtbb = 
0
; 

for
(
int
i = 
1
; i <= m; i++) 

{ 

// check if all billboards are 

// already placed. 

if
(nxtbb < n) 

{ 

// check if we have billboard for 

// that particular mile. If not, 

// copy the previous maximum revenue. 

if
(x[nxtbb] != i) 

maxRev[i] = maxRev[i - 
1
]; 


// we do have billboard for this mile. 

else

{ 

// We have 2 options, we either take 

// current or we ignore current billboard. 


// If current position is less than or 

// equal to t, then we can have only 

// one billboard. 

if
(i <= t) 

maxRev[i] = Math.max(maxRev[i - 
1
], 

revenue[nxtbb]); 


// Else we may have to remove 

// previously placed billboard 

else

maxRev[i] = Math.max(maxRev[i - t - 
1
] + 

revenue[nxtbb], 

maxRev[i - 
1
]); 


nxtbb++; 

} 

} 

else

maxRev[i] = maxRev[i - 
1
]; 

} 


return
maxRev[m]; 
} 

// Driver Code 
public
static
void
main(String []args) 
{ 

int
m = 
20
; 

int
[] x = 
new
int
[]{
6
, 
7
, 
12
, 
13
, 
14
}; 

int
[] revenue = 
new
int
[]{
5
, 
6
, 
5
, 
3
, 
1
}; 

int
n = x.length; 

int
t = 
5
; 

System.out.println(maxRevenue(m, x, revenue, n, t)); 
} 
} 

// This code is contributed by Ita_c. 