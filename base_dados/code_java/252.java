
// Java program to count number of substrings 
// with counts of distinct characters as k. 
class
GFG 
{ 

static
int
MAX_CHAR = 
26
; 

// Returns true if all values 
// in freq[] are either 0 or k. 
static
boolean
check(
int
freq[], 
int
k) 
{ 

for
(
int
i = 
0
; i < MAX_CHAR; i++) 

if
(freq[i] !=
0
&& freq[i] != k) 

return
false
; 

return
true
; 
} 

// Returns count of substrings where frequency 
// of every present character is k 
static
int
substrings(String s, 
int
k) 
{ 

int
res = 
0
; 
// Initialize result 


// Pick a starting point 

for
(
int
i = 
0
; i< s.length(); i++) 

{ 


// Initialize all frequencies as 0 

// for this starting point 

int
freq[] = 
new
int
[MAX_CHAR]; 


// One by one pick ending points 

for
(
int
j = i; j<s.length(); j++) 

{ 


// Increment frequency of current char 

int
index = s.charAt(j) - 
'a'
; 

freq[index]++; 


// If frequency becomes more than 

// k, we can't have more substrings 

// starting with i 

if
(freq[index] > k) 

break
; 


// If frequency becomes k, then check 

// other frequencies as well. 

else
if
(freq[index] == k && 

check(freq, k) == 
true
) 

res++; 

} 

} 

return
res; 
} 

// Driver code 
public
static
void
main(String[] args) 
{ 

String s = 
"aabbcc"
; 

int
k = 
2
; 

System.out.println(substrings(s, k)); 


s = 
"aabbc"
; 

k = 
2
; 

System.out.println(substrings(s, k)); 
} 
} 

// This code has been contributed by 29AjayKumar 