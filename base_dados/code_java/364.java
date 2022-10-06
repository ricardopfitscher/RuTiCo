
// A naive recursive Java program 
// to find maximum tasks. 

class
GFG{ 


// Returns maximum amount of task 

// that can be done till day n 

static
int
maxTasks(
int
high[], 
int
low[], 
int
n) 

{ 


// If n is less than equal to 0, 

// then no solution exists 

if
(n <= 
0
) 

return
0
; 


/* Determines which task to choose on day n, 

then returns the maximum till that day */

return
Math.max(high[n - 
1
] + maxTasks(high, low, (n - 
2
)), 

low[n - 
1
] + maxTasks(high, low, (n - 
1
))); 

} 


// Driver code 

public
static
void
main(String []args) 

{ 

int
n = 
5
; 

int
high[] = {
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
low[] = {
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

System.out.println( maxTasks(high, low, n)); 

} 
} 

// This code is contributed by Ita_c. 