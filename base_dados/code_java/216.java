
import
java.util.Stack; 

// Java program to count the number less than N, 
// whose all permutation is greater than or equal to the number. 
class
GFG { 
// Return the count of the number having all 
// permutation greater than or equal to the number. 


static
int
countNumber(
int
n) { 

int
result = 
0
; 


// Pushing 1 to 9 because all number from 1 

// to 9 have this property. 

for
(
int
i = 
1
; i <= 
9
; i++) { 

Stack<Integer> s = 
new
Stack<>(); 

if
(i <= n) { 

s.push(i); 

result++; 

} 


// take a number from stack and add 

// a digit smaller than last digit 

// of it. 

while
(!s.empty()) { 

int
tp = s.peek(); 

s.pop(); 

for
(
int
j = tp % 
10
; j <= 
9
; j++) { 

int
x = tp * 
10
+ j; 

if
(x <= n) { 

s.push(x); 

result++; 

} 

} 

} 

} 


return
result; 

} 

// Driven Program 

public
static
void
main(String[] args) { 

int
n = 
15
; 

System.out.println(countNumber(n)); 


} 
} 

//this code contributed by Rajput-Ji 