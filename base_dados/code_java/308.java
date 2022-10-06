
// Java program to find nth 
// element of Newman-Conway Sequence 
import
java.io.*; 

class
GFG { 


// Recursion to find 

// n-th element 

static
int
sequence(
int
n) 

{ 

if
(n == 
1
|| n == 
2
) 

return
1
; 

else

return
sequence(sequence(n - 
1
)) 

+ sequence(n - sequence(n - 
1
)); 

} 


// Driver Program 

public
static
void
main(String args[]) 

{ 

int
n = 
10
; 

System.out.println(sequence(n)); 

} 
} 

/*This code is contributed by Nikita Tiwari.*/