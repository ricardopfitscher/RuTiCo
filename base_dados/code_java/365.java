
// A DP based Java program to find maximum tasks. 
class
GFG 
{ 

// Returns the maximum among the 2 numbers 
static
int
max(
int
x, 
int
y) 
{ 

return
(x > y ? x : y); 
} 

// Returns maximum amount of task that can be 
// done till day n 
static
int
maxTasks(
int
[]high, 
int
[]low, 
int
n) 
{ 

// An array task_dp that stores the maximum 

// task done 

int
[] task_dp = 
new
int
[n + 
1
]; 


// If n = 0, no solution exists 

task_dp[
0
] = 
0
; 


// If n = 1, high effort task on that day will 

// be the solution 

task_dp[
1
] = high[
0
]; 


// Fill the entire array determining which 

// task to choose on day i 

for
(
int
i = 
2
; i <= n; i++) 

task_dp[i] = Math.max(high[i - 
1
] + task_dp[i - 
2
], 

low[i - 
1
] + task_dp[i - 
1
]); 

return
task_dp[n]; 
} 

// Driver code 
public
static
void
main(String[] args) 
{ 

int
n = 
5
; 

int
[]high = {
3
, 
6
, 
8
, 
7
, 
6
}; 

int
[]low = {
1
, 
5
, 
4
, 
5
, 
3
}; 

System.out.println(maxTasks(high, low, n)); 
} 
} 

// This code is contributed by Code_Mech. 