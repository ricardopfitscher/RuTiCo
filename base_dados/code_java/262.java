
// A O(1) Java program to 
// find number of strings 
// that can be made under 
// given constraints. 
import
java.io.*; 

class
GFG 
{ 

static
int
countStr(
int
n) 

{ 

return
1
+ (n * 
2
) + 

(n * ((n * n) - 
1
) / 
2
); 

} 

// Driver code 
public
static
void
main (String[] args) 
{ 

int
n = 
3
; 

System.out.println( countStr(n)); 
} 
} 

// This code is contributed by ajit 