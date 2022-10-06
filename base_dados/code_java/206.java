
// Java program to reverse a string without using stack 
public
class
GFG { 
// A utility function to swap two characters 


static
void
swap(
char
a[], 
int
index1, 
int
index2) { 

char
temp = a[index1]; 

a[index1] = a[index2]; 

a[index2] = temp; 

} 

// A stack based function to reverse a string 

static
void
reverse(
char
str[]) { 

// get size of string 

int
n = str.length, i; 


for
(i = 
0
; i < n / 
2
; i++) { 

swap(str, i, n - i - 
1
); 

} 

} 

// Driver program to test above functions 

public
static
void
main(String[] args) { 

char
str[] = 
"abc"
.toCharArray(); 


reverse(str); 

System.out.printf(
"Reversed string is "
+ String.valueOf(str)); 

} 
} 
// This code is contributed by 29AjayKumar 